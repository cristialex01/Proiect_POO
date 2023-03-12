public class ItemFactory {
    private ItemFactory() {
    }

    public static Item adaugaItem(String s){
        switch (s){
            case "scut":
                return new ItemBuilder().name("scut").defense(2).spDefense(2).build();
            case "vesta":
                return new ItemBuilder().name("vesta").HP(10).build();
            case "sabiuta":
                return new ItemBuilder().name("sabiuta").attack(3).build();
            case "bagheta magica":
                return new ItemBuilder().name("bagheta magica").spAttack(3).build();
            case "vitamine":
                return new ItemBuilder().name("vitamine").HP(2).attack(2).spAttack(2).build();
            case "brad de craciun":
                return new ItemBuilder().name("brad de craciun").attack(3).defense(1).build();
            case "pelerina":
                return new ItemBuilder().name("pelerina").spDefense(3).build();
        }
        throw new IllegalArgumentException("Obiectul " + s + " nu exista!");
    }
}
