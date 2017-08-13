/**
 * Created by weihengwang on 7/5/17.
 */
public class _273IntegertoEnglishWords {
    String[] digits = new String[]{"One","Two", "Three", "Four","Five","Six","Seven","Eight","Nine"};
    String[] tens = new String[]{"Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    String[] teens = new String[]{"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};

    public String numberToWords(int num) {

        int thousand = 1000;
        int million =  1000000;
        int billion =  1000000000;
        String bpart = parseInt( num / billion );
        String mpart = parseInt( (num % billion ) / million );
        String tpart = parseInt( (num % million ) / thousand);
        String lastp = parseInt( num % thousand );

        bpart = bpart.length() == 0? "" : bpart + " Billion";
        mpart = mpart.length() == 0? "" : mpart + " Million";
        tpart = tpart.length() == 0? "" : tpart + " Thousand";

        if(bpart.length() == 0 && mpart.length() == 0 && tpart.length() == 0 && lastp.length() == 0)
            return "Zero";

        String res = bpart + (mpart.length() == 0? "": " " + mpart ) + (tpart.length() == 0? "": " " + tpart ) + (lastp.length() == 0? "": " " + lastp );
        return res.trim();
    }
    private String parseInt(int num){
        if(num == 0)
            return "";
        String res = "";
        int hundren = num / 100;
        if(hundren > 0)
            res += digits[hundren - 1] + " Hundred";

        int tendigit = (num % 100) / 10;
        int digit = num % 10;

        if(tendigit == 1){
            res += " " + teens[digit];
            return res.trim();   //
        }
        else if(tendigit != 0)
            res += " " + tens[tendigit - 1];

        if(digit != 0)
            res += " " + digits[digit - 1];

        return res.trim();
    }
}
