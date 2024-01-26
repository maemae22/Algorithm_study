import java.util.*;
import java.io.*;

class UserSolution_S9416_SocialMedia {

    static ArrayList<Integer>[] followList;
    static PriorityQueue<Post>[] postList;
    static Post[] posts;
    static int[] likes;

    public void init(int N) {
        followList = new ArrayList[N+1];
        posts = new Post[100001];
        likes = new int[100001];
        postList = new PriorityQueue[N+1];
        for (int i=1; i<=N; i++) {
            followList[i]=new ArrayList<>();
            followList[i].add(i);
            postList[i]=new PriorityQueue<>();
        }
    }

    public void follow(int uID1, int uID2, int timestamp) {
        followList[uID1].add(uID2);
    }

    public void makePost(int uID, int pID, int timestamp) {
        posts[pID] = new Post(pID, uID, timestamp, 0);
        postList[uID].add(posts[pID]);
    }

    public void like(int pID, int timestamp) {
        if (likes[pID]>=0) {
            likes[pID]++;

            Post tmp = posts[pID];
            Post add = new Post(tmp.pId, tmp.uId, tmp.timeStamp, likes[pID]);
            postList[tmp.uId].add(add);
        }
    }

    public void getFeed(int user, int timestamp, int pIDList[]) {
        PriorityQueue<Post> ten = new PriorityQueue<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int uId : followList[user]) {
            PriorityQueue<Post> pq = postList[uId];
            while (!pq.isEmpty()) {
                Post pick = pq.poll();
                if (pick.like!=likes[pick.pId]) {
                    continue;
                }

                if (timestamp-pick.timeStamp>1000 && pick.like>=0) {
                    likes[pick.pId]=-100002;
                    pick.like = -100002;
                    pq.offer(pick);
                } else {
                    ten.add(pick);
                    list.add(pick.pId);
                    break;
                }
            }
        }

        int count = 0;
        while (!ten.isEmpty() && count!=10) {
            Post out = ten.poll();
            pIDList[count++] = out.pId;
            PriorityQueue<Post> pq = postList[out.uId];
            while (!pq.isEmpty() && count!=10) {
                Post pick = pq.poll();
                if (pick.like!=likes[pick.pId]) {
                    continue;
                }

                if (timestamp-pick.timeStamp>1000 && pick.like>=0) {
                    likes[pick.pId]=-100002;
                    pick.like = -100002;
                    pq.offer(pick);
                } else {
                    ten.add(pick);
                    list.add(pick.pId);
                    break;
                }
            }
        }

        for (int pId : list) {
            Post post = new Post(posts[pId].pId, posts[pId].uId, posts[pId].timeStamp, likes[pId]);
            postList[posts[pId].uId].offer(post);
        }
        if (count<10) {
            for (int i=count; i<10; i++) {
                pIDList[i]=0;
            }
        }
    }
}

class Post implements Comparable<Post> {
    int pId;
    int uId;
    int timeStamp;
    int like;
    Post(int pId, int uId, int timeStamp, int like) {
        this.pId = pId;
        this.uId = uId;
        this.timeStamp = timeStamp;
        this.like = like;
    }
    @Override
    public int compareTo(Post o) {
        return o.like!=this.like ? o.like-this.like : o.timeStamp-this.timeStamp;
    }

    @Override
    public String toString() {
        return "Post{" +
                "pId=" + pId +
                ", uId=" + uId +
                ", timeStamp=" + timeStamp +
                ", like=" + like +
                '}';
    }
}

public class S9416_SocialMedia {

    private static int mSeed;
    private static int pseudo_rand() {
        mSeed = mSeed * 431345 + 2531999;
        return mSeed & 0x7FFFFFFF;
    }

    private static int follow_status[][] = new int[1005][1005];
    private static int answer_score;
    private static int n; // n >= 5 && n <= 1000
    private static int end_timestamp;
    private static int follow_ratio; // follow_ratio >= 1 && follow_ratio <= 10000
    private static int make_ratio; // make_ratio >= 1 && make_ratio <= 10000
    private static int like_ratio; // like_ratio >= 1 && like_ratio <= 10000
    private static int get_feed_ratio; // get_feed_ratio >= 1 && get_feed_ratio <= 10000
    private static int post_arr[] = new int[200000];
    private static int total_post_cnt;
    private static int min_post_cnt;

