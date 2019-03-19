package string;

import java.util.ArrayList;
import java.util.List;

/**
 * 暴力求解。找出所有的
 */
public class PalindromePartitioning {
    private List<List<String>> rs;
    private List<String> cur;
    public List<List<String>> partition(String s) {
        if(s==null||s.length()==0)return null;
        rs=new ArrayList<List<String>>();
        cur=new ArrayList<String>();
        backtrack(s,0);
        return rs;
    }


    public void backtrack(String s,int pos){
        if(pos>=s.length()){
            rs.add(new ArrayList<String>(cur));
            return;
        }
        for(int i=pos;i<s.length();i++){
            if(isPalindrome(s,pos,i)){
                cur.add(s.substring(pos,i+1));
                backtrack(s,i+1);
                cur.remove(cur.size()-1);
            }
        }

    }
    public boolean isPalindrome(String s,int left,int right){
        while(left<right){
            if(s.charAt(left)==s.charAt(right)){
                left++;
                right--;
            }
            else{
                return false;
            }

        }
        return true;
    }

}
