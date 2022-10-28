package Level0;

public class MorseCode {
    public String solution(String letter) {
        String[] mos = new String[] {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."} ;
        String[] alpha = new String[] {"a", "b", "c", "d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        String[] letterArr = letter.split(" ");

        String answer="";

        for(String str : letterArr) {
            for(int i=0; i<mos.length; i++) {
                if(str.equals(mos[i])) {
                    answer += alpha[i];
                }
            }
        }
        return answer;

    }
}
