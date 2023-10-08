package com.jitin.junit;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringTester {


    public static void main(String[] args) {

        String input="|1|create|event|1571155550834|ffccd4b8-38cd-4c75-9952-428a79310101|Football|Sky Bet Championship|\\|Norwich\\| vs \\|Aston Villa\\||1571155583774|0|1|";

        String removeChar = input.replaceAll("[\\\\|]","~");
        String thirdPass = removeChar.replaceAll("~~","");
        String[] strings = thirdPass.split("~");



        List<String> feed = Arrays.asList(strings).stream().filter(f-> !f.isEmpty()).collect(Collectors.toList());
        List<String> data = feed.subList(3,feed.size());
        data.stream().forEach(System.out::println);
        MessageFeed messageFeed = new MessageFeed(feed.get(0),feed.get(1),Type.valueOf(feed.get(2)), Long.valueOf(feed.get(3)),data);
        System.out.println(messageFeed.toString());
    }
}
