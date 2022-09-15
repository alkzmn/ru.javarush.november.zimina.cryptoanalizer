package cryptoanalizer.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static cryptoanalizer.utils.Scanner.scanString;

public class FilesPaths {
    public static String createFile() {
        String path;
        try {
            path = String.valueOf(Files.createFile(Path.of(getPathForResult() + scanString()+".txt")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return path;
    }

    private static Path getPathForResult() {
        Path path;
        do {
            System.out.println("Введи путь для сохранения файла");
            path = Path.of(scanString()+ "..//");
        }
        while (checkDirectory(path) == false);
        System.out.println("Введи название файла для сохранения");
        return path;
    }

    public static String getFilePath() {
        Path path;
        do {
            System.out.println("Введи путь к файлу:");
            path = Path.of(scanString());
        }
        while (checkPath(path) == false);
        return path.toString();
    }

    private static boolean checkPath(Path path)  {
        if (Files.notExists(path) == true | Files.isRegularFile(path) == false | path.startsWith("") ==true) {
            System.out.println("Введен некорректный путь к файлу");
            return false;
        }
        return true;
    }
    private static boolean checkDirectory(Path path)  {
        if (Files.exists(path) == false | Files.isDirectory(path) == false) {
            System.out.println("Введен некорректный путь для сохранения");
            return false;
        }
        return true;
    }
}
