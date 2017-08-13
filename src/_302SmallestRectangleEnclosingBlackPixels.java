/**
 * Created by weihengwang on 7/22/17.
 */
public class _302SmallestRectangleEnclosingBlackPixels {
    public int minArea(char[][] image, int x, int y) {
        if(image.length <= 0 || image[0].length <= 0)
            return 0;

        int rowlen = image.length, collen = image[0].length;
        boolean rowExp = false, reverse = false;

        int up = explore(image, 0, x, rowExp = true, reverse = true);
        int down = explore(image, x, rowlen - 1, rowExp = true, reverse = false);
        int left = explore(image, 0, y, rowExp = false, reverse = true);
        int right = explore(image, y, collen - 1, rowExp = false, reverse = false);

        return ( down - up + 1 ) * ( right - left + 1 );
    }
    private int explore(char[][] image, int st, int end, boolean rowExp, boolean reverse){
        while(st <= end){
            int mid = st + (end - st) / 2;
            boolean find = false;
            if(rowExp){
                for(int i = 0; i < image[0].length; i ++)
                    if(image[mid][i] == '1'){
                        find = true;
                        break;
                    }
            }
            else{
                for(int i = 0; i < image.length; i++)
                    if(image[i][mid] == '1'){
                        find = true;
                        break;
                    }
            }

            if(reverse){
                if(find)
                    end = mid - 1;
                else
                    st = mid + 1;
            }
            else{
                if(find)
                    st = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return reverse ? st : end;
    }
}
