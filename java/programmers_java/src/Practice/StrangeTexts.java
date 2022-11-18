package Practice;

public class StrangeTexts {
    public String solution(String s) {
        String[] arr = s.split(" ", -1);
        for(int i=0; i<arr.length; i++) {
            String tmp = arr[i];
            String[] str = tmp.split("");
            for(int k=0; k<str.length; k++) {
                if(k%2==0) {
                    str[k] = str[k].toUpperCase();
                } else {
                    str[k] = str[k].toLowerCase();
                }
            }
            tmp = String.join("", str);
            arr[i] = tmp;
        }
        return String.join(" ", arr);
    }
}
