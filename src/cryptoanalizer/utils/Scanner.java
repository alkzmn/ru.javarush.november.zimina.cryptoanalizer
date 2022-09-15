package cryptoanalizer.utils;

public class Scanner {
    public static int scanInt() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int scannedInt = Integer.parseInt(scanner.nextLine());
        return scannedInt;
    }
    public static String scanString() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String scannedString = scanner.nextLine();
        return scannedString;
    }

}
