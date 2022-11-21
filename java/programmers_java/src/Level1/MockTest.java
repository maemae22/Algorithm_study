package Level1;

// 레벨1 - 모의고사
public class MockTest {
    public int[] solution(int[] answers) {
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int oneScore = count(one, answers);
        int twoScore = count(two, answers);
        int threeScore = count(three, answers);
        int[] score = {oneScore, twoScore, threeScore};

        int max = Math.max(Math.max(oneScore, twoScore), threeScore);

        int count = 0;
        for(int i=0; i<score.length; i++) {
            if(score[i] == max) {
                count++;
            }
        }

        int answer[] = new int[count];
        int index = 0;
        for(int i=0; i<score.length; i++) {
            if(score[i] == max) {
                answer[index] = i+1;
                index++;
            }
        }
        return answer;

    }

    public int count(int[] arr, int[] answers) {
        int answer = 0;
        for(int i=0; i<answers.length; i++) {
            if(answers[i] == arr[i%arr.length]) {
                answer++;
            }
        }
        return answer;
    }


    // solution에서 약간의 리팩토링.. (거의 똑같음)
    public int[] solution2(int[] answers) {
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] score = new int[3];

        for(int i=0; i<answers.length; i++) {
            if(answers[i] == one[i%one.length]) {
                score[0]++;
            }
            if(answers[i] == two[i%two.length]) {
                score[1]++;
            }
            if(answers[i] == three[i%three.length]) {
                score[2]++;
            }
        }

        int max = Math.max(Math.max(score[0], score[1]), score[2]);

        int count = 0;
        for(int i=0; i<score.length; i++) {
            if(score[i] == max) {
                count++;
            }
        }

        int answer[] = new int[count];
        int index = 0;
        for(int i=0; i<score.length; i++) {
            if(score[i] == max) {
                answer[index] = i+1;
                index++;
            }
        }
        return answer;
    }
}
