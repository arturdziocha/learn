package snippets.overloading;

public class Overloading {
    public static void main(String[] args) {
        
    }
    public static String toString(long num) {
        return new String(num);
    }
        
    public static String toString(int num) {
        return new String(num).toString();
    }
}
