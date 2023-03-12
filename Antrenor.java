import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Antrenor{
    String nume;
    int varsta;
    ArrayList<Pokemon> pokemons;
    ArrayList<Item> items;

    public Antrenor() {
        pokemons = new ArrayList<>();
        items = new ArrayList<>();
    }

    public void addPokemon(Pokemon newPokemon){
        pokemons.add(newPokemon);
    }

    public void addItem(Item newItem){
        items.add(newItem);
    }

    public void atribuieDate(String fileName){
        try {
            File file = new File(fileName);
            Scanner scan = new Scanner(file);

            //Adaug la antrenor numele si varsta
            nume = scan.nextLine();
            varsta = scan.nextInt();
            scan.nextLine();

            //Adaug la antrenor cei 3 pokemoni
            for (int i = 0; i < 3; i++) {
                String input = scan.nextLine();     //citesc un pokemon
                String[] splitInput = input.split(" ");
                Pokemon newPokemon = new Pokemon(splitInput[0], Integer.parseInt(splitInput[1]),
                        Integer.parseInt(splitInput[2]), Integer.parseInt(splitInput[3]),
                        Integer.parseInt(splitInput[4]), Integer.parseInt(splitInput[5]));
                input = scan.nextLine();     //citesc prima abilitate speciala
                splitInput = input.split(" ");
                newPokemon.addAbility(new Ability(Integer.parseInt(splitInput[0]), Boolean.parseBoolean(splitInput[1]),
                        Boolean.parseBoolean(splitInput[2]), Integer.parseInt(splitInput[3])));
                input = scan.nextLine();     //citesc a doua abilitate speciala
                splitInput = input.split(" ");
                newPokemon.addAbility(new Ability(Integer.parseInt(splitInput[0]), Boolean.parseBoolean(splitInput[1]),
                        Boolean.parseBoolean(splitInput[2]), Integer.parseInt(splitInput[3])));
                addPokemon(newPokemon);
            }

            //Adaug itemele antrenorului
            for (int i = 0; i < 3; i++) {

                String input = scan.nextLine();
                addItem(ItemFactory.adaugaItem(input));
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File not found!");
            e.printStackTrace();
        }

        //Atribui itemele fiecarui pokemon
        for(int i = 0; i < 3; i++){
            if(items.get(i).getHP() != 0)
                for(int j = 0; j < 3; j++)
                    pokemons.get(j).addHP(items.get(i).getHP());
            if(items.get(i).getAttack() != 0)
                for(int j = 0; j < 3; j++)
                    if(pokemons.get(j).getAttack() != 0)
                        pokemons.get(j).addAttack(items.get(i).getAttack());
            if(items.get(i).getSpAttack() != 0)
                for(int j = 0; j < 3; j++)
                    if(pokemons.get(j).getSpAttack() != 0)
                        pokemons.get(j).addSpecialAttack(items.get(i).getSpAttack());
            if(items.get(i).getDefense() != 0)
                for(int j = 0; j < 3; j++)
                    pokemons.get(j).addDef(items.get(i).getDefense());
            if(items.get(i).getSpDefence() != 0)
                for(int j = 0; j < 3; j++)
                    pokemons.get(j).addSpecialDef(items.get(i).getSpDefence());
        }
    }

    public Pokemon TheBest() throws Exception {
        int sum1, sum2, sum3;
        sum1 = pokemons.get(0).GetSum();
        sum2 = pokemons.get(1).GetSum();
        sum3 = pokemons.get(2).GetSum();
        if(sum1 > sum2 && sum1 > sum3)
            return pokemons.get(0);
        if(sum2 > sum1 && sum2 > sum3)
            return pokemons.get(1);
        if(sum3 > sum1 && sum3 > sum2)
            return pokemons.get(2);
        if(sum1 == sum2 && sum1 > sum3)
            if(pokemons.get(0).getNume().compareTo(pokemons.get(1).getNume()) < 0)
                return pokemons.get(0);
            else
                return pokemons.get(1);
        if (sum1 == sum3 && sum1 > sum2)
            if(pokemons.get(0).getNume().compareTo(pokemons.get(2).getNume()) < 0)
                return pokemons.get(0);
            else
                return pokemons.get(2);
        if(sum2 == sum3 && sum2 > sum1)
            if(pokemons.get(1).getNume().compareTo(pokemons.get(2).getNume()) < 0)
                return pokemons.get(1);
            else
                return pokemons.get(2);
        if(sum1 == sum2 && sum1 == sum3){
            if(pokemons.get(0).getNume().compareTo(pokemons.get(1).getNume()) < 0 && pokemons.get(0).getNume().compareTo(pokemons.get(2).getNume()) < 0)
                return pokemons.get(0);
            if(pokemons.get(1).getNume().compareTo(pokemons.get(2).getNume()) < 0 && pokemons.get(1).getNume().compareTo(pokemons.get(0).getNume()) < 0)
                return pokemons.get(1);
            if(pokemons.get(2).getNume().compareTo(pokemons.get(1).getNume()) < 0 && pokemons.get(2).getNume().compareTo(pokemons.get(0).getNume()) < 0)
                return pokemons.get(2);
        }
        throw new Exception("Nu s-a gasit un minim!");
    }

    @Override
    public String toString() {
        return "Antrenor{" +
                "nume='" + nume + '\'' +
                ", varsta=" + varsta +
                ", pokemons=" + pokemons +
                ", items=" + items +
                '}';
    }
}
