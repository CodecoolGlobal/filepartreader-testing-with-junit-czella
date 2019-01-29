package com.code.cool.filepartreader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileWordAnalyzer {

    private FilePartReader filePartReader;

    public FileWordAnalyzer(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    public List<String> getWordsAlphabetically() throws IOException {

        List<String> wordList = getWordListFromLines();
        List<String> sorted = Arrays.asList(
                          wordList.stream().sorted(
                              (s1, s2) -> s1.compareToIgnoreCase(s2)
                          ).toArray(String[]::new)
                      );
        return sorted;
    }

    private List<String> getWordListFromLines() throws IOException {
        String lines = filePartReader.readLines();
        List<String> wordList = new ArrayList<>();
        wordList.addAll(Arrays.asList(lines.split(" ")));
        return wordList;
    }

    public List<String> getWordsWhichPalindromes() throws IOException {
        List<String> wordList = getWordListFromLines();
        List<String> returnList = new ArrayList<>();
        for (String word: wordList
             ) {
            if (checkPalindrome(word)) {
                returnList.add(word);
            }
        }
        return returnList;
    }

    private boolean checkPalindrome(String str) {
        for(int i=0;i<=str.length()/2;i++)
            if(str.charAt(i)!=str.charAt(str.length()-1-i))
                return false;
        return true;
    }


    public FilePartReader getFilePartReader() {
        return filePartReader;
    }


}
