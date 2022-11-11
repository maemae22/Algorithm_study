package Level0;

public class ChickenCoupon {
    public int solution(int chick) {
        int service = 0;
        int rest = 0;

        while(chick>0) {
            rest += chick%10;
            if(rest>=10) {
                rest -= 9;
                service++;
            }
            service += chick/10;
            chick /= 10;
        }

        return service + rest/10 ;
    }

    public int solution2(int chicken) {
        int coupon = chicken;

        int service = 0;
        int mod = 0;
        int ans = 0;

        while(coupon >=10){
            service = coupon/10;
            mod = coupon%10;
            ans += service;

            coupon = service+mod;

        }

        return ans;
    }
}
