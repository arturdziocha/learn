package hyperskill.strings;

public class ReplaceString {
    public static void main(String[] args) {
        String a = "Jaa";
        System.out.println(a.replace('a', 'b'));
        System.out.println(a.toLowerCase().startsWith("j"));
        
        String s = a.substring(0,1);
        String jChar = "j";
        System.out.println(s.equalsIgnoreCase(jChar));
    }
}
