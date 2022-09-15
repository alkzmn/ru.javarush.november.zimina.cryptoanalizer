package cryptoanalizer;

import static cryptoanalizer.BruteForce.bruteForce;
import static cryptoanalizer.BruteForce.bruteForceLine;
import static cryptoanalizer.Cipher.*;
import static cryptoanalizer.utils.Printable.*;
import static cryptoanalizer.utils.Scanner.scanInt;

public class Menu {
    public static void chooseMode() {
        System.out.println(CHOOSE_MODE);
        int chosenMode = scanInt();
        switch (chosenMode) {
            case 1: {
                chooseEncodeMode();
                break;
            }
            case 2: {
                chooseDecodeMode();
                break;
            }
            case 3: {
                bruteForceLine();
                break;
            }
            case 4: {
                System.out.println(COME_BACK_SOON);
                break;
            }
            // TODO что если в меню вписывают другое число
        }

    }

    private static void chooseEncodeMode() {
        System.out.println(CHOOSE_ENCODE_MODE);
        int chosenEncodeMode = scanInt();
        switch (chosenEncodeMode) {
            case 1: {
                System.out.println(NICE_CHOICE);
                encodeMessage();
                break;
            }
            case 2: {
                System.out.println(NICE_CHOICE);
               encodeFile();
                break;
            }
            case 3: {
                System.out.println(COME_BACK_SOON);
                break;
            }
            // TODO что если в меню вписывают другое число
        }

    }
    private static void chooseDecodeMode() {
        System.out.println(CHOOSE_DECODE_MODE);
        int chosenEncodeMode = scanInt();
        switch (chosenEncodeMode) {
            case 1: {
                System.out.println(NICE_CHOICE);
                decodeMessage();
                break;
            }
            case 2: {
                System.out.println(NICE_CHOICE);
                decodeFile();
                break;
            }
            case 3: {
                System.out.println(COME_BACK_SOON);
                break;
            }
            // TODO что если в меню вписывают другое число
        }

    }

}
