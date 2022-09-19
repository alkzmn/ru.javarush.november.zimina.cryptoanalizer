package ru.javarush.november.zimina.cryptoanalizer;

import ru.javarush.november.zimina.cryptoanalizer.exception.WrongFilePath;
import ru.javarush.november.zimina.cryptoanalizer.utils.Scanner;

import java.io.*;
import java.util.LinkedHashMap;

import static ru.javarush.november.zimina.cryptoanalizer.utils.Alphabet.createDecodeAlphabet;
import static ru.javarush.november.zimina.cryptoanalizer.utils.Alphabet.createEncodeAlphabet;
import static ru.javarush.november.zimina.cryptoanalizer.utils.Menu.chooseMode;
import static ru.javarush.november.zimina.cryptoanalizer.utils.FilesPaths.createFile;
import static ru.javarush.november.zimina.cryptoanalizer.utils.FilesPaths.getFilePath;
import static ru.javarush.november.zimina.cryptoanalizer.utils.Printable.*;

public class Cipher {
    private static final String WRONG_PATH = "Неверно введен путь";

    public static void encodeMessage() {
        LinkedHashMap<Character, Character> createdAlphabet = createEncodeAlphabet();
        String message = getMessageToEncode();
        char[] messageChar = message.toCharArray();
        for (int i = 0; i < messageChar.length; i++) {
            if (createdAlphabet.containsValue(messageChar[i])) {
                printMessage(createdAlphabet.get(messageChar[i]));
            } else {
                printMessage(messageChar[i]);
            }
        }
        printMessage("\n"+ ALL_IS_ENCODED);
        chooseMode();
    }

    public static void decodeMessage() {
        LinkedHashMap<Character, Character> createdAlphabet = createDecodeAlphabet();
        String message = getMessageToDecode();
        char[] messageChar = message.toCharArray();
        for (int i = 0; i < messageChar.length; i++) {
            if (createdAlphabet.containsValue(messageChar[i])) {
                printMessage(createdAlphabet.get(messageChar[i]));
            } else {
                printMessage(messageChar[i]);
            }
        }
        printMessage("\n"+ALL_IS_DECODED);
        chooseMode();
    }
    public static void encodeFile(){
        try (BufferedReader bufferedReader = new BufferedReader( new FileReader(getFilePath()));
             BufferedWriter bufferedWriter = new BufferedWriter( new FileWriter( createFile()))) {
            LinkedHashMap<Character, Character> createdAlphabet = createEncodeAlphabet();
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
        printMessage(ALL_IS_ENCODED);
    }
    public static void decodeFile(){
        try (BufferedReader bufferedReader = new BufferedReader( new FileReader(getFilePath()));
             BufferedWriter bufferedWriter = new BufferedWriter( new FileWriter( createFile()))) {
            LinkedHashMap<Character, Character> createdAlphabet = createDecodeAlphabet();
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
        printMessage(ALL_IS_DECODED);
    }
    public static void decodeFile(String path, int shift, String chosenAlphabet ){
        try (BufferedReader bufferedReader = new BufferedReader( new FileReader(path));
             BufferedWriter bufferedWriter = new BufferedWriter( new FileWriter(createFile()))) {
            LinkedHashMap<Character, Character> createdAlphabet = createDecodeAlphabet(chosenAlphabet,shift);
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
        printMessage(ALL_IS_DECODED);
    }
    private static String getMessageToEncode() {
        printMessage("Введи текст для шифрования:");
        return Scanner.scanString();
    }
    private static String getMessageToDecode() {
        printMessage("Введи текст для расшифровки:");
        return Scanner.scanString();
    }

}
