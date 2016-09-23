package com.company.main.judge;

import com.company.main.contracts.ContentComparer;
import com.company.main.io.OutputWriter;
import com.company.main.staticData.ExceptionMessages;

import java.io.*;
import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.List;

public class Tester implements ContentComparer {
    public  void compareContent(String actualOutput, String expectedOutput) {
        try {
            OutputWriter.writeMessageOnNewLine("Reading files...");
            String mismatchPath = getMismatchPath(expectedOutput);
            List<String> actualOutputString  = readTextFile(actualOutput);
            List<String> expectedOutputString = readTextFile(expectedOutput);
            boolean mismatch = compareStrings(actualOutputString, expectedOutputString, mismatchPath);

            if (mismatch) {
                List<String> mismatchString = readTextFile(mismatchPath);
                mismatchString.forEach(OutputWriter::writeMessageOnNewLine);
            } else {
                OutputWriter.writeMessageOnNewLine("Files are identical.There no mismatches");
            }
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }

    }

    private  boolean compareStrings(List<String> actualOutputString, List<String> expectedOutputString, String mismatchPath) throws AccessDeniedException {
        OutputWriter.writeMessageOnNewLine("Comparing files...");
        String output = "";
        boolean isMismatch = false;

        try {
            FileWriter fileWriter = new FileWriter(mismatchPath);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            int maxLength = Math.max(actualOutputString.size(), expectedOutputString.size());
            for (int i = 0; i < maxLength; i++) {
                String actualLine = actualOutputString.get(i);
                String expextedLine = expectedOutputString.get(i);

                if (!actualLine.equals(expextedLine)) {
                    output = String.format("mismatch -> expected{%s}, actual{%s}%n", expextedLine, actualLine);
                    isMismatch = true;
                } else {
                    output = String.format("line match -> %s%n", actualLine);
                }
                writer.write(output);
            }


            writer.close();

        } catch (IOException e) {
            isMismatch = true;
            throw new AccessDeniedException(ExceptionMessages.CANNOT_ACCESS_FILE);
        } catch (IndexOutOfBoundsException index) {
            isMismatch = true;
            throw new IllegalArgumentException(ExceptionMessages.INVALID_OUTPUT_LENGTH);
        }

        return isMismatch;
    }

    private  List<String> readTextFile(String filePath) throws IOException {
        List<String> text = new ArrayList<>();

        File path = new File(filePath);
        FileReader fileReader = new FileReader(path);
        BufferedReader reader = new BufferedReader(fileReader);
        String line = reader.readLine();

        while (line != null) {
            text.add(line);
            line = reader.readLine();
        }
        reader.close();
        return text;
    }

    private  String getMismatchPath(String expectedOutput) {
        int index = expectedOutput.lastIndexOf("\\");
        String directoryPath = expectedOutput.substring(0, index);
        return directoryPath + "\\mismatch.txt";
    }
}
