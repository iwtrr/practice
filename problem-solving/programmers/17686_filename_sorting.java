// https://school.programmers.co.kr/learn/courses/30/lessons/17686

import java.util.*;
import java.util.regex.*;

class Solution {
    public String[] solution(String[] files) {
        Pattern pattern = Pattern.compile("^([a-zA-Z .-]+)([\\d]{1,5})([a-zA-Z0-9 .-]*)$");

        Arrays.sort(files, Comparator
                .comparing((String str) -> {
                    Matcher m = pattern.matcher(str);
                    m.matches();
                    return m.group(1).toLowerCase();
                }).thenComparingInt((String str) -> {
                    Matcher m = pattern.matcher(str);
                    m.matches();
                    return Integer.parseInt(m.group(2));
                }));

        return files;
    }
}