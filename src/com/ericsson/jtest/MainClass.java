package com.ericsson.jtest;


public class MainClass extends StartTest {
    public static void main(String args[]) throws InstantiationException {

        StartTest getclass = new StartTest();
        for (int i = 0; i < args.length; i++) {
            getclass.getTest(args[i]);

    }
}


}