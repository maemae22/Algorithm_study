package Level1;

public class Watermelon {
    public String solution(int n) {
        String watermelon = "수박";

        if(n%2==0) {
            return watermelon.repeat(n/2);
        } else {
            return watermelon.repeat(n/2) + "수";
        }
    }
}
