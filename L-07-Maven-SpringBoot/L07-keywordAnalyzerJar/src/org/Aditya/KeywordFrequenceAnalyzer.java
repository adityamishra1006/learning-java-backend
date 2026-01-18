package org.Aditya;

import java.util.*;

public class KeywordFrequenceAnalyzer implements KeywordAnalyzerInterface{
    private Map<String,Long> map;

    public KeywordFrequenceAnalyzer(){
        this.map = new LinkedHashMap<>();
    }

    @Override
    public void recordKeyword(String keyword) {
        map.put(keyword, map.getOrDefault(keyword, 0L) + 1);
//        map.put(keyword, map.get(keyword)+1);
    }

//    @Override
//    public List<String> getKeywords() {
//        return map.keySet().stream().toList();
//    }

    @Override
    public List<String> getKeywords() {
        return map.keySet().stream()
                .sorted(Comparator.comparingLong(key-> -map.get(key)))
                .toList();
    }


//    @Override
//    public List<String> getKeywords() {
//        return map.entrySet()
//                .stream()
//                .sorted((e1, e2) ->
//                        e2.getValue().compareTo(e1.getValue()))
//                .map(Map.Entry::getKey)
//                .collect(Collectors.toList());
//    }


//    @Override
//    public Map<String, Long> getKeywordFreq() {
//        return map;
//    }

    @Override
    public Map<String, Long> getKeywordFreq() {
        List<Map.Entry<String, Long>> entries = new ArrayList<>(map.entrySet());
        entries.sort(Map.Entry.<String, Long>comparingByValue().reversed());

        Map<String, Long> sortedMap = new LinkedHashMap<>();
        for(Map.Entry<String, Long> entry : entries){
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }

//    @Override
//    public Map<String, Long> getKeywordFreq() {
//        return map.entrySet()
//                .stream()
//                .sorted((e1, e2) ->
//                        e2.getValue().compareTo(e1.getValue()))
//                .collect(Collectors.toMap(
//                        Map.Entry::getKey,
//                        Map.Entry::getValue,
//                (e1, e2) -> e1,
//                LinkedHashMap::new
//        ));
//    }
}
