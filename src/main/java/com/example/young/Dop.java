package com.example.young;

import java.io.BufferedReader;
import java.io.FileReader;

public class Dop {
    public static double getPrice(String tag) throws Exception{
        try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\extre\\IdeaProjects\\young\\src\\main\\resources\\backpack.txt"))){
            String line;
            while ((line = br.readLine()) != null){
                if(line.contains(tag)){
                    return Double.parseDouble(line.split(":")[1]);
                }
            }
            return 0;
        }
    }
    public static int getCount(String tag) throws Exception{
        try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\extre\\IdeaProjects\\young\\src\\main\\resources\\backpack.txt"))){
            String line;
            while ((line = br.readLine()) != null){
                if(line.contains(tag)){
                    return Integer.parseInt(line.split(":")[2]);
                }
            }
            return 0;
        }
    }
    public static String getTag(String text){
        String result = text.split(":")[0].split("\\(")[1].replace(")", "");
        return result;
    }
    public static String getName(String text){
        String result = text.split(":")[0].split("\\(")[0].trim();
        return result;
    }
    public static double getPercent(double first, double second){

        if(first > second){
            double value = first - second;
            return value * -100 / first;
        }
        else{
            double value = second - first;
            return value * 100 / first;
        }
    }
    public static String getRow(int index) throws Exception{
        try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\extre\\IdeaProjects\\young\\src\\main\\resources\\backpack.txt"))){
            String line;
            int counter = 0;
            while ((line = br.readLine()) != null){
                if(counter == index){
                    return line;
                }
                else{
                    counter++;
                }
            }
        }
        return "";
    }
}
