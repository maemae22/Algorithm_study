package Level0;

// double을 int로 바꾸기

public class DiscountClothes {
//    public int solution(int price) {
//        int answer = 0 ;
//        if(price >= 500000) {
//            return (int) price * 0.8;
//        } else if (price>=300000) {
//            return price * 0.9;
//        } else if (price>=100000) {
//            return price * 0.95;
//        } else {
//            return price;
//        }
//    }

    public int solution(int price) {
        if(price >= 500000) {
            return price*80/100;
        } else if (price>=300000) {
            return price*90/100;
        } else if (price>=100000) {
            return price*95/100;
        } else {
            return price;
        }
    }

    public static int solution2(int price) {
        if(price >= 500000) {
            return (int)Math.floor(price * 0.8);
        } else if (price>=300000) {
            return (int)Math.floor(price * 0.9);
        } else if (price>=100000) {
            return (int)Math.floor(price * 0.95);
        } else {
            return price;
        }
    }

    public static void main(String[] args) {
        System.out.println((int)5.89);
        System.out.println(Math.floor(4));
        System.out.println(solution2(589650));
    }

}
