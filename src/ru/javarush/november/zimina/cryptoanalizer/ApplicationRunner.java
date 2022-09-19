package ru.javarush.november.zimina.cryptoanalizer;

import ru.javarush.november.zimina.cryptoanalizer.utils.Menu;

import static ru.javarush.november.zimina.cryptoanalizer.utils.Printable.printMessage;

public class ApplicationRunner {
    public static void main(String[] args) {

        printMessage("Привет:) \nЗдорово, что ты здесь, давай что-нибудь зашифруем или расшифруем!");
        Menu.chooseMode();
    }
}
