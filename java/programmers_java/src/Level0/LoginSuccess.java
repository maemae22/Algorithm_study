package Level0;

public class LoginSuccess {
    public String solution(String[] id_pw, String[][] db) {
        // 해당하는 id가 있는지 없는지 확인
        int index = -1;
        for(int i=0; i<db.length; i++) {
            if(id_pw[0].equals(db[i][0])) {
                index = i;
            }
        }
        if(index == -1) {
            return "fail";
        } else if(db[index][1].equals(id_pw[1])) {
            return "login";
        } else {
            return "wrong pw";
        }
    }
}
