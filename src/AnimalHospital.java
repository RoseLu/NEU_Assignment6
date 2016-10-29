import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiqi on 2016/10/26.
 */
public class AnimalHospital {
    private List<Pet> animalList;

    public AnimalHospital(String inputFile) {
        animalList = new ArrayList<>();
    }

    public void printPetInfoByName(String name) {
        for (Pet pet: animalList) {
            if (pet.getPetName().trim().equals(name.trim())) {
                System.out.println(pet.toString());
            }
        }
    }

    public void printPetInforByOwner(String name) {
        for (Pet pet: animalList) {
            if (pet.getOwnerName().trim().equals(name.trim())) {
                System.out.println(pet.toString());
            }
        }
    }

    public void printPetBoarding(int month, int day, int year) {
        try{
            for (Pet pet: animalList) {
                if (pet.getClass().getName().toLowerCase().equals("cat")) {
                    if (((Cat)pet).boarding(month, day, year)) {
                        System.out.println(((Cat)pet).toString());
                    }
                } else if (pet.getClass().getName().toLowerCase().equals("dog")) {
                    if (((Dog) pet).boarding(month, day, year)) {
                        System.out.println(((Dog)pet).toString());
                    }
                }
            }
        } catch (IllegalInputException ie) {
            System.out.println("Invalid input!");
        }
    }

    public static void main(String[] args) {
        AnimalHospital ah = new AnimalHospital("animal hospital");
        Dog rose = new Dog("Puppy","Jacl","white","large");
        rose.setSex(2);
        try {
            rose.setBoardStart(2,3,2016);
            rose.setBoardEnd(5,15,2016);
            ah.animalList.add(rose);
            ah.printPetBoarding(4,1,2016);
        } catch (IllegalInputException ie) {
            System.out.println("invalid input");
        }
    }
}
