import java.util.Random;

public class Main {
    static String numeFisier1 = "test1_input1.txt";
    static String numeFisier2 = "test1_input2.txt";

    public static void main(String[] args) throws Exception {
        Antrenor antrenor1 = new Antrenor();
        Antrenor antrenor2 = new Antrenor();

        antrenor1.atribuieDate(numeFisier1);
        antrenor2.atribuieDate(numeFisier2);

        Pokemon Neutrel1 = new Pokemon("Neutrel1", 10, 3, 0, 1, 1);
        Pokemon Neutrel2 = new Pokemon("Neutrel2", 20, 4, 0, 1, 1);

        for(int i = 0; i < 3; i++) {
            Random rand = new Random();
            boolean isOver = false;
            do {
                switch (rand.nextInt(3)) {
                    case 0 -> antrenor1.pokemons.get(i).Battle(Neutrel1);
                    case 1 -> antrenor1.pokemons.get(i).Battle(Neutrel2);
                    case 2 -> {
                        antrenor1.pokemons.get(i).Battle(antrenor2.pokemons.get(i));
                        isOver = true;
                    }
                }
                if(isOver)
                    break;

                switch (rand.nextInt(3)) {
                    case 0 -> antrenor2.pokemons.get(i).Battle(Neutrel1);
                    case 1 -> antrenor2.pokemons.get(i).Battle(Neutrel2);
                    case 2 -> {
                        antrenor2.pokemons.get(i).Battle(antrenor1.pokemons.get(i));
                        isOver = true;
                    }
                }
            }while(!isOver);
        }
        antrenor1.TheBest().Battle(antrenor2.TheBest());
    }
}
