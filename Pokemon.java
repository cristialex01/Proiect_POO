import java.util.ArrayList;
import java.util.Random;

public class Pokemon {
    String nume;
    int HP;
    int attack;
    int spAttack;
    int defense;
    int spDefence;
    ArrayList<Ability> spAbilities;
    boolean dodge = false;
    boolean stun = false;
    int cooldown1 = 0;
    int cooldown2 = 0;

    public Pokemon(String nume, int HP, int attack, int spAttack, int defense, int spDefence) {
        this.nume = nume;
        this.HP = HP;
        this.attack = attack;
        this.spAttack = spAttack;
        this.defense = defense;
        this.spDefence = spDefence;
        spAbilities = new ArrayList<>();
    }

    public void addAbility(Ability newAbility){
        spAbilities.add(newAbility);
    }

    public void Attack(Pokemon Pokemon2, int bonusAt){
        if(this.stun){
            this.stun = false;
            return;
        }
        if(Pokemon2.dodge) {
            Pokemon2.dodge = false;
            return;
        }

        if(bonusAt >= 0){
            Pokemon2.HP -= bonusAt;
            return;
        }

        int attackDif;
        if(this.attack != 0) {
            attackDif = this.attack - Pokemon2.defense;
            if (attackDif > 0) {
                Pokemon2.HP -= attackDif;
            }
        }
        else {
            attackDif = this.spAttack - Pokemon2.spDefence;
            if (attackDif > 0) {
                Pokemon2.HP -= attackDif;
            }
        }
    }

