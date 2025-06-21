package com.sakkkurai.venokUpdates;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class generate_config {

    public static void main(String[] args) {
        // Variables
        int versionCode = 324;
        String downloadLink = "https://github.com/svkkkurai/venok/releases/download/3.2/venok-3.2.apk";
        String fileName = "update.json";

        // Initializing objects
        Gson json = new GsonBuilder().setPrettyPrinting().create();
        Map<String, Object> metadata = new LinkedHashMap<>();
        metadata.put("versionCode", versionCode);
        metadata.put("downloadLink", downloadLink);
        List<String> changelog = new ArrayList<>();
        changelog.add(Changelog.en);
        changelog.add(Changelog.ru);
        changelog.add(Changelog.uk);
        metadata.put("changelog", changelog);
        // Generating JSON file
        String output = json.toJson(metadata);

        try {
            BufferedWriter outputWriter = new BufferedWriter(new FileWriter(fileName));
            outputWriter.append(output);
            System.out.println("Output data: " + output);
            System.out.println("File saved successfully to " + fileName);
            outputWriter.close();
        } catch (IOException e) {
            System.out.println("Can't save file. Error: " + e.toString());
        }
        }
}