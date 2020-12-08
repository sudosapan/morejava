package com.sudo.sapan.scheduler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProcessScheduler {
    public static void main(String[] args) throws IOException {

        Map<Integer, Process> processMap = new HashMap<>();

        List<String> strings = new ArrayList<>();
        Files.lines(Paths.get("processschedule"));
        try (BufferedReader br = new BufferedReader
                (new FileReader(ProcessScheduler.class.getClassLoader().getResource("processschedule").getFile()))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] sa = line.split(":");
                String iStr = sa[0];
                String pStr = sa.length > 1 ? sa[1] : null;
                int id = Integer.parseInt(iStr);
                if (!processMap.containsKey(id)) processMap.put(id, new Process(id));

                if (pStr != null) {
                    for (String s : pStr.split(",")) {
                        if (!processMap.containsKey(Integer.parseInt(s))) {
                            System.out.println("Creating process " + Integer.parseInt(s) + " for process " + id);
                            processMap.put(Integer.parseInt(s), new Process(Integer.parseInt(s)));
                        }
                        processMap.get(id).addParent(processMap.get(Integer.parseInt(s)));
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }


        // lets execute now
        for (Process ignored : processMap.values()) {
            ignored.execute();
        }
    }


}

