import java.util.*;
import java.io.*;

class UserSolution_S19203_문자열관리프로그램 {

    static Deque<Character> dq;
    static boolean reverse;
    static HashMap<Long, Long> map;

    String findString(char c[]) {
        int end = 0;
        while (Character.isLowerCase(c[end])) {
            end++;
        }
        return String.valueOf(c).substring(0, end);
    }

    String reverseWord(String word) {
        String answer = "";
        for (char c : word.toCharArray()) {
            answer = c + answer;
        }
        return answer;
    }

    void init(char mStr[]) {
        dq = new ArrayDeque<>();
        reverse = false;
        map = new HashMap<>();

        appendWord(mStr);
    }

    void appendWord(char mWord[]) {
        String word = findString(mWord);
        if (!reverse) {
            for (int i=0; i<word.length(); i++) {
                dq.addLast(word.charAt(i));
                Iterator<Character> it = dq.descendingIterator();
                long tmp = 0;
                int power = 0;
                for (int j=0; j<=4 && it.hasNext(); j++) {
                    int c = it.next()-'a'+1;
                    tmp += c*Math.pow(27, power++);
                    map.put(tmp, map.getOrDefault(tmp, 0L)+1);
                }
            }
        } else if (reverse) {
            String add = reverseWord(word);
            for (int i=add.length()-1; i>=0; i--) {
                dq.addFirst(add.charAt(i));
                Iterator<Character> it = dq.iterator();
                long tmp = 0;
                for (int j=0; j<4 && it.hasNext(); j++) {
                    int c = it.next()-'a'+1;
                    tmp = tmp*27 + c;
                    map.put(tmp, map.getOrDefault(tmp, 0L)+1);
                }
            }
        }
    }

    void cut(int k) {
        if (!reverse) {
            for (int i=0; i<k; i++) {
                Iterator<Character> it = dq.descendingIterator();
                long tmp = 0;
                int power = 0;
                for (int j=0; j<=4 && it.hasNext(); j++) {
                    int c = it.next()-'a'+1;
                    tmp += c*Math.pow(27, power++);
                    map.put(tmp, map.get(tmp)-1);
                }
                dq.removeLast();
            }
        } else if (reverse) {
            for (int i=0; i<k; i++) {
                Iterator<Character> it = dq.iterator();
                long tmp = 0;
                for (int j=0; j<4 && it.hasNext(); j++) {
                    int c = it.next()-'a'+1;
                    tmp = tmp*27 + c;
                    map.put(tmp, map.get(tmp)-1);
                }
                dq.removeFirst();
            }
        }
    }

    void reverse() {
        reverse = !reverse;
    }

    int countOccurrence(char mWord[]) {
        String find = findString(mWord);
        if (reverse) {
            find = reverseWord(find);
        }

        long tmp = 0;
        int power = 0;
        for (int i=find.length()-1; i>=0; i--) {
            int c = find.charAt(i)-'a'+1;
            tmp += c*Math.pow(27, power++);
        }

        long count = 0;
        if (map.containsKey(tmp) && map.get(tmp)>=0) {
            count = map.get(tmp);
        }
        return (int)count;
    }
}

public class S19203_문자열관리프로그램 {

    private final static int CMD_INIT		= 1;
    private final static int CMD_APPEND		= 2;
    private final static int CMD_CUT		= 3;
    private final static int CMD_REVERSE	= 4;
    private final static int CMD_COUNT		= 5;

    private final static UserSolution_S19203_문자열관리프로그램 usersolution = new UserSolution_S19203_문자열관리프로그램();

    private static void String2Char(char[] buf, String str) {
        for (int k = 0; k < str.length(); ++k)
            buf[k] = str.charAt(k);
        buf[str.length()] = '\0';
    }

    private static char[] mStr = new char[30001];
    private static char[] mWord = new char[5];

    private static boolean run(BufferedReader br) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int queryCnt = Integer.parseInt(st.nextToken());
        boolean correct = false;

        for (int q = 0; q < queryCnt; q++)
        {
            st = new StringTokenizer(br.readLine(), " ");

            int cmd = Integer.parseInt(st.nextToken());

            if (cmd == CMD_INIT)
            {
                String2Char(mStr, st.nextToken());
                usersolution.init(mStr);
                correct = true;
            }
            else if (cmd == CMD_APPEND)
            {
                String2Char(mWord, st.nextToken());

                if (correct)
                {
                    usersolution.appendWord(mWord);
                }
            }
            else if (cmd == CMD_CUT)
            {
                int k = Integer.parseInt(st.nextToken());

                if (correct)
                {
                    usersolution.cut(k);
                }
            }
            else if (cmd == CMD_REVERSE)
            {
                if (correct)
                {
                    usersolution.reverse();
                }
            }
            else if (cmd == CMD_COUNT)
            {
                String2Char(mWord, st.nextToken());

                int ret = -1;
                if (correct)
                {
                    ret = usersolution.countOccurrence(mWord);
                }

                int ans = Integer.parseInt(st.nextToken());
                if (ret != ans)
                {
                    correct = false;
                }
            }
        }
        return correct;
    }

    public static void main(String[] args) throws Exception {
        int TC, MARK;

        System.setIn(new java.io.FileInputStream("C:/Users/maema/Documents/dev/Algorithm_study/java/SWEA_java/24동계 SW알고리즘 역량강화 과정/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        TC = Integer.parseInt(st.nextToken());
        MARK = Integer.parseInt(st.nextToken());

        for (int testcase = 1; testcase <= TC; ++testcase)
        {
            int score = run(br) ? MARK : 0;

            System.out.println("#" + testcase + " " + score);
        }

        br.close();
    }
}
