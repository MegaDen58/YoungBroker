package com.example.young;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Internet {
    public static double getPrice(String tag) throws Exception{
        URL url = new URL(String.format("https://query1.finance.yahoo.com/v10/finance/quoteSummary/%s?modules=price", tag));
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        try(BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()))){
            String inputLine;
            StringBuilder content = new StringBuilder();
            while((inputLine = br.readLine()) != null){
                content.append(inputLine);
            }
            String regular = "\\\"regularMarketPrice\\\":\\{\\\"raw\\\":\\d+\\.\\d+";
            Pattern pattern = Pattern.compile(regular);
            Matcher matcher = pattern.matcher(content.toString());
            while(matcher.find()){
                double result = Double.parseDouble(matcher.group().split(":")[2]);
                return result;
            }
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        }
        return 0;
    }
}
