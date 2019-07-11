package com.sudo.sapan.scheduler;

import java.util.ArrayList;
import java.util.List;

public class Process {
    int id;
    List<Process> dependsOn = new ArrayList<>();
    volatile boolean done;


    public Process(int id) {
        this.id = id;
        this.done = false;
    }

    public void execute() {
        if (done)
            return;
        for (Process parentProcess : dependsOn) {
            if (!parentProcess.done) {
                System.out.println("Parent " + parentProcess.id
                        + "  of process " + id + " not executed yet");
                parentProcess.execute();
            }
        }
        System.out.println("Executed " + id);
        done = true;

    }


    public void addParent(Process parent) {
        dependsOn.add(parent);
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Process)) return false;
        return ((Process) obj).id == this.id;

    }

    @Override
    public String toString() {
        return "Process{" +
                "id=" + id +
                ", dependsOn=" + dependsOn +
                ", done=" + done +
                '}';
    }
}
