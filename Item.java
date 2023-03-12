public class Item {
    String name = "";
    int HP = 0;
    int attack = 0;
    int spAttack = 0;
    int defense = 0;
    int spDefence = 0;

    public Item() {
    }

    public Item(String name, int HP, int attack, int spAttack, int defense, int spDefence) {
        this.name = name;
        this.HP = HP;
        this.attack = attack;
        this.spAttack = spAttack;
        this.defense = defense;
        this.spDefence = spDefence;
    }

    public int getHP() {
        return HP;
    }

    public int getAttack() {
        return attack;
    }

    public int getSpAttack() {
        return spAttack;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpDefence() {
        return spDefence;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", HP=" + HP +
                ", attack=" + attack +
                ", spAttack=" + spAttack +
                ", defense=" + defense +
                ", spDefence=" + spDefence +
                '}';
    }
}
