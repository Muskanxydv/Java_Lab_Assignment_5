package com.capstone.util;

public class Loader implements Runnable {
    @Override
    public void run() {
        try {
            System.out.print("Loading...");
            for (int i = 0; i < 5; i++) {
                System.out.print(".");
                Thread.sleep(300);
            }
            System.out.println("Done.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Loading interrupted.");
        }
    }
}