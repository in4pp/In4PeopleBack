package com.in4people.bootrestapi.approval.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test1 {
    public static void main(String[] args) {

        String endDate1 = "23/03/01";
        String day = endDate1.substring(6);
        String cutDate = endDate1.substring(0,6);
        System.out.println("cutDate = " + cutDate);
        int intDay = Integer.parseInt(day) + 1;
        if(intDay < 10){day = "0" + intDay;}

        cutDate += day;

        System.out.println("cutDate = " + cutDate);
    }
}

