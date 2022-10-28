package Level0;

public class Game369 {
    public int solution(int order) {
        /*
        int count = 0;
        String[] arr = (order+"").split("");
        for(int i=0; i<arr.length; i++) {
            if(arr[i].equals("3") || arr[i].equals("6") || arr[i].equals("9") ) {
                count++;
            }
        }
        return count;
        */

        int count = 0;
        while(order>0) {
            if(order%10==3 || order%10==6 || order%10==9) {
                count++;
            }
            order /= 10;
        }
        return count;

    }
}
