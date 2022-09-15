package cryptoanalizer;

import java.io.*;
import java.util.LinkedHashMap;

import static cryptoanalizer.Alphabet.createDecodeAlphabet;
import static cryptoanalizer.Alphabet.createEncodeAlphabet;
import static cryptoanalizer.Menu.chooseMode;
import static cryptoanalizer.utils.FilesPaths.createFile;
import static cryptoanalizer.utils.FilesPaths.getFilePath;
import static cryptoanalizer.utils.Scanner.scanString;
public class Cipher {

    public static void encodeMessage() {
        LinkedHashMap<Character, Character> createdAlphabet = createEncodeAlphabet();
        String message = getMessageToEncode();
        char[] messageChar = message.toCharArray();
        for (int i = 0; i < messageChar.length; i++) {
            if (createdAlphabet.containsValue(messageChar[i])) {
                System.out.print(createdAlphabet.get(messageChar[i]));
            } else {
                System.out.print(createdAlphabet.get(messageChar[i]));
            }

        }
        System.out.println("\nЯ все зашифровал :)");
        chooseMode();
    }
    public static void decodeMessage() {
        LinkedHashMap<Character, Character> createdAlphabet = createDecodeAlphabet();
        String message = getMessageToDecode();
        char[] messageChar = message.toCharArray();
        for (int i = 0; i < messageChar.length; i++) {
            if (createdAlphabet.containsValue(messageChar[i])) {
                System.out.print(createdAlphabet.get(messageChar[i]));
            } else {
                System.out.print(createdAlphabet.get(messageChar[i]));
            }


        }
        System.out.println("\nЯ все расшифровал :)");
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
            throw new RuntimeException(e);
        }
        System.out.println("Я все зашифовал, посмотри:)");
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
            throw new RuntimeException(e);
        }
        System.out.println("Я все расшифовал, посмотри:)");
    }
    private static String getMessageToEncode() {
        System.out.println("Введи текст для шифрования:");
        return scanString();
    }
    private static String getMessageToDecode() {
        System.out.println("Введи текст для расшифровки:");
        return scanString();
    }

}
