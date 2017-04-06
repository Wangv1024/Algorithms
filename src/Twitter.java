import java.util.*;

/**
 * Created by weihengwang on 8/19/16.
 */
public class Twitter {
    HashMap<Integer, User> idUserMap;

    /** Initialize your data structure here. */
    public Twitter() {
        idUserMap = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!idUserMap.containsKey(userId))
        {
            User nUser = new User(userId);
            idUserMap.put(userId,nUser);
        }
        User nUser = idUserMap.get(userId);
        nUser.postTweet(tweetId);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must
     * be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
     static class CompRule implements Comparator<Twittered>{
        public int compare(Twittered twi1,Twittered twi2){
            return twi2.timeStamp - twi1.timeStamp;
        }
    }

    public List<Integer> getNewsFeed(int userId) {
        User user = idUserMap.get(userId);
        Set<Integer> followeredSet = user.followed;
        PriorityQueue<Twittered> pq = new PriorityQueue<>(followeredSet.size(), new CompRule());
        List<Integer> twitteredList = new ArrayList<>();
        for(int followId: followeredSet){
            User oneFollow = idUserMap.get(followId);
            pq.add(oneFollow.twitteredHead);
        }

        for(int i=0; i<10; i++){
            Twittered twitted = pq.poll();
            if(twitted == null){
                break;
            }
            twitteredList.add(twitted.tweetId);
            if(twitted.next != null) {
                pq.add(twitted.next);
            }
        }
        return twitteredList;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId)
            return;
        if(!idUserMap.containsKey(followerId)){
            idUserMap.put(followerId,new User(followerId));
        }
        if(!idUserMap.containsKey(followeeId)){
            idUserMap.put(followeeId,new User(followeeId));
        }
        User user = idUserMap.get(followerId);
        user.followed.add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(followerId == followeeId)
            return;
        if(!idUserMap.containsKey(followerId)){
            idUserMap.put(followerId,new User(followerId));
        }
        if(!idUserMap.containsKey(followeeId)){
            idUserMap.put(followeeId,new User(followeeId));
        }
        User user = idUserMap.get(followerId);
        user.followed.remove(followeeId);
    }

    public static void main(String[] args){
        Twitter twitter = new Twitter();
        twitter.follow(1,2);
        twitter.follow(1,3);
        twitter.follow(1,6);
        twitter.follow(2,3);
        twitter.unfollow(1,3);
        twitter.postTweet(1,10);
        twitter.postTweet(2,20);
        twitter.postTweet(3,30);
        twitter.postTweet(4,40);
        twitter.postTweet(6,60);
        System.out.println(twitter.getNewsFeed(1));

        twitter.follow(1,7);
        twitter.follow(1,8);
        twitter.postTweet(1,11);
        twitter.postTweet(1,12);
        twitter.postTweet(7,70);
        twitter.postTweet(7,71);
        twitter.postTweet(8,80);
        twitter.postTweet(1,13);
        System.out.println(twitter.getNewsFeed(1));
        twitter.unfollow(1,7);
        System.out.println(twitter.getNewsFeed(1));
    }
}

class User{
    static int timeStamp = 0;
    int userId;
    Set<Integer> followed;
    Twittered twitteredHead = null;
    User(int userId){
        this.userId = userId;
        followed = new HashSet<>();
        followed.add(userId);
    }

    public void postTweet(int tweetId){
        Twittered twittered = new Twittered(this.timeStamp,tweetId);
        this.timeStamp++;
        twittered.next = twitteredHead;
        twitteredHead = twittered;
    }
}

class Twittered{
    int timeStamp;
    int tweetId;
    Twittered next;
    Twittered(int timeStamp,int tweetId){
        this.timeStamp = timeStamp;
        this.tweetId = tweetId;
    }
    public String toString(){
        return new String("TimeStamp:"+timeStamp+" tweetId:"+tweetId+"\n");
    }
}
/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
