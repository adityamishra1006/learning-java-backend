package org.example;

import java.util.List;

public class MockKeywordAnalyzerImp implements KeywordAnalyzerInterface {
    @Override
    public void recordKeyword(String keyword) {

    }

    @Override
    public List<String> getKeywords() {
        return List.of();
    }
}
