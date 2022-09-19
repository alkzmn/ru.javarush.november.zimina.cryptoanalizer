package cryptoanalizer;

import java.io.*;
import java.util.LinkedHashMap;

import static cryptoanalizer.Alphabet.chooseBruteForceAlphabet;
import static cryptoanalizer.Alphabet.createDecodeAlphabet;
import static cryptoanalizer.Cipher.decodeFile;
import static cryptoanalizer.utils.FilesPaths.createFile;
import static cryptoanalizer.utils.FilesPaths.getFilePath;
import static cryptoanalizer.utils.Scanner.scanInt;

public class BruteForce {

    public static void bruteForce() {
        bruteForceLine();


    }

    public static void bruteForceLine() {
        String chosenAlphabet = chooseBruteForceAlphabet();
        String filePath = getFilePath();
        try (BufferedReader bufferedReader = new BufferedReader( new FileReader(filePath))) {
            for (int i = 0; i < chosenAlphabet.length(); i++) {
                int shift = i;
                LinkedHashMap<Character, Character> createdAlphabet = createDecodeAlphabet(chosenAlphabet,i);
                bufferedReader.mark(chosenAlphabet.length());
                String line = bufferedReader.readLine();
                bufferedReader.reset();
                char[] chars = line.toCharArray();
                char[] decodedLine = new char[chars.length];
                for (int m = 0; m < chars.length; m++) {
                    if (createdAlphabet.containsValue(chars[m])) {
                        decodedLine[m] = createdAlphabet.get(chars[m]);
                    } else {
                        decodedLine[m] = chars[m];
                    }
                }
                if (checkDecodeLine(String.valueOf(decodedLine))) {
                    String secondLine = bufferedReader.readLine();
                    char[] chars2 = secondLine.toCharArray();
                    char[] decodedSecondLine = new char[chars2.length];
                    for (int m = 0; m < chars2.length; m++) {
                        if (createdAlphabet.containsValue(chars2[m])) {
                            decodedSecondLine[m] = createdAlphabet.get(chars2[m]);
                        } else {
                            decodedSecondLine[m] = chars2[m];
                        }
                    }
                    if (checkDecodeLine(String.valueOf(decodedSecondLine))) {
                        System.out.println("Величина сдвига:" + shift);
                        decodeFile(filePath,shift, chosenAlphabet);
                        break;
                    }
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean checkDecodeLine(String decodedLine) {
     if (decodedLine.contains(", ") | decodedLine.contains(". "))
     {
         if (!decodedLine.contains(" ъ") & !decodedLine.contains(" Ъ")& !decodedLine.contains(".Ъ")& !decodedLine.contains(".ъ")
                 & !decodedLine.contains("\"Ъ")& !decodedLine.contains("\"ъ")& !decodedLine.contains(":Ъ")& !decodedLine.contains(":ъ")){
             return true;
         }

      }
        return false;
    }
}

