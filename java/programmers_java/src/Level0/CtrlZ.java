package Level0;

public class CtrlZ {
    static public int solution(String s) {
        String[] arr = s.split(" ");

        int countz = 0;

        for(int i=0; i<arr.length; i++) {
            if(arr[i].equals("Z")) {
                if(countz == 0) {
                    countz++;
                } else {
                    countz += 2;
                }

                arr[i] = "no";
                if(i-countz>=0) {
                    arr[i-countz] = "no";
                }
            } else {
                countz = 0;
            }
        }

        // 남은 숫자만 더해줌
        int sum = 0;
        for (String str : arr) {
            if( ! (str.equals("no")) ) {
                sum += Integer.parseInt(str);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String example1 = "1 2 Z 3";
        String example2 = "2 8 4 7 Z Z 0 1 2 4";
        String example3 = "Z Z 20 Z 1";

        System.out.println(solution(example1));
        System.out.println(solution(example2));
        System.out.println(solution(example3));

    }
}
