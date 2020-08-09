package Week_02;

import java.util.*;

/**
 * @author jipan
 * @version 1.0
 * @date 2020/8/9 20:22
 */
public class SolutionOfGroupAnagram {
    public List<List<String>> GroupAnagram(String[] strs){
        if (strs.length == 0) return new ArrayList<>();
        Map<String,List> map = new HashMap<>();
        int[] count = new int[26];
        for (String s : strs){
            Arrays.fill(count,0);
            for (int i = 0; i < s.length(); i++){
                count[s.charAt(i)-'a']++;
            }
            StringBuilder sb = new StringBuilder("");
            for (int i = 0 ; i < 26 ; i++){
                sb.append(count[i]);
            }
            String skey = sb.toString();
            if (!map.containsKey(skey)){
                map.put(skey,new ArrayList());
            }
            map.get(skey).add(s);
        }
        return new ArrayList(map.values());
    }
}
