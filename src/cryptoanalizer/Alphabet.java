package cryptoanalizer;

import java.util.LinkedHashMap;

import static cryptoanalizer.utils.Scanner.scanInt;
import static cryptoanalizer.utils.Scanner.scanString;

public class Alphabet {
    public static final String russianAlphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюя.,\"\":-!?() ";
    public static final String englishAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz.,\"\":-!? ()";

    public static LinkedHashMap<Character, Character> createEncodeAlphabet() {
        String chosenAlphabet = chooseAlphabet();
        int shift = chooseShift(chosenAlphabet);
        char[] keys = chosenAlphabet.toCharArray();
        char[] value = chosenAlphabet.toCharArray();
        if (shift>0 & shift<chosenAlphabet.length()){
            int counter1 = shift;
            int counter2 = 0;
            for (int i = 0; i < keys.length - shift; i++) {
                value[i] = keys[counter1];
                counter1++;
            }
            for (int i = keys.length - shift; i < keys.length; i++) {
                value[i] = keys[counter2];
                counter2++;
            }
        }
        else if (shift<0 & shift>-chosenAlphabet.length()){
            int counter1 = keys.length+shift;
            int counter2 = 0;
            for (int i = 0; i < -shift; i++) {
                keys[counter1] = value[i];
                counter1++;
            }
            for (int i = -shift; i < keys.length; i++) {
                keys[counter2] = value[i];
                counter2++;

            }
        }

        LinkedHashMap<Character, Character> createdAlphabet = new LinkedHashMap<>();
        for (int i = 0; i < keys.length; i++) {
            createdAlphabet.put(keys[i], value[i]);
        }
//        System.out.println(createdAlphabet);
        return createdAlphabet;

    }
    public static LinkedHashMap<Character, Character> createDecodeAlphabet() {
        String chosenAlphabet = chooseAlphabet();
        int shift = chooseShift(chosenAlphabet);
        char[] keys = chosenAlphabet.toCharArray();
        char[] value = chosenAlphabet.toCharArray();
        if (shift>0 & shift<chosenAlphabet.length()){
            int counter1 = shift;
            int counter2 = 0;
            for (int i = 0; i < keys.length - shift; i++) {
                value[i] = keys[counter1];
                counter1++;
            }
            for (int i = keys.length - shift; i < keys.length; i++) {
                value[i] = keys[counter2];
                counter2++;
            }
        }
        else if (shift<0 & shift>-chosenAlphabet.length()){
            int counter1 = keys.length+shift;
            int counter2 = 0;
            for (int i = 0; i < -shift; i++) {
                keys[counter1] = value[i];
                counter1++;
            }
            for (int i = -shift; i < keys.length; i++) {
                keys[counter2] = value[i];
                counter2++;

            }
        }

        LinkedHashMap<Character, Character> createdAlphabet = new LinkedHashMap<>();
        for (int i = 0; i < keys.length; i++) {
            createdAlphabet.put(value[i], keys[i]);
        }
//        System.out.println(createdAlphabet);
        return createdAlphabet;

    }


    public static String chooseAlphabet() {
        System.out.println("Выбери алфавит для использования: " +
                "\n 1 - русский (АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюя.,\"\":-!?() ) " +
                "\n 2 - английский (ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz.,\"\":-!? ())" +
                "\n 3 - собственный (необходимо будет ввести свой алфавит, не менее 3 символов например : абвгдеёжзийклмн ():.,)");
        int chosenAlphabet = scanInt();
        switch (chosenAlphabet) {
            case 1: {
                return russianAlphabet;
            }
            case 2: {
                return englishAlphabet;
            }
            case 3: {
                System.out.println("Неожиданный выбор :) Введи собственный алфавит: не менее 3 символов, символы не должны повторяться \n" +
                        " например : абвгдеёжзийклмн ():.,)");
                return scanString();
            }
            // TODO что если в меню вписывают другое число
        }
        return null;
    }
    public static String chooseBruteForceAlphabet() {
        System.out.println("Выбери алфавит для использования: " +
                "\n 1 - русский (АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюя.,\"\":-!?() ) " +
                "\n 2 - английский (ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz.,\"\":-!? ())");
        int chosenAlphabet = scanInt();
        switch (chosenAlphabet) {
            case 1: {
                return russianAlphabet;
            }
            case 2: {
                return englishAlphabet;
            }
            // TODO что если в меню вписывают другое число
        }
        return null;
    }

        private static int chooseShift (String chosenAlphabet) {
            System.out.println("Введи величину сдвига:");
        int shift = scanInt();
        if (shift>chosenAlphabet.length()){
             return shift%(chosenAlphabet.length());
        } else if (shift<-chosenAlphabet.length()) {
            return shift%(chosenAlphabet.length());

        }
        else if (shift == 0){
            System.out.println("Ты ввел 0, текст останется прежним");
        }
            return shift;
        }


}
