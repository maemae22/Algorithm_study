package Level0;

public class CursedNumber3 {
    // 처음 풀이
    public int solution(int n) {
        int[] numbers = new int[100];

        int count = 0;

        for(int i=1; ; i++) {
            if(i%3!=0 && (i+"").indexOf("3") == -1) {
                numbers[count] = i;
                count++;
            }

            if(count>=n) {
                break;
            }
        }

        return numbers[n-1];
    }

    public int solution2(int n) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            answer++;
            if (answer % 3 == 0 || String.valueOf(answer).contains("3")) {
                i--;
            }
        }

        return answer;
    }

    public int solution3(int n) {
        String str;
        for (int i = 1; i <= n; i++){
            str = ""+i;
            if(str.contains("3") || i%3 == 0) n++;
        }
        return n;
    }
}
