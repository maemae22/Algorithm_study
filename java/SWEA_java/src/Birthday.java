import java.util.*;
import java.io.*;

public class Birthday
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++) {
            String limit = "";
            int first = 0;
            int second = 0;

            StringTokenizer token = new StringTokenizer(br.readLine());

            StringBuilder stringBuilder = new StringBuilder();

            limit = token.nextToken();
            first = Integer.parseInt(token.nextToken());
            second = Integer.parseInt(token.nextToken());

            String answer = "";

            int length = 0;
            int wow = 0;
            int index = -1;

            if (limit.length()<2) {
                int tmp = 0;

                tmp = Integer.parseInt(limit);
                if (tmp<first || (first==0 && tmp<second)) {
                    answer = -1+"";
                } else if ((first==0 && tmp==second) || (second <= tmp)) {
                    answer = second+"";
                }
            } else {

                for (int i=0; i<limit.length(); i++) {
                    int numbersi = Character.getNumericValue(limit.charAt(i));

                    if (second <= numbersi) {
                        stringBuilder.append(second);
                        length = i;
                    } else if (first == numbersi){
                        stringBuilder.append(first);
                        length = i;
                    } else if (first<numbersi && numbersi <second) {
                        stringBuilder.append(first);
                        length = i;
                        break;
                    } else if (numbersi < first) {
                        if (stringBuilder.toString().equals("")) {
                            wow=1;
                            break;
                        } else {
                            // 맨뒤에꺼 없애고 &&비교하고 찾아서 하나 없애기
                            if (stringBuilder.charAt(stringBuilder.length() - 1) - '0' == second) {

                                stringBuilder.delete(stringBuilder.length()-1, stringBuilder.length());
                                stringBuilder.append(first);

                            } else if (stringBuilder.charAt(stringBuilder.length() - 1) - '0' == first) {

                                for (int j = stringBuilder.length()-1; j >= 0; j--) {
                                    if (stringBuilder.charAt(j) - '0' != first) {
                                        index = j;
                                        break;
                                    }
                                }
                                if (index == 0 || stringBuilder.length() - 1 == 0) {
                                    wow = 3;
                                    break;
                                } else if (index == -1) {
                                    wow=1;
                                    break;
                                } else {
                                    // answer의 index 번째꺼를 first로 바꾸기 (원래는 second였을 것..)
//                                    answer = answer.substring(0, index) + first + answer.substring(index + 1);
                                    stringBuilder.substring(0, index);
                                    stringBuilder.append(first);
                                    wow=2;
                                    break;
//                                    stringBuilder.append(stringBuilder.substring(index + 1));
                                }
                            }
                        }
                        stringBuilder.append(second);
                        length = i;
                        break;
                    }
                }
                answer = stringBuilder.toString();

                if (wow==1) {
                    answer = limit.substring(1).replaceAll(".", second+"");
                } else if (wow == 2) {
                    answer = answer + limit.substring(index+1).replaceAll(".", second+"");
                } else if (wow==3 && Character.getNumericValue(limit.charAt(1)) <first ) {
                    answer = limit.substring(1).replaceAll(".", second+"");
                } else if (wow == 3) {
                    answer = String.valueOf(first) + limit.substring(1).replaceAll(".", second+"");
                } else if (length+1 != limit.length()) {
                    answer = answer + limit.substring(length+1).replaceAll(".", second+"");
                }
            }
            System.out.println("#"+test_case+" "+answer);
        }
    }
}
