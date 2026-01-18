package com.Aditya.keywordAnalyzer;


import java.util.List;

public class SearchService {

    public static void main(String[] args) {
//        KeywordAnalyzerInterface keywordAnalyzer = new DefaultKeywordAnalyzerImpl();
//        KeywordAnalyzerInterface keywordAnalyzer = new UniqueKeywordAnalyzerImpl();
        KeywordAnalyzerInterface keywordAnalyzer = new KeywordFrequenceAnalyzer();

        keywordAnalyzer.recordKeyword("Pen");
        keywordAnalyzer.recordKeyword("Paper");
        keywordAnalyzer.recordKeyword("Laptop");
        keywordAnalyzer.recordKeyword("Page");
        keywordAnalyzer.recordKeyword("Computer Science");
        keywordAnalyzer.recordKeyword("Book");
        keywordAnalyzer.recordKeyword("Laptop");
        keywordAnalyzer.recordKeyword("Computer Science");
        keywordAnalyzer.recordKeyword("Mobile");
        keywordAnalyzer.recordKeyword("Computer Science");
        keywordAnalyzer.recordKeyword("Mobile");



        System.out.println(keywordAnalyzer.getKeywords());
        System.out.println(keywordAnalyzer.getKeywordFreq());
    }


    public List<String> getAllProducts(String keyword){
        KeywordAnalyzerInterface keywordAnalyzer = new KeywordFrequenceAnalyzer();
        keywordAnalyzer.recordKeyword(keyword);

        /*




         */

        return null;
    }
}
