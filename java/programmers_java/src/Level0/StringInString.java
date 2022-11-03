package Level0;

public class StringInString {
    public int solution(String str1, String str2) {
        char first = str2.charAt(0);

        int answer = 2;
        for(int i=0; i<=str1.length()-str2.length(); i++) {
            if(str1.charAt(i) == first) {
                String compare = str1.substring(i, i+str2.length());
                if(compare.equals(str2)) {
                    answer = 1;
                }
            }
        }

        return answer;
    }

    public int solution2(String str1, String str2) {
        return str1.contains(str2)? 1 : 2;
    }

}
