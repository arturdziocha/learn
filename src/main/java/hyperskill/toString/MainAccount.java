package hyperskill.toString;

import java.util.Scanner;

/*
 * There is a class named Account. It includes three fields: id, code and balance.

Override the method toString() in this class. The method should return a string representation of an instance of the Account.

Do not make the class public.

Example

Account{id=10, code='123-456-789', balance=2000}
 */
public class MainAccount {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("add");

        String[] parts = scanner.nextLine().split("\\s+");

        long id = Long.parseLong(parts[0]);
        String code = parts[1];
        long balance = Long.parseLong(parts[2]);

        Object acc = new Account(id, code, balance);

        System.out.println(acc.toString());
    }
}

class Account {

    private long id;
    private String code;
    private Long balance;

    public Account(long id, String code, Long balance) {
        this.id = id;
        this.code = code;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return String.format("%s{id=%d, code='%s', balance=%d}", "Account", id, code, balance);
    }
}