package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n,int k){
        List<List<Integer>> rs=new ArrayList<>();
        if(k>n)return rs;
        List<Integer> temp =new ArrayList<>();
        per(rs,temp,k,n,1);
        return rs;
    }

    public void per(List<List<Integer>> rs,List<Integer> temp,int k,int n,int begin){
        if(temp.size()==k){
            rs.add(temp);
        }
        else{
            for(int i=begin;i<=n;i++){
                temp.add(i);
                per(rs,new ArrayList<>(temp),k,n,i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
}
