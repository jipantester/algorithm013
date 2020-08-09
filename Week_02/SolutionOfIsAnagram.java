package Week_02;

import java.util.Arrays;

/**
 * @author jipan
 * @version 1.0
 * @date 2020/8/9 20:09
 */
public class SolutionOfIsAnagram {
    public boolean isAnagram(String s,String t){
        if (s.length() != t.length()) return false;
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);
        return Arrays.equals(s1,t1);
    }
}
