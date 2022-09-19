package ru.javarush.november.zimina.cryptoanalizer.exception;

public class WrongFilePath extends RuntimeException{
    public WrongFilePath(String message) {
        super(message);
    }
}
