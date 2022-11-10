package Level0;

public class PushString {
    public int solution(String A, String B) {
        String BB = B+B;

        for(int i=0; i<A.length(); i++) {
            String compare = BB.substring(i, i+A.length());
            if(compare.equals(A)) {
                return i;
            }
        }
        return -1;
    }

    public int solution2(String A, String B) {
        String tempB = B.repeat(2);
        return tempB.indexOf(A);
    }
}
