import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringWithConcatenation {
    /**
     * 没有系统的去思考，每次都是想到一个方法，然后各种拼凑去完成要求。
     *
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {
        if(s.length()==0||words.length==0)return new ArrayList<>();
        int l = words[0].length();
        int num = words.length;
        HashMap<String, Integer> map = new HashMap<>();
        for (String w : words) {
            if (map.containsKey(w)) map.put(w, map.get(w) + 1);//
            else
                map.put(w, 1);
        }
        List<Integer> r = new ArrayList<>();
        for (int i = 0; i <= s.length() - l * num; i++) {
            HashMap<String, Integer> m = new HashMap<>(map);
            for (int j = 0; j < num; j++) {
                String substring = s.substring(i + j * l, i + (j + 1) * l);
                if (m.containsKey(substring)) {
                    int dup = m.get(substring);
                    if (dup == 1) m.remove(substring);
                    else m.put(substring, dup - 1);
                    if (m.isEmpty()) {
                        r.add(i);
                        break;
                    }
                } else
                    break;
            }
        }
        return r;
    }

}
