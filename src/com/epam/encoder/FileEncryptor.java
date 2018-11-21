package com.epam.encoder;

import java.io.*;

public class FileEncryptor {
    private final Encoder encoder;

    public FileEncryptor(String secretWord) {
        this.encoder = new Encoder(secretWord);
    }

    public boolean encodeAndSave(String sourceFile, String targetFile) throws IOException {

        String resultString = "";
        boolean completed = true;

        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile))) {
            String currentString;
            while ((currentString = reader.readLine()) != null) {
                resultString += encoder.encodeString(currentString) + "\r\n";
            }
        } catch (Exception e) {
            resultString = e.getMessage();
            completed = false;
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(targetFile))) {
            writer.write(resultString);
        }catch (Exception e) {
            completed = false;
        }
        return completed;
    }

    public void decodeAndSave(String sourceFile, String targetFile) throws IOException {
        String resultString = "";

        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile))) {
            String currentString;
            while ((currentString = reader.readLine()) != null) {
                resultString += encoder.decodeString(currentString) + "\r\n";
            }
        } catch (Exception e) {
            resultString = e.getMessage();
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(targetFile))) {
            writer.write(resultString);
        }
    }
}
