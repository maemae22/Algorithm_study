public class Main {
    public static void main(String[] args) {
        String answer = "";
        String limit = "12345";
        int second = 4;
        answer = limit.substring(1).replaceAll(".", second+"");
        System.out.println(answer); // answer가 4444 가 나오면 성공
    }
}