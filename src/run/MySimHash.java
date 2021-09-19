package run;

import com.hankcs.hanlp.HanLP;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;

/**
 * word segmentation,get hash,weighting and merging and Dimension reduction
 * return the simHash of str
 * @author : [86135]
 * @version : [v1.0]
 * @createTime : [2021/9/7 21:11]
 */

public class MySimHash {
    private String str;
    private String strSimHash;
    private int hashBits = 64;
    private int frequency = 10;

    public MySimHash(String tokens, int hashBits, int frequency){
        this.str = tokens;
        this.hashBits = hashBits;
        this.strSimHash = this.getSimHash();
        this.frequency = frequency;
    }
    /**
     * get the simHash of str
     * @return simHash the value of hash
     */
    public String getSimHash(){
        if(str.length() == 0){
            return "";
        }
        int[] vector = new int[this.hashBits];
        int i = 0;
        //step one: word segmentation, get the list of keywords
        List<String> keywordList = HanLP.extractKeyword(this.str, this.str.length());
        int size = keywordList.size();
        for(String keyword : keywordList){
            //step two: get hash
            String keywordHash = hash(keyword);
        //step three:weighting and merging
            for (int j = 0; j < vector.length; j++) {
                //according to the ordinal grade, divide the fourteen grades
                int grade = i / (size / this.frequency);
                if (keywordHash.charAt(j) == '1') {
                    vector[j] += (this.frequency - grade);
                } else {
                    vector[j] -= (this.frequency - grade);
                }
            }
            i++;
        }
        //step four:Dimension reduction
        String simHash = "";
        for (int j = 0; j < vector.length; j++) {
            if (vector[j] > 0) {
                simHash += "1";
            } else {
                simHash += "0";
            }
        }
        return simHash;
    }

    /**
     * through the MD5 algorithm, we can get the hash of keywords
     * @param keyword keywords of all data
     * @return HashKeywords String ,the hash of keyword
     */
    private String hash(String keyword) {
        try{
            //Determine the use of MD5 for information summarization
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                BigInteger HashKeywords = new BigInteger(1, messageDigest.digest(keyword.getBytes("UTF-8")));
                String SHashKeywords = HashKeywords.toString(2);
                //low zero padding
                if(SHashKeywords.length() < this.hashBits) {
                int k = this.hashBits - SHashKeywords.length();
                for (int j = 0; j < k; j++) {
                    SHashKeywords += "0";
                }
            }
                return SHashKeywords;
            } catch (Exception e) {
                e.printStackTrace();
                return keyword;
            }
        }

    /**
     * get the similarity of two simHash
     * @param simHash the other hash
     * @return the similarity of two value of hash
     */
    public double getSemblance(String simHash){
        // BigDecimal.ROUND_HALF_UP表示四舍五入，setScale(2)表示保留两位小数
        double distance = getDistance(simHash);
        if(distance == -2){
            return 0;
        }else{
            BigDecimal bd = new BigDecimal((1 - distance/this.hashBits));
            Double result = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            return result;
        }
    }


    /**
     * compare bit by bit, when the bit is different, distance plus one
     * @param others the simHash of modified  document
     * @return distance the Hamming distance
     */
    public int getDistance(String others){
        if(strSimHash.length() == 0 || others.length() == 0){
            return -2;
        }
        int distance = 0;
        if(this.strSimHash.length() == others.length()){
            for (int i = 0; i < this.strSimHash.length(); i++) {
                //if the bit of the same position is different ,distance plus one
                if(this.strSimHash.charAt(i) != others.charAt(i)){
                    distance++;
                }
            }
        }else{
            distance = -1;
        }
        return distance;
    }

}