    public void Battle(Pokemon Pokemon2){
        Random rand = new Random(3);
        Pokemon allyPokemon = this;
        Pokemon enemyPokemon = Pokemon2;

        Logger log = new Logger();
        log.startMatch(allyPokemon.nume, enemyPokemon.nume);

        while(allyPokemon.HP > 0 && enemyPokemon.HP > 0) {
            boolean allyAttacked = false;
            do {
                switch (rand.nextInt(3)) {
                    case 0 -> {
                        allyPokemon.Attack(enemyPokemon, -1);
                        allyAttacked = true;
                        log.addAttack(0, allyPokemon.nume);
                    }
                    case 1 -> {
                        if (allyPokemon.cooldown1 != 0)
                            break;
                        allyPokemon.Attack(enemyPokemon, allyPokemon.spAbilities.get(0).getDamage());
                        allyPokemon.cooldown1 = allyPokemon.spAbilities.get(0).getCooldown();
                        allyPokemon.dodge = allyPokemon.spAbilities.get(0).isDodge();
                        allyPokemon.stun = allyPokemon.spAbilities.get(0).isStun();
                        allyAttacked = true;
                        log.addAttack(1, allyPokemon.nume);
                    }
                    case 2 -> {
                        if (allyPokemon.cooldown2 != 0)
                            break;
                        allyPokemon.Attack(enemyPokemon, allyPokemon.spAbilities.get(1).getDamage());
                        allyPokemon.cooldown2 = allyPokemon.spAbilities.get(1).getCooldown();
                        allyPokemon.dodge = allyPokemon.spAbilities.get(1).isDodge();
                        enemyPokemon.stun = allyPokemon.spAbilities.get(1).isStun();
                        allyAttacked = true;
                        log.addAttack(2, allyPokemon.nume);
                    }
                }

                log.showHP(allyPokemon);
                log.showHP(enemyPokemon);
                log.showCooldown(1,allyPokemon);
                log.showCooldown(2,allyPokemon);
                log.showCooldown(1,enemyPokemon);
                log.showCooldown(2,enemyPokemon);


                if(allyPokemon.cooldown1 > 0)
                    allyPokemon.cooldown1 --;
                if(allyPokemon.cooldown2 > 0)
                    allyPokemon.cooldown2 --;
                if(enemyPokemon.cooldown1 > 0)
                    enemyPokemon.cooldown1 --;
                if(enemyPokemon.cooldown2 > 0)
                    enemyPokemon.cooldown2 --;
            } while(!allyAttacked);
            boolean enemyAttacked = false;
            do {
                switch (rand.nextInt(3)) {
                    case 0 -> {
                        enemyPokemon.Attack(allyPokemon, -1);
                        enemyAttacked = true;
                        log.addAttack(0, enemyPokemon.nume);
                    }
                    case 1 -> {
                        if (enemyPokemon.cooldown1 != 0 || enemyPokemon.nume.equals("Neutrel1") || enemyPokemon.nume.equals("Neutrel2"))
                            break;
                        enemyPokemon.Attack(allyPokemon, enemyPokemon.spAbilities.get(0).getDamage());
                        enemyPokemon.cooldown1 = enemyPokemon.spAbilities.get(0).getCooldown();
                        enemyPokemon.dodge = enemyPokemon.spAbilities.get(0).isDodge();
                        allyPokemon.stun = enemyPokemon.spAbilities.get(0).isStun();
                        enemyAttacked = true;

                        log.addAttack(1, enemyPokemon.nume);
                    }
                    case 2 -> {
                        if (enemyPokemon.cooldown2 != 0 || enemyPokemon.nume.equals("Neutrel1") || enemyPokemon.nume.equals("Neutrel2"))
                            break;
                        enemyPokemon.Attack(allyPokemon, enemyPokemon.spAbilities.get(1).getDamage());
                        enemyPokemon.cooldown2 = enemyPokemon.spAbilities.get(1).getCooldown();
                        enemyPokemon.dodge = enemyPokemon.spAbilities.get(1).isDodge();
                        enemyPokemon.stun = enemyPokemon.spAbilities.get(1).isStun();
                        enemyAttacked = true;

                        log.addAttack(2, enemyPokemon.nume);
                    }
                }
            } while(!enemyAttacked);

            log.showHP(allyPokemon);
            log.showHP(enemyPokemon);
            log.showCooldown(1,allyPokemon);
            log.showCooldown(2,allyPokemon);
            log.showCooldown(1,enemyPokemon);
            log.showCooldown(2,enemyPokemon);

            if(allyPokemon.cooldown1 > 0)
                allyPokemon.cooldown1 --;
            if(allyPokemon.cooldown2 > 0)
                allyPokemon.cooldown2 --;
            if(enemyPokemon.cooldown1 > 0)
                enemyPokemon.cooldown1 --;
            if(enemyPokemon.cooldown2 > 0)
                enemyPokemon.cooldown2 --;

        }
        if(allyPokemon.HP > 0){
            log.win(allyPokemon);
            this.addSpecialDef(1);
            this.addDef(1);
            if(allyPokemon.attack != 0)
                this.addAttack(1);
            else
                this.addSpecialAttack(1);
            this.addHP(1);
        }
        else if(enemyPokemon.HP > 0){
            log.win(enemyPokemon);
            Pokemon2.addSpecialDef(1);
            Pokemon2.addDef(1);
            if(Pokemon2.attack != 0)
                Pokemon2.addAttack(1);
            else
                Pokemon2.addSpecialAttack(1);
            Pokemon2.addHP(1);
        }
        else
            log.win(null);

        System.out.println(log.getLog());
    }

    public void addHP(int add){
        this.HP += add;
    }

    public void addAttack(int add){
        this.attack += add;
    }

    public void addSpecialAttack(int add){
        this.spAttack += add;
    }

    public void addDef(int add){
        this.defense += add;
    }

    public void addSpecialDef(int add){
        this.spDefence += add;
    }

    public int getAttack() {
        return attack;
    }

    public int getSpAttack() {
        return spAttack;
    }

    public int GetSum(){
        return HP + attack + spAttack + defense + spDefence;
    }

    public String getNume() {
        return nume;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "nume='" + nume + '\'' +
                ", HP=" + HP +
                ", attack=" + attack +
                ", spAttack=" + spAttack +
                ", defense=" + defense +
                ", spDefence=" + spDefence +
                ", spAbilities=" + spAbilities +
                '}';
    }
}