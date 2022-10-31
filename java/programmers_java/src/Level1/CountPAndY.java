package Level1;

public class CountPAndY {
    boolean solution(String s) {
        int countp = 0;
        int county = 0;

        String[] arr = s.toUpperCase().split("");

        for (int i =0 ; i< arr.length ; i++ ) {
            if( arr[i].equals("P") ) {
                countp++;
            } else if( arr[i].equals("Y") ) {
                county++;
            }
        }

        if(countp==0 && county==0 || countp==county ) {
            return true;
        } else {
            return false ;
        }
    }

}
