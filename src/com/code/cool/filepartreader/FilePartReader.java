package com.code.cool.filepartreader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FilePartReader {

    private String filePath;
    private Integer fromLine;
    private Integer toLine;

    public FilePartReader() {
        this.filePath = "/static/read.txt";
        this.fromLine = 2;
        this.toLine = 0;
    }

    public void setup(String filePath, Integer fromLine, Integer toLine) {
        this.filePath = filePath;
        if (toLine < 1)throw new IllegalArgumentException("FromLine shouldn't be smaller than 1");
        if (toLine < fromLine) throw  new IllegalArgumentException("ToLine shouldn't be smaller than fromLine");
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    public String read() throws FileNotFoundException,IOException {
        BufferedReader in = null;
        String s;
        StringBuilder sb = new StringBuilder(); // use a StringBuilder if you are doing lot of string manipulation
        in = new BufferedReader(new FileReader(filePath));
        while ((s = in.readLine()) != null)
            sb.append(s + "\n");
        in.close();
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    public String getFilepath() {
        return filePath;
    }

    public String readLines() throws FileNotFoundException,IOException {
        String file = read();
        String lines[] = file.split("\\r?\\n");
        String[] selectedLines = Arrays.copyOfRange(lines, fromLine - 1, toLine);
        StringBuilder sb = new StringBuilder();
        for (String line: selectedLines
             ) {
            sb.append(line + "\n");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }


    public Integer getFromLine() {
        return fromLine;
    }

    public Integer getToLine() {
        return toLine;
    }
}
