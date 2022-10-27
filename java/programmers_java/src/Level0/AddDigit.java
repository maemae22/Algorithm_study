package Level0;

public class AddDigit {
    public static int solution(int n) {
        //String str = n+"";
        String str = String.valueOf(n);
        String[] strArr = str.split("");
        int sum = 0;
        for(String string : strArr) {
            sum += Integer.parseInt(string);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(solution(930211));
    }
}
