public class MyException extends RuntimeException{
    public String toString(){
        return getClass().getName()+": the sum of your numbers out of integer range";
    }
}
