package hyperskill.interfaces;

/*Write a class named AsciiCharSequence that implements compact storage of ASCII-character sequences. Their codes can be stored in one single byte, unlike Unicode characters. Compared to the standard String class, your class will require twice less memory (before Java 9).

The class AsciiCharSequence should:

implement the interface java.lang.CharSequence;
have a constructor that takes a byte array;
define methods length, charAt, subSequence, and toString.
You can see the declaration of methods and their behavior in the description of java.lang.CharSequence (JavaDoc or sources).

Note: the testing system will always pass correct input parameters to overridden methods.

P.S. The feature is supported since Java 9 in standard strings. For details, see this article on compact strings in Java 9.
*/
public class AsciiCharSequence implements CharSequence {
    byte[] arr;

    public AsciiCharSequence(byte[] arr) {
        this.arr = arr;
    }

    @Override
    public char charAt(int index) {
        return (char) arr[index];
    }

    @Override
    public int length() {
        return arr.length;
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return new AsciiCharSequence(java.util.Arrays.copyOfRange(arr, start, end));

        // byte[] rr = new byte[end - start];
        // for (int i = start, j = 0; i < end; i++, j++) {
        // rr[j] = arr[i];
        // }
        // return new AsciiCharSequence(rr);
    }

    @Override
    public String toString() {
        return new String(arr);
    }

}
