package Level0;

public class HateEnglish {
    static public long solution(String numbers) {
        // replace 는 함수는 원본이 바뀌지 않는다 ! (+ trim()도 마찬가지)
        // 바꾸고 싶으면 따로 변수를 만들어줘야함
        String number0 = numbers.replace("zero", "0");
        String number1 = number0.replace("one", "1");
        String number2 = number1.replace("two", "2");
        String number3 = number2.replace("three", "3");
        String number4 = number3.replace("four", "4");
        String number5 = number4.replace("five", "5");
        String number6 = number5.replace("six", "6");
        String number7 = number6.replace("seven", "7");
        String number8 = number7.replace("eight", "8");
        String number9 = number8.replace("nine", "9");

        return Long.parseLong(number9);
    }

    public static void main(String[] args) {
        System.out.println(solution("one"));
        System.out.println(solution("onetwothreefourfivesixseveneightnine"));
        System.out.println(solution("onefourzerosixseven"));
    }
}
