package ru.javarush.november.zimina.cryptoanalizer.utils;

import ru.javarush.november.zimina.cryptoanalizer.BruteForce;
import ru.javarush.november.zimina.cryptoanalizer.Cipher;

import static ru.javarush.november.zimina.cryptoanalizer.utils.Printable.*;

public class Menu {
    public static void chooseMode() {
        printMessage(CHOOSE_MODE);
        int chosenMode = Scanner.scanInt();
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
                BruteForce.bruteForceLine();
                break;
            }
            case 4: {
                printMessage(COME_BACK_SOON);
                break;
            }
            default: break;
        }

    }

    private static void chooseEncodeMode() {
        printMessage(CHOOSE_ENCODE_MODE);
        int chosenEncodeMode = Scanner.scanInt();
        switch (chosenEncodeMode) {
            case 1: {
                printMessage(NICE_CHOICE);
                Cipher.encodeMessage();
                break;
            }
            case 2: {
                printMessage(NICE_CHOICE);
               Cipher.encodeFile();
                break;
            }
            case 3: {
                printMessage(COME_BACK_SOON);
                break;
            }
            default: break;
        }

    }
    private static void chooseDecodeMode() {
        printMessage(CHOOSE_DECODE_MODE);
        int chosenEncodeMode = Scanner.scanInt();
        switch (chosenEncodeMode) {
            case 1: {
                printMessage(NICE_CHOICE);
                Cipher.decodeMessage();
                break;
            }
            case 2: {
                printMessage(NICE_CHOICE);
                Cipher.decodeFile();
                break;
            }
            case 3: {
                printMessage(COME_BACK_SOON);
                break;
            }
            default: break;
        }

    }

}
