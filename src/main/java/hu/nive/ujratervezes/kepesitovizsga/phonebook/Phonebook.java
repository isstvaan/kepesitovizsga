package hu.nive.ujratervezes.kepesitovizsga.phonebook;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Map;

public class Phonebook {

    public void exportPhonebook(Map<String, String> contacts, String output) {
        if (contacts == null || !isValidString(output)) {
            throw new IllegalArgumentException("Invalid parameter!");
        }

        String content = getFormattedContent(contacts);

        try {
            Files.write(Path.of(output), content.getBytes());
        } catch (IOException e) {
            throw new IllegalStateException("Can't write file: " + output);
        }
    }

    public void exportPhonebookWithWriter(Map<String, String> contacts, String output) {
        if (contacts == null || !isValidString(output)) {
            throw new IllegalArgumentException("Invalid parameter!");
        }

        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(Path.of( output), StandardOpenOption.CREATE)))) {


            for (Map.Entry<String, String> item : contacts.entrySet()) {
                writer.write(item.getKey());
                writer.write(": ");
                writer.write(item.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't write file", e);
        }




    }

    private String getFormattedContent(Map<String, String> contents) {
        StringBuilder content = new StringBuilder();
        for (Map.Entry<String, String> entry : contents.entrySet()) {
            content.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        return content.toString();
    }

    private boolean isValidString(String str) {
        return str != null && !str.isEmpty();
    }
}
