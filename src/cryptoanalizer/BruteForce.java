package cryptoanalizer;

import java.io.*;
import java.util.LinkedHashMap;

import static cryptoanalizer.Alphabet.chooseBruteForceAlphabet;
import static cryptoanalizer.utils.FilesPaths.createFile;
import static cryptoanalizer.utils.FilesPaths.getFilePath;
import static cryptoanalizer.utils.Printable.ALL_IS_ENCODED;

public class BruteForce {

    public static void bruteForce() {


    }

    public static void bruteForceLine() {
        String chosenAlphabet = chooseBruteForceAlphabet();
        char[] keys = chosenAlphabet.toCharArray();
        char[] value = chosenAlphabet.toCharArray();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(getFilePath()));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(createFile()))) {
            for (int i = 0; i < chosenAlphabet.length(); i++) {
                int shift = i;
                int counter1 = shift;
                int counter2 = 0;
                for (int j = 0; j < keys.length - shift; j++) {
                    value[j] = keys[counter1];
                    counter1++;
                }
                for (int k = keys.length - shift; k < keys.length; k++) {
                    value[k] = keys[counter2];
                    counter2++;
                }
                LinkedHashMap<Character, Character> createdAlphabet = new LinkedHashMap<>();
                for (int l = 0; l < keys.length; l++) {
                    createdAlphabet.put(value[l], keys[l]);
                }
                    while (bufferedReader.ready()) {
                        String string = bufferedReader.readLine();
                        char[] chars = string.toCharArray();
                        for (int m = 0; m < chars.length; m++) {
                            char[] firstLine = new char[chars.length];
                            if (createdAlphabet.containsValue(chars[m])) {
                                firstLine[m] = createdAlphabet.get(chars[m]);
                                if (firstLine.toString().contains(". ") | firstLine.toString().contains(", ")
                                        | firstLine.toString().contains(": ") | firstLine.toString().contains("! ")
                                        | firstLine.toString().contains("? ")) {
                                    if (createdAlphabet.containsValue(chars[m])) {
                                        bufferedWriter.write(createdAlphabet.get(chars[m]));
                                    } else {
                                        bufferedWriter.write(chars[m]);
                                    }
                                    bufferedWriter.write("\n");

                                } else break;

                            } else {
                                firstLine[m] = chars[m];
                            }

                        }

                    }



                }
            } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(ALL_IS_ENCODED);
    }


    }

