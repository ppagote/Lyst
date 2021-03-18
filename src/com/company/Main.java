package com.company;

import java.io.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Main {
    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
    public static final String TODAY = " today - ";
    public static final String TOMORROW = " tomorrow - ";
    static final String HOUR_REG_EX = "^2[0-3]|[01]?[0-9]|[*]$";
    static final String MINUTE_REG_EX = "^[0-5]?[0-9]|[*]$";

    public static void main(String[] args){
        System.out.println(args.length);

        try {
            String inputCurrentTime = args[0];
            LocalTime parseInputTime = LocalTime.parse(inputCurrentTime, formatter);
            System.out.println("Input current time is:: " + parseInputTime);

            InputStreamReader in= new InputStreamReader(System.in);
            BufferedReader input = new BufferedReader(in);
            String str;
            System.out.print("Enter config here in the format as 'mm HH /script_path' and press Enter:");
            while ((str = input.readLine()) != null) {
                String[] config = str.split(" ");
                String finalOutput = null;


                if (config.length == 3) {
                    String configMinute = config[0];
                    String configHour = config[1];
                    String configScript = config[2];

                    if (!configMinute.matches(MINUTE_REG_EX) || !configHour.matches(HOUR_REG_EX)) {
                        finalOutput = "Invalid Input";
                    } else {
                        if (configMinute.equals("*") && configHour.equals("*")) {
                            finalOutput = inputCurrentTime + TODAY + configScript;
                        } else if (!configMinute.equals("*") && !configHour.equals("*")) {
                            LocalTime parseInputConfig = LocalTime.parse(
                                    String.format("%02d", Integer.parseInt(configHour)) + ":"
                                            + String.format("%02d", Integer.parseInt(configMinute)),
                                    formatter);
                            String day = (parseInputTime.equals(parseInputConfig) || parseInputTime.isAfter(parseInputConfig)) ? TODAY : TOMORROW;
                            finalOutput = inputCurrentTime + day + configScript;
                        } else if (!configHour.equals("*") && configMinute.equals("*")) {
                            String day = (Integer.parseInt(configHour) > Integer.parseInt(
                                    inputCurrentTime.split(":")[0]))
                                    ? TOMORROW : TODAY;
                            finalOutput = parseInputTime + day + configScript;
                        } else if (configHour.equals("*") && !configMinute.equals("*")) {
                            String time;
                            String day;
                            if (Integer.parseInt(configMinute) > Integer.parseInt(
                                    inputCurrentTime.split(":")[1])) {
                                day = parseInputTime.getHour() == 23 ? TOMORROW : TODAY;
                                time = parseInputTime.plus(1, ChronoUnit.HOURS).toString();
                            } else {
                                time = parseInputTime.toString();
                                day = TODAY;
                            }
                            finalOutput = time + day + configScript;
                        }
                    }
                } else {
                    finalOutput = "Invalid Input";
                }
                System.out.println(finalOutput);
            }

        } catch (Exception io) {
            System.out.println(io);
            io.printStackTrace();
        }
    }
}
