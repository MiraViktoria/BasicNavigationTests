package com.cbt.utilities;



public class StringUtility {


    public  static void verifyEquals (String expected, String actual){
        if(expected.equalsIgnoreCase(actual)){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");

        }
    }
}

