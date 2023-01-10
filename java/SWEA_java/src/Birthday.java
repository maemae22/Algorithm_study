import java.util.*;
import java.io.*;

public class Birthday
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

//        Scanner sc = new Scanner(System.in);
//        int T;
//        T=sc.nextInt();

//        sc.nextLine();
        String limit = "";
        int first = 0;
        int second = 0;


        for(int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer token = new StringTokenizer(br.readLine());

//            String input = sc.nextLine();
//            String[] split = input.split(" ");
//            String limit = split[0];
//            int first = Integer.parseInt(split[1]);
//            int second = Integer.parseInt(split[2]);

            limit = token.nextToken();
            first = Integer.parseInt(token.nextToken());
            second = Integer.parseInt(token.nextToken());


            String answer = "";
//            String num = "";

            int tmp = 0;
//            int[] numbers = new int[limit.length()];
            int length = 0;
            int wow = 0;
            int index = 0;


            if (limit.length()<2) {
                tmp = Integer.parseInt(limit);
                if (tmp<first || (first==0 && tmp<second)) {
                    answer = -1+"";
                } else if ((first==0 && tmp==second) || (second <= tmp)) {
                    answer = second+"";
                }
            } else {
//                for (int i=0; i<numbers.length; i++) {
//                    numbers[i] = Integer.parseInt(limit.charAt(i)+"");
//                }

                for (int i=0; i<limit.length(); i++) {
                    int numbersi = Integer.parseInt(limit.charAt(i)+"");

                    if (second <= numbersi) {
                        answer += second;
                        length = i;
                    } else if (first == numbersi){
                        answer += first;
                        length = i;
                    } else if (first<numbersi && numbersi <second) {
                        answer += first;
                        length = i;
                        break;
                    } else if (numbersi < first) {
                        if (answer.equals("")) {
                            wow=1;
                            break;
                        } else {
                            // 맨뒤에꺼 없애고 &&비교하고 찾아서 하나 없애기
                            if (Integer.parseInt(answer.charAt(answer.length() - 1) + "") == second) {
                                answer = answer.substring(0, answer.length() - 1) + first;
                            } else if (Integer.parseInt(answer.charAt(answer.length() - 1) + "") == first) {
                                for (int j = answer.length() - 1; j >= 0; j--) {
                                    if (Integer.parseInt(answer.charAt(j) + "") != first) {
                                        index = j;
                                        break;
                                    }
                                }
                                if (index == 0 || answer.length() - 1 == 0) {
                                    wow = 1;
                                    break;
                                } else {
                                    // answer의 index 번째꺼를 first로 바꾸기 (원래는 second였을 것..)
                                    answer = answer.substring(0, index) + first + answer.substring(index + 1);
                                }
                            }
                        }
                        answer += second;
                        length = i;
                        break;
                    }
                }


                if (wow==1) {
//                    answer = String.valueOf(second).repeat(limit.length()-1);
//                    answer = "";
//                    for (int k=0; k<limit.length()-1; k++) {
//                        answer += second+"";
//                    }
                    answer = limit.substring(1).replaceAll(".", second+"");
                } else if (length+1 != limit.length()) {
                // 이거 맞나;
//                    while (length+1 != limit.length()) {
//                        answer += second;
//                        length++;
////                        System.out.println("여기에 걸리셨숑" + length);
//                    }
                    answer = answer + limit.substring(length+1).replaceAll(".", second+"");
                }
//                answer = Long.parseLong(num);
            }
            System.out.println("#"+test_case+" "+answer);
        }
    }
}
