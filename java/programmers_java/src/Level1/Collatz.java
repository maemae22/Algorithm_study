package Level1;

public class Collatz {
    public static int solution(int num) {
        int count = 0;

        if(num == 1) {
            return 0;
        }

        int tmp = num ;
        while(count<500) {
            if(tmp%2==0) {
                tmp /= 2;
            } else if(tmp%2==1) {
                tmp = tmp*3 + 1;
            }
            count++;

            if(tmp == 1) {
                return count;
            }
        }
        return -1;
    }


//    매개변수로 입력 받은 int형 n 값을 long으로 바꿔주지 않으면, 예제 3번에서 488이라는 결과가 나왔다.
//    입력 받은 n값을 int형으로 그대로 사용하면 100번째 근처에서 오버 플로우가 나와서,
//    음수로 한 번 바뀌기 때문에 결과 값이 꼬임 !
    public int solution2(int num) {
        int count = 0;

        if(num == 1) {
            return 0;
        }

        long tmp = num ;
        while(count<500) {
            if(tmp%2==0) {
                tmp /= 2;
            } else {
                tmp = tmp*3 + 1;
            }
            count++;

            if(tmp == 1) {
                return count;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(solution(1056935));
    }
}
