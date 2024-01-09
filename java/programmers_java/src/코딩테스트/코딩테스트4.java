package 코딩테스트;

public class 코딩테스트4 {

    static int answer;
    static int target;
    static int[] nums;

    public long solution(int k) {
        answer = 0;
        target = k;
        nums = new int[]{6, 2, 5, 5, 4, 5, 6, 3, 7, 6};

        for(int i=1; i<=9; i++) {
            DFS(nums[i]);
        }

        if(k==6) {
            answer++;
        }
        return answer;
    }

    public static void DFS(int sum) {
        if(sum>target) {
            return;
        }

        if(sum==target) {
            answer++;
        } else {
            for(int tmp : nums) {
                DFS(sum+tmp);
            }
        }
    }
}
