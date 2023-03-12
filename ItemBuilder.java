public class ItemBuilder {
    private Item item;

    public ItemBuilder() {
        item = new Item();
    }

    public ItemBuilder name(String name) {
        item.name = name;
        return this;
    }

    public ItemBuilder HP(int HP) {
        item.HP = HP;
        return this;
    }

    public ItemBuilder attack(int attack) {
        item.attack = attack;
        return this;
    }

    public ItemBuilder spAttack(int spAttack) {
        item.spAttack = spAttack;
        return this;
    }

    public ItemBuilder defense(int defense) {
        item.defense = defense;
        return this;
    }

    public ItemBuilder spDefense(int spDefense) {
        item.spDefence = spDefense;
        return this;
    }

    public Item build() {
        return item;
    }
}

