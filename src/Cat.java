/**
 * Created by qiqi on 2016/10/25.
 */
public class Cat extends Pet implements Boardable {
    private String hairLength;
    private Date boardStartDate;
    private Date boardEndDate;

    public Cat(String name, String ownerName, String color, String hairLength) {
        super(name, ownerName, color);
        this.hairLength = hairLength;
    }

    public String getHairLength() {
        return hairLength;
    }

    @Override
    public String toString() {
        return this.getClass().getName().toUpperCase() + ":\n" + super.toString() + "Hair: " + this.getHairLength();
    }

    private class Date{
        private final int month;
        private final int day;
        private final int year;

        public Date(int month, int day, int year) {
            this.month = month;
            this.day = day;
            this.year = year;
        }

        public int compareTo(Date date) {
            if (this.year == date.year && this.month == date.month && this.day == date.day) return 0;
            if (this.year > date.year) return 1;
            else if (this.year < date.year) return -1;
            else {
                if (this.month > date.month) return 1;
                else if (this.month < date.month) return -1;
                else {
                    if (this.day > date.day) return 1;
                    else if (this.day < date.day) return -1;
                }
            }
            return 0;
        }
    }

    public void setBoardStart (int month, int day, int year)throws IllegalInputException{
        if (month < 1 || month > 12 || day < 1 || day > 31 || year > 9999) {
            throw new IllegalInputException();
        } else {
            boardStartDate = new Date(month, day, year);
        }
    }
    public void setBoardEnd(int month, int day, int year)throws IllegalInputException{
        if (month < 1 || month > 12 || day < 1 || day > 31 || year > 9999) {
            throw new IllegalInputException();
        } else {
            boardEndDate = new Date(month, day, year);
        }
    }
    public boolean boarding(int month, int day, int year)throws IllegalInputException{
        if (month < 1 || month > 12 || day < 1 || day > 31 || year > 9999) {
            throw new IllegalInputException();
        } else {
            Date date = new Date(month, day, year);
            int value1 = date.compareTo(boardStartDate);
            int value2 = date.compareTo(boardEndDate);
            if (value1 >= 0 && value2 <= 0) return true;
            else return false;
        }
    }

    public static void main(String[] args) {
        Cat Tom = new Cat("Tom", "Bob", "black","short");
        Tom.setSex(3);
        System.out.println(Tom);
        try {
            Tom.setBoardStart(1,15,2016);
            Tom.setBoardEnd(2,15,2016);
            System.out.println(Tom.boarding(1,31,2016));
        } catch (IllegalInputException ie){
            System.out.println("Invalid input!");
        }
    }
}

