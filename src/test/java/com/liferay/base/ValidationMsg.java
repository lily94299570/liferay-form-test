package com.liferay.base;

import org.testng.Assert;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ValidationMsg {
    public static Messages[] getValidationMsgs(File csv) {
        Assert.assertTrue(csv.exists());

        String[][] msgs = readCSV(csv);

        Messages[] validationMsgs = new Messages[msgs.length];

        for (int i = 0; i < msgs.length; i++) {
            validationMsgs[i] = new Messages();

            String[] columns = msgs[i];

            for (int t = 0; t < columns.length; t++) {
                if (t == 0) {
                    validationMsgs[i].setCondition(columns[t]);
                }
                else if (t == 1) {
                    validationMsgs[i].setValue(columns[t]);
                }
                else if (t == 2) {
                    validationMsgs[i].setPTValue(columns[t]);
                }
            }
        }

        return validationMsgs;
    }

    public static String[][] readCSV(File file) {
        String[] lines = readLinesFromFile(file);

        if ((lines == null) || (lines.length == 0)) {
            return null;
        }

        String[] s = lines[0].split(",");

        String[][] results = new String[lines.length][s.length];

        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];

            String[] columns = line.split(",");

            for (int t = 0; t < columns.length; t++) {
                results[i][t] = columns[t];
            }
        }

        return results;
    }

    public static String[] readLinesFromFile(File file) {
        List<String> lines = new ArrayList<>();
        BufferedReader bufferedReader = null;

        try {
            FileReader fileReader = new FileReader(file);

            bufferedReader = new BufferedReader(fileReader);

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
        }
        catch (Exception exception) {
        }
        finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                }
                catch (Exception exception) {
                }
            }
        }

        return lines.toArray(new String[0]);
    }
}
