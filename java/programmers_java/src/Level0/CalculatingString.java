package Level0;

public class CalculatingString {
    static public int solution(String my_string) {
        String[] arr = my_string.split(" ");

        int total = Integer.parseInt(arr[0]);

        for(int i=0; i<arr.length/2; i++) {
            int first = 1 + 2 * i ;
            int second = 2 + 2 * i ;

            if(arr[first].equals("+")) {
                total += Integer.parseInt(arr[second]);
            } else {
                total -= Integer.parseInt(arr[second]);
            }
        }
        return total;
    }
}
