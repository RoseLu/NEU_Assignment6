/**
 * Created by qiqi on 2016/10/25.
 */
public class Pet {
    private String petName;
    private String ownerName;
    private String petColor;
    public enum Sex{
        MALE, FEMALE, SPAYED, NEUTERED;
    }
    public  final int MALE = 1;
    public  final int FEMALE = 2;
    public  final int SPAYED = 3;
    public  final int NEUTERED = 4;
    protected Sex petSex;

    public Pet(String name, String ownerName, String color) {
        this.petName = name;
        this.ownerName = ownerName;
        this.petColor = color;
    }

    public String getPetName() {
        return petName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getColor() {
        return petColor;
    }

    public void setSex(int sexid) throws IllegalArgumentException{
        try {
            switch (sexid) {
                case MALE:
                    petSex = Sex.MALE;
                    break;
                case FEMALE:
                    petSex = Sex.FEMALE;
                    break;
                case SPAYED:
                    petSex = Sex.SPAYED;
                    break;
                case NEUTERED:
                    petSex = Sex.NEUTERED;
            }
        } catch (IllegalArgumentException ie) {
            System.out.println("Invalid value");
        }
    }

    public String getSex() {
        String sex = petSex.toString();
        sex = sex.substring(0,1) + sex.substring(1, sex.length()).toLowerCase();
        return sex;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(petName + " owned by " + ownerName + "\n");
        sb.append("Color: " + petColor + "\n");
        sb.append("Sex: " + getSex() + "\n");
        return new String(sb);
    }

    public static void main(String[] args) {
        Pet Spot = new Pet("Spot", "Mary", "Black and White");
        Spot.setSex(1);
        System.out.println(Spot);
    }

}

