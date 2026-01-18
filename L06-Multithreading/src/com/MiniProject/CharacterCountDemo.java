package com.MiniProject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CharacterCountDemo {
    public static void main(String[] args) {
        String str =  "sdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddg" +
                "sdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggf" +
                "sdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggf" +
                "sdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfdd" +
                "sdfghjklmbvcdssfddggfs" +
                "sdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggf" +
                "sdfghjklmbvcdssfddggf" +
                "dfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfggfgfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddg" +
                "sdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddg" +
                "sdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddg" +
                "sdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddg" +
                "sdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddg" +
                "sdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddg" +
                "sdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddg" +
                "sdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddg" +
                "sdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddg" +
                "sdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddg" +
                "sdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddg" +
                "sdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddg" +
                "sdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddggfsdfghjklmbvcdssfddg" +
                "ljnfjknsdnfiesjoifjsdfoijdoifisdoinskdnflksdlaksncalknasnklasnlknlkoiassjnflk" +
                "nlidncoindoicndoincdncjknoiddjfoidsdjfoisdoifdoifjopdfnlksnosdnvjndovcsdoinsdcoisndovc" +
                "ndcondiunoisdnbcuibvsdubvsudodvbosdn" +
                "dsbcouidsbvubsduivbouoisoijeiorjeirnvrugonvr94r4ufn438f2h480039ht3n4f39hf0834fn34089fh384fn4983horu40992u3m3209urn98" +
                "3r2n3vricnijcankhd8473mcn34rui4nc48ry8nrgyu4urg34ncyg";
        int len = str.length();
        int size = 10;
        long start = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<TaskToCountCharacter> taskList = new ArrayList<>();
        for(int i = 0; i < len; ) {
            TaskToCountCharacter taskToCountChar = new TaskToCountCharacter(str, i, i+size);
            executorService.submit(taskToCountChar);
            taskList.add(taskToCountChar);
            i+=size;
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(4, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Map<Character, Long> result = new HashMap<>();
        for(TaskToCountCharacter task : taskList){
            Map<Character, Long> taskData = task.getFreqMap();
            for(Character ch : taskData.keySet()){

                if(result.get(ch)==null){
                    result.put(ch, taskData.get(ch));
                } else {
                    long newFreq = result.get(ch) + taskData.get(ch);
                    result.put(ch, newFreq );
                }

                //result.put(ch, result.getOrDefault(ch, 0L) + charCountMap.get(ch));
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("Character Count Result: " + result);
        System.out.println("Time taken: " + (end - start) + " ms");
        System.out.println("Done!!!");

    }
}


class TaskToCountCharacter implements Runnable {
    private String subStrting;
    private int start;
    private int end;

    private Map<Character, Long> freqMap = new HashMap<>();

    public TaskToCountCharacter(String subStrting, int start, int end) {
        this.subStrting = subStrting;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for(int i = start; i < end; i++) {
            freqMap.put(subStrting.charAt(i), freqMap.getOrDefault(subStrting.charAt(i), 0l) + 1);
        }
    }

    public Map<Character, Long> getFreqMap() {
        return freqMap;
    }
}

//1:39