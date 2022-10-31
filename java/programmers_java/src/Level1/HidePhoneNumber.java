package Level1;

public class HidePhoneNumber {
    public String solution(String phone_number) {
        String[] arr = phone_number.split("");

        for(int i=0 ; i <arr.length-4 ; i++ ) {
            arr[i] = "*";
        }

        return String.join("", arr);
    }

    public String solution2(String phone_number) {
        // 풀이2. 이게 훨씬 더 느림
        return "*".repeat(phone_number.length()-4)
                + phone_number.substring(phone_number.length()-4);
    }
}
