package ru.javarush.november.zimina.cryptoanalizer;

import ru.javarush.november.zimina.cryptoanalizer.exception.WrongFilePath;
import ru.javarush.november.zimina.cryptoanalizer.utils.Scanner;

import java.io.*;
import java.util.LinkedHashMap;

import static ru.javarush.november.zimina.cryptoanalizer.utils.Alphabet.createAlphabet;
import static ru.javarush.november.zimina.cryptoanalizer.utils.Menu.chooseMode;
import static ru.javarush.november.zimina.cryptoanalizer.utils.FilesPaths.createFile;
import static ru.javarush.november.zimina.cryptoanalizer.utils.FilesPaths.getFilePath;
import static ru.javarush.november.zimina.cryptoanalizer.utils.Printable.*;

public class Cipher {
    private static final String WRONG_PATH = "Неверно введен путь";

    public static void encodeDecodeMessage(LinkedHashMap<Character, Character> createdAlphabet) {
        String message = getMessage();
        char[] messageChars = message.toCharArray();
        for (int i = 0; i < messageChars.length; i++) {
            if (createdAlphabet.containsValue(messageChars[i])) {
                printMessage(createdAlphabet.get(messageChars[i]));
            } else {
                printMessage(messageChars[i]);
            }
        }
        printText("\n"+ ALL_IS_READY);
        chooseMode();
    }


    public static void encodeDecodeFile(LinkedHashMap<Character, Character> createdAlphabet){
        try (BufferedReader bufferedReader = new BufferedReader( new FileReader(getFilePath()));
             BufferedWriter bufferedWriter = new BufferedWriter( new FileWriter( createFile()))) {

            while (bufferedReader.ready()) {
                String string = bufferedReader.readLine();
                char[] chars = string.toCharArray();
                for (int i = 0; i < chars.length ; i++) {
                    if (createdAlphabet.containsValue(chars[i])){
                        bufferedWriter.write(createdAlphabet.get(chars[i]));
                    }
                    else {
                        bufferedWriter.write(chars[i]);
                    }
                }
                bufferedWriter.write("\n");
                }
            } catch (IOException e) {
            throw new WrongFilePath(WRONG_PATH);
        }

    }


    public static void decodeFile(String path, int shift, String chosenAlphabet ){
        try (BufferedReader bufferedReader = new BufferedReader( new FileReader(path));
             BufferedWriter bufferedWriter = new BufferedWriter( new FileWriter(createFile()))) {
            LinkedHashMap<Character, Character> createdAlphabet = createAlphabet(chosenAlphabet,shift,2);
            while (bufferedReader.ready()) {
                String string = bufferedReader.readLine();
                char[] chars = string.toCharArray();
                for (int i = 0; i < chars.length ; i++) {
                    if (createdAlphabet.containsValue(chars[i])){
                        bufferedWriter.write(createdAlphabet.get(chars[i]));
                    }
                    else {
                        bufferedWriter.write(chars[i]);
                    }
                }
                bufferedWriter.write("\n");
            }
        } catch (IOException e) {
            throw new WrongFilePath(WRONG_PATH);
        }
        printText(ALL_IS_DECODED);
    }


    private static String getMessage() {
        printText("Введи текст:");
        return Scanner.scanString();
    }


}
