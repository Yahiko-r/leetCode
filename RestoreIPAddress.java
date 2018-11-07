import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress {
    public List<String> restoreIpAddresses(String s){
        List<String> list=new ArrayList<>();
        search(s,list,"",0,0);
        return  list;

    }
    public void search(String ip,List<String> solution,String cur,int inx,int count){
        if(count>4)return;
        if(count==4&&inx==ip.length())solution.add(cur);

        for(int i=0;i<4;i++){

            String s=ip.substring(inx,inx+i);
            if((s.length()>1&&s.startsWith("0"))||(s.length()==3&&Integer.parseInt(s)>256))break;
            search(ip,solution,cur+s+(count==3?"":"."),inx+i,count+1);
        }

    }
}
