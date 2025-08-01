package com.example.leetCodeProbs;

public class Singelton {
    private static Singelton instance = null;

    private Singelton(){
    }

    public static Singelton getInstance(){
        synchronized (Singelton.class){
            if(instance == null){
                return new Singelton();
            }
            return instance;
        }
    }
}
