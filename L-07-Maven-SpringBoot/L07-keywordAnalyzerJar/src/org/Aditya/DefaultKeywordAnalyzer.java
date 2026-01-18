package org.Aditya;

import java.util.ArrayList;
import java.util.List;

public class DefaultKeywordAnalyzer implements  KeywordAnalyzerInterface{

    private List<String> dataStore;

    public DefaultKeywordAnalyzer(){
        this.dataStore = new ArrayList<String>();
    }

    @Override
    public void recordKeyword(String keyword) {
        dataStore.add(keyword);
    }

    @Override
    public List<String> getKeywords() {
        return dataStore;
    }
}
