public class Ability {
    int damage;
    boolean stun;
    boolean dodge;
    int cooldown;

    public Ability(int damage, boolean stun, boolean dodge, int cooldown) {
        this.damage = damage;
        this.stun = stun;
        this.dodge = dodge;
        this.cooldown = cooldown;
    }

    public int getDamage() {
        return damage;
    }

    public boolean isStun() {
        return stun;
    }

    public boolean isDodge() {
        return dodge;
    }

    public int getCooldown() {
        return cooldown;
    }

    @Override
    public String toString() {
        return "Ability{" +
                "damage=" + damage +
                ", stun=" + stun +
                ", dodge=" + dodge +
                ", cooldown=" + cooldown +
                '}';
    }
}
