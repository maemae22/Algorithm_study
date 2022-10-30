package Level0;

import java.util.Arrays;

public class AddHiddenNums {
    public static int solution(String my_string) {
        String replace = my_string.replaceAll("[^0-9]", " ");
        System.out.println(replace);

        String[] str = replace.split(" ");
        System.out.println(Arrays.toString(str));

        int sum = 0;
        for(String tmp : str) {
            if(!(tmp.equals(""))) {
                sum += Integer.parseInt(tmp);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String my_string = "aAb1B2cC34oOp";
        String my_string2 = "1a2b3c4d123Z";
        System.out.println(solution(my_string));
        System.out.println(solution(my_string2));
    }
}
