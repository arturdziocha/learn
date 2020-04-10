package hyperskill.projects.encryptdecrypt.stage1;

import java.util.Scanner;
import java.util.stream.Collectors;

/*
In this stage, you need to support decryption in your program. The decryption is simply the inverse of encryption, following the same steps but reversing the order in which the keys are applied.

Write a program that reads three lines from the standard input: a target operation (enc - encryption, dec - decryption), a message or a cyphertext, and a key to encrypt/decrypt messages. All non-letter characters must be encrypted as well as regular letters. We recommend you to get an integer representation of each character (according to the Unicode table) to shift it.

Decompose your program using methods to make it easy to understand and edit later. One method should encrypt a message and another one should decrypt it according to a key.

Encryption input example
enc
Welcome to hyperskill!
5
Encryption output example
\jqhtrj%yt%m~ujwxpnqq&
Decryption input example
dec
\jqhtrj%yt%m~ujwxpnqq&
5
Decryption output example
Welcome to hyperskill!
 */
public class Stage3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add");
        String encDec = scanner.nextLine();
        String line = scanner.nextLine();
        int move = Integer.parseInt(scanner.nextLine());
        System.out.println(
                line.chars()
                        .map(c -> encDec.equals("enc") ? c + move : c - move)
                        .mapToObj(s->String.valueOf((char)s))
                        .collect(Collectors.joining()));
    }
}
