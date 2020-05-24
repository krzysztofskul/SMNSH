package pl.krzysztofskul.user.creator;

import java.util.HashMap;
import java.util.Random;

public class Creator {

    public static Creator creator;

    Random random = new Random();

    private HashMap<Integer, String> namesMale = new HashMap<>();

    private HashMap<Integer, String> surnamesMale = new HashMap<>();

    private HashMap<Integer, String> namesFemale = new HashMap<>();

    private HashMap<Integer, String> surnamesFemale = new HashMap<>();

    private Creator() {

        namesMale.put(1, "Adam");
        namesMale.put(2, "Jan");
        namesMale.put(3, "Robert");
        namesMale.put(4, "Marek");
        namesMale.put(5, "Borys");

        surnamesMale.put(1, "Nowakowski");
        surnamesMale.put(2, "Kowalski");
        surnamesMale.put(3, "Kowalewski");
        surnamesMale.put(4, "Przykładowski");
        surnamesMale.put(5, "Testowski");

        namesFemale.put(1, "Anna");
        namesFemale.put(2, "Joanna");
        namesFemale.put(3, "Maria");
        namesFemale.put(4, "Magdalena");
        namesFemale.put(5, "Weronika");

        surnamesFemale.put(1, "Nowakowsksa");
        surnamesFemale.put(2, "Kowalska");
        surnamesFemale.put(3, "Kowalewska");
        surnamesFemale.put(4, "Przykładowska");
        surnamesFemale.put(5, "Testowska");

    }

    public static Creator getCreator() {
        if (creator == null) {
            return new Creator();
        } else {
            return creator;
        }
    }

    public String getRandomNameMale() {
        int x = random.nextInt(namesMale.size())+1;
        return namesMale.get(x);
    }

    public String getRandomSurnameMale() {
        int x = random.nextInt(5)+1;
        return surnamesMale.get(x);
    }

    public String getRandomNameFemale() {
        int x = random.nextInt(namesFemale.size())+1;
        return namesFemale.get(x);
    }

    public String getRandomSurnameFemale() {
        int x = random.nextInt(5)+1;
        return surnamesFemale.get(x);
    }

}