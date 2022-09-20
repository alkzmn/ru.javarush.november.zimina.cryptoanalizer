package ru.javarush.november.zimina.cryptoanalizer;

import ru.javarush.november.zimina.cryptoanalizer.exception.WrongFilePath;

import java.io.*;
import java.util.LinkedHashMap;

import static ru.javarush.november.zimina.cryptoanalizer.utils.Alphabet.*;
import static ru.javarush.november.zimina.cryptoanalizer.Cipher.decodeFile;
import static ru.javarush.november.zimina.cryptoanalizer.utils.FilesPaths.getFilePath;
import static ru.javarush.november.zimina.cryptoanalizer.utils.Printable.printMessage;

public class BruteForce {

    public static void bruteForceLine() {
        String chosenAlphabet = chooseAlphabet();
        String filePath = getFilePath();
        try (BufferedReader bufferedReader = new BufferedReader( new FileReader(filePath))) {
            for (int shift = 0; shift < chosenAlphabet.length(); shift++) {
                LinkedHashMap<Character, Character> createdAlphabet = createDecodeAlphabet(chosenAlphabet,shift);
                bufferedReader.mark(chosenAlphabet.length());
                String line = bufferedReader.readLine();
                bufferedReader.reset();
                char[] chars = line.toCharArray();
                char[] decodedLine = new char[chars.length];
                for (int i = 0; i < chars.length; i++) {
                    if (createdAlphabet.containsValue(chars[i])) {
                        decodedLine[i] = createdAlphabet.get(chars[i]);
                    } else {
                        decodedLine[i] = chars[i];
                    }
                }
                if (checkDecodeLine(String.valueOf(decodedLine))) {
                        printMessage("Величина сдвига:" + shift);
                        decodeFile(filePath,shift, chosenAlphabet);
                        break;
                }
            }
        } catch (IOException e) {
            throw new WrongFilePath("Неверно введен путь");
        }
    }

    private static boolean checkDecodeLine(String decodedLine) {
     if (decodedLine.contains(", ") || decodedLine.contains(". "))
     {
         if (!decodedLine.contains(" ъ") && !decodedLine.contains(" Ъ")&& !decodedLine.contains(".Ъ")&& !decodedLine.contains(".ъ")
                 && !decodedLine.contains("\"Ъ")&& !decodedLine.contains("\"ъ")&& !decodedLine.contains(":Ъ")&& !decodedLine.contains(":ъ")
                 && !decodedLine.contains("-:")&& !decodedLine.contains(":.")&& !decodedLine.contains("--")&& !decodedLine.contains("(,")
                 && !decodedLine.contains(",.")){
             return true;
         }

      }
        return false;
    }
}

