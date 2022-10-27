package Level0;

public class FindNum {
    public int solution(int num, int k) {
        /*
        String[] arr = (num+"").split("");
        for(int i=0; i<arr.length; i++) {
            if(arr[i].equals(k+"")) {
                return i+1;
            }
        }
        return -1;
        */

        String numStr = String.valueOf(num);
        String kStr = String.valueOf(k);

        int answer = numStr.indexOf(kStr);
        return answer<0? -1 : answer+1 ;
    }
}
