package Level1;

// 레벨1 - 문자열 다루기 기본
public class StringHandling {
    public boolean solution(String s) {
        if(!(s.length()==4 || s.length()==6)) {
            return false;
        }

        s = s.replaceAll("[0-9]","");
//        if(s.equals("")) {
//            return true;
//        } else {
//            return false;
//        }
        return s.equals("");
    }
}
