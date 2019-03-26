package other;

public class HammingDistance {
    public int hammingDistance(int x,int y){
        int z=x^y;
        int rs=0;
        while(z>0){
            if(z%2==1)rs++;
            z=z/2;
        }
        return rs;
    }
}
