package Level0;

import java.util.Arrays;

public class letter {

    public static int solution(String message) {
        //String[] messageArr = message.split(" ");
        String[] messageArr = message.split("");
        System.out.println(Arrays.toString(messageArr));

        int messageNum = 0;
        for (String s : messageArr) {
            messageNum += s.length();
            //System.out.println(messageArr[i].length());
        }
        System.out.println(messageNum);

        //int messageTotalNum = messageArr.length - 1 + messageNum ;

        return messageNum*2;
    }

    public static void main(String[] args) {
        System.out.println(solution("I love you~"));
    }
}
