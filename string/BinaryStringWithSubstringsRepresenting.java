package string;

/**
 * 挨个试
 */
public class BinaryStringWithSubstringsRepresenting {
    public boolean queryString(String S,int N){
        for (int i = N; i > N / 2; --i)
            if (!S.contains(Integer.toBinaryString(i)))
                return false;
        return true;
    }
}
