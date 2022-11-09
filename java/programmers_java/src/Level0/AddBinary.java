package Level0;

public class AddBinary {
    public String solution(String bin1, String bin2) {
        int num1 = Integer.parseInt(bin1, 2);
        int num2 = Integer.parseInt(bin2, 2);

        int sum = num1 + num2;

        return Integer.toBinaryString(sum);
    }

    public String solution2(String bin1, String bin2) {
        return Integer.toString(Integer.parseInt(bin1, 2) + Integer.parseInt(bin2, 2),2);
    }
}
