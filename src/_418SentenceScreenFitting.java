/**
 * Created by weihengwang on 6/10/17.
 */
public class _418SentenceScreenFitting {
    // public int wordsTyping(String[] sentence, int rows, int cols) {
    // 	String s = String.join(" ", sentence) + " ";
    // 	int start = 0, len = s.length();
    // 	for(int i = 0; i < rows; i++){
    // 		int tempt = start + cols;
    // 		if(s.charAt( tempt % len) == ' '){
    // 			tempt ++;
    // 		}
    // 		else{
    // 			while(tempt > 0 && s.charAt((tempt - 1) % len) != ' ')
    // 				tempt --;   // s.charAt( tempt - 1 )  // bugs

    // 			if(tempt == start) // it means exist one word longer than cols
    // 				return 0;
    // 		}
    // 		start = tempt;
    // 	}
    // 	return start / len;
    // }
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int[] dp = new int[sentence.length]; // ()
        int len = 0, prev = 0, n = sentence.length;
        for(int i = 0; i < sentence.length; i++){
            if(i != 0 && len > 0)
                len = len - sentence[i - 1].length() - 1; // len = len - sentence[i - 1] - 1;

            while(len + sentence[prev % n].length() <= cols){//len + sentence[prev % n] <= cols
                len = len + sentence[prev % n].length() + 1;
                prev++;
            }

            dp[i] = prev;
        }

        int count = 0, start = 0;
        for(int i = 0; i < rows; i++){
            count += dp[start] - start;
            if(dp[start] == start)
                return 0;
            start = dp[start] % n;
        }
        return count / n;
    }
}
