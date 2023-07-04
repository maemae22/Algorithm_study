package Level2;

import java.util.*;
import java.io.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/12951
public class P02_JadenCase문자열만들기 {

    public String solution(String s) {
        char[] letter = s.toCharArray();

        boolean first = true;
        for(int i=0; i<letter.length; i++) {
            if(letter[i]==' ') {
                first = true;
                continue;
            }

            if(first) {
                first = false;
                if(Character.isAlphabetic(letter[i])) {
                    letter[i] = Character.toUpperCase(letter[i]);
                }
            } else {
                letter[i] = Character.toLowerCase(letter[i]);
            }
        }

        return String.valueOf(letter);
    }
}
