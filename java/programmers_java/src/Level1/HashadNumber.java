package Level1;

public class HashadNumber {
    public boolean solution(int x) {
        //return x%sumDigit(x) ==0? true : false;
        return x % sumDigit(x) == 0;
    }

    // 자릿수의 합을 반환하는 함수
    public int sumDigit(int n) {
        int sum = 0;
        while(n>0) {
            sum += n%10;
            n /= 10;
        }
        return sum;
    }
}
