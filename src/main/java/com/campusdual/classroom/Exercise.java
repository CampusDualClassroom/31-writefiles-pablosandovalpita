package com.campusdual.classroom;

import com.campusdual.Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Exercise {

    public static void main(String[] args) {
        String textToSave = generateStringToSave(null);
        printToFile(textToSave);
    }

    public static String generateStringToSave(String string) {
        return (string != null) ? string : generateUserInputToSave();
    }

    public static void printToFile(String string) {
        Path filePath = Path.of("src/main/resources/data.txt");
        try {
            Files.createDirectories(filePath.getParent());
            Files.writeString(filePath, string, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            System.err.println("Error al escribir en el fichero: " + e.getMessage());
        }
    }

    private static String generateUserInputToSave() {
        StringBuilder sb = new StringBuilder();
        System.out.println("Escribe debajo el texto que quieras. Pulsa \"ENTER\" 2 veces seguidas para finalizar:");
        String string;
        while (!(string = Utils.string()).isEmpty()) {
            sb.append(string).append(System.lineSeparator());
        }
        return sb.toString();
    }
}