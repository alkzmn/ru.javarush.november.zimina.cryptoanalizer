package ru.javarush.november.zimina.cryptoanalizer;

import ru.javarush.november.zimina.cryptoanalizer.utils.Menu;
import ru.javarush.november.zimina.cryptoanalizer.utils.Printable;


public class ApplicationRunner {
    public static void main(String[] args) {

        Printable.printText("Привет:) \nЗдорово, что ты здесь, давай что-нибудь зашифруем или расшифруем!");
        Menu.chooseMode();
    }
}
