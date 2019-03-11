package string;

public class JewelsAndStones {
    public int numJewelsInStones(String J,String S){

            return S.replaceAll("[^" + J + "]", "").length();

    }
}
