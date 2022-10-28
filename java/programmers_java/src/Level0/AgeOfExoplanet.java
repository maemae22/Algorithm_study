package Level0;

public class AgeOfExoplanet {
    public String solution(int age) {
        String[] ageArr = (age+"").split("");
        String[] answer = new String[ageArr.length];

        for(int i=0; i<answer.length; i++) {
            switch(ageArr[i]) {
                case "0" : answer[i]="a"; break;
                case "1" : answer[i]="b"; break;
                case "2" : answer[i]="c"; break;
                case "3" : answer[i]="d"; break;
                case "4" : answer[i]="e"; break;
                case "5" : answer[i]="f"; break;
                case "6" : answer[i]="g"; break;
                case "7" : answer[i]="h"; break;
                case "8" : answer[i]="i"; break;
                case "9" : answer[i]="j"; break;
            }
        }
        return String.join("", answer);
    }

    public String solution2(int age) {
        String answer = "";
        String[] alpha = new String[] {"a","b","c","d","e","f","g","h","i","j"};

        while(age>0) {
            answer = alpha[age%10] + answer;
            age/= 10 ;
        }

        return answer;
    }


}
