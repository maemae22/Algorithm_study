import java.util.*;
import java.io.*;

// https://swexpertacademy.com/main/learn/course/subjectDetail.do?subjectId=AWWxy8bKAikDFAW4
// KMP 알고리즘 사용 : 참고) https://youtu.be/yWWbLrV4PZ8 / https://bowbowbow.tistory.com/6
public class S4038_단어가등장하는횟수 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int testCase=1; testCase<=T; testCase++) {
            char[] book = br.readLine().toCharArray();
            char[] word = br.readLine().toCharArray();
            int[] pi = makeTable(word);
            int count = 0;

            int j=0;
            for (int i=0; i<book.length; i++) {
                while (j>0 && book[i]!=word[j]) {
                    j = pi[j-1];
                }
                if (book[i]==word[j]) {
                    j++;
                    if (j==word.length) {
                        count++;
                        j = pi[j-1];
                    }
                }
            }
            System.out.println("#"+testCase+" "+count);
        }
    }

    public static int[] makeTable(char[] word) {
        int[] pi = new int[word.length];
        int j=0;
        for (int i=1; i<word.length; i++) {
            while (j>0 && word[i]!=word[j]) {
                j = pi[j-1];
            }
            if (word[i]==word[j]) {
                pi[i] = j+1;
                j++;
            }
        }

        return pi;
    }
}
