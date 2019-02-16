package other;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate2(int numRows){
        List<List<Integer>> rs=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer> temp=new ArrayList<>();
            temp.add(1);
            for(int j=1;j<=i/2;j++){
                int num=rs.get(i-1).get(j-1)+rs.get(i-1).get(j);
                temp.add(num);
            }
            for(int k=i/2+1;k<=i;k++){
                temp.add(temp.get(i-k));
            }

            rs.add(temp);
        }
        return rs;
    }
    //讨论区的答案
    public List<List<Integer>> generate(int numRows){
        List<List<Integer>> allrows = new ArrayList<List<Integer>>();
        ArrayList<Integer> row = new ArrayList<Integer>();
        for(int i=0;i<numRows;i++)
        {
            row.add(0, 1);
            for(int j=1;j<row.size()-1;j++)
                row.set(j, row.get(j)+row.get(j+1));
            allrows.add(new ArrayList<Integer>(row));
        }
        return allrows;
    }

    public static void main(String[] args) {
        PascalTriangle p=new PascalTriangle();
        p.generate(5);
        System.out.println("over");
    }
}
