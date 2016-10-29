/**
 * Created by qiqi on 2016/10/25.
 */
public interface Boardable {
    public void setBoardStart (int month, int day, int year)throws IllegalInputException;
    public void setBoardEnd(int month, int day, int year) throws IllegalInputException;
    public boolean boarding(int month, int day, int year) throws IllegalInputException;
}
class IllegalInputException extends Exception {

}
