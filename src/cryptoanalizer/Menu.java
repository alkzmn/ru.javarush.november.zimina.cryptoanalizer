package cryptoanalizer;

import static cryptoanalizer.Cipher.*;
import static cryptoanalizer.utils.Scanner.scanInt;

public class Menu {
    public static void chooseMode() {
        System.out.println("Выбери режим работы: \n " +
                "1 - Шифрование \n 2 - Дешифровка \n 3 - Взлом шифра \n 4 - Выход");
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
                System.out.println("Отличный выбор!");
                //здесь будет brute force
                break;
            }
            case 4: {
                System.out.println("Возвращайся скорее!");

                break;
            }
            // TODO что если в меню вписывают другое число
        }

    }

    private static void chooseEncodeMode() {
        System.out.println("Выбери режим шифрования: \n " +
                "1 - Шифрование текста из консоли \n 2 - Шифрование файла \n 3 - Выход");
        int chosenEncodeMode = scanInt();
        switch (chosenEncodeMode) {
            case 1: {
                System.out.println("Отличный выбор!");
                encodeMessage();
                break;
            }
            case 2: {
                System.out.println("Отличный выбор!");
               encodeFile();
                break;
            }
            case 3: {
                System.out.println("Возвращайся скорее!");
                break;
            }
            // TODO что если в меню вписывают другое число
        }

    }
    private static void chooseDecodeMode() {
        System.out.println("Выбери режим расшифровки: \n " +
                "1 - Расшифровка текста из консоли \n 2 - Расшифровка файла \n 3 - Выход");
        int chosenEncodeMode = scanInt();
        switch (chosenEncodeMode) {
            case 1: {
                System.out.println("Отличный выбор!");
                decodeMessage();
                break;
            }
            case 2: {
                System.out.println("Отличный выбор!");
                decodeFile();
                break;
            }
            case 3: {
                System.out.println("Возвращайся скорее!");
                break;
            }
            // TODO что если в меню вписывают другое число
        }

    }

}