    private static BufferedReader br;
    private static UserSolution_S9416_SocialMedia user = new UserSolution_S9416_SocialMedia();

    private static boolean run() throws Exception {
        int uId1;
        int uId2;
        int pId;
        int pIdList[] = new int[10];
        int ans_pIdList[] = new int[10];
        int rand_val;
        boolean ret = true;

        StringTokenizer stdin = new StringTokenizer(br.readLine(), " ");
        mSeed = Integer.parseInt(stdin.nextToken());
        n = Integer.parseInt(stdin.nextToken());
        end_timestamp = Integer.parseInt(stdin.nextToken());
        follow_ratio = Integer.parseInt(stdin.nextToken());
        make_ratio = Integer.parseInt(stdin.nextToken());
        like_ratio = Integer.parseInt(stdin.nextToken());
        get_feed_ratio = Integer.parseInt(stdin.nextToken());

        user.init(n);

        for (uId1 = 1; uId1 <= n; uId1++) {
            follow_status[uId1][uId1] = 1;
            int m = n / 10 + 1;
            if (m > 10)
                m = 10;
            for (int i = 0; i < m; i++) {
                uId2 = uId1;
                while (follow_status[uId1][uId2] == 1) {
                    uId2 = pseudo_rand() % n + 1;
                }
                user.follow(uId1, uId2, 1);
                follow_status[uId1][uId2] = 1;
            }
        }
        min_post_cnt = total_post_cnt = 1;

        for (int timestamp = 1; timestamp <= end_timestamp; timestamp++) {
            rand_val = pseudo_rand() % 10000;
            if (rand_val < follow_ratio) {
                uId1 = pseudo_rand() % n + 1;
                uId2 = pseudo_rand() % n + 1;
                int lim = 0;
                while (follow_status[uId1][uId2] == 1 || uId1 == uId2) {
                    uId2 = pseudo_rand() % n + 1;
                    lim++;
                    if (lim >= 5)
                        break;
                }
                if (follow_status[uId1][uId2] == 0) {
                    user.follow(uId1, uId2, timestamp);
                    follow_status[uId1][uId2] = 1;
                }
            }
            rand_val = pseudo_rand() % 10000;

            if (rand_val < make_ratio) {
                uId1 = pseudo_rand() % n + 1;
                post_arr[total_post_cnt] = timestamp;

                user.makePost(uId1, total_post_cnt, timestamp);
                total_post_cnt += 1;
            }

            rand_val = pseudo_rand() % 10000;

            if (rand_val < like_ratio && total_post_cnt - min_post_cnt > 0) {
                while (post_arr[min_post_cnt] < timestamp - 1000 && min_post_cnt < total_post_cnt)
                    min_post_cnt++;

                if (total_post_cnt != min_post_cnt) {
                    pId = pseudo_rand() % (total_post_cnt - min_post_cnt) + min_post_cnt;
                    user.like(pId, timestamp);
                }
            }

            rand_val = pseudo_rand() % 10000;
            if (rand_val < get_feed_ratio && total_post_cnt > 0) {
                uId1 = pseudo_rand() % n + 1;
                user.getFeed(uId1, timestamp, pIdList);
                stdin = new StringTokenizer(br.readLine(), " ");

                for (int i = 0; i < 10; i++) {
                    ans_pIdList[i] = Integer.parseInt(stdin.nextToken());
                }

                for (int i = 0; i < 10; i++) {
                    if (ans_pIdList[i] == 0)
                        break;

                    if (ans_pIdList[i] != pIdList[i]) {
                        ret = false;
                    }
                }
            }
        }

        return ret;
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new java.io.FileInputStream("C:/Users/maema/Documents/dev/Algorithm_study/java/SWEA_java/24동계 SW알고리즘 역량강화 과정/S9416_sample_input.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));

        int tc;
        StringTokenizer stdin = new StringTokenizer(br.readLine(), " ");
        tc = Integer.parseInt(stdin.nextToken());
        answer_score = Integer.parseInt(stdin.nextToken());

        for (int t = 1; t <= tc; t++) {
            int score;
            for (int i = 0; i < 1005; i++)
                for (int j = 0; j < 1005; j++)
                    follow_status[i][j] = 0;

            if (run())
                score = answer_score;
            else
                score = 0;

            System.out.println("#" + t + " " + score);
        }
    }
}
