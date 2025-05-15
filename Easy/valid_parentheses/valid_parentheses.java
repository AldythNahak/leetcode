package valid_parentheses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isValid(String s) {
        Integer lenS = s.length();

        if (lenS % 2 != 0 || lenS > 10000) {
            return false;
        }

        Map<String, String> mapParentheses = new HashMap<String, String>();
        mapParentheses.put("(", ")");
        mapParentheses.put("[", "]");
        mapParentheses.put("{", "}");

        String[] strSplit = s.split("");
        ArrayList<String> collectParentheses = new ArrayList<>();

        for (int i = 0; i < strSplit.length; i++) {
            if (i == 0 && mapParentheses.containsValue(strSplit[i])) {
                return false;
            }

            if (!mapParentheses.containsKey(strSplit[i]) && !mapParentheses.containsValue(strSplit[i])) {
                return false;
            }

            if (mapParentheses.containsKey(strSplit[i])) {
                collectParentheses.add(strSplit[i]);
                continue;
            }

            if (collectParentheses.size() == 0 && mapParentheses.containsValue(strSplit[i])) {
                return false;
            }

            int lastIndexCheck = collectParentheses.size() - 1;
            String lastCheck = collectParentheses.get(lastIndexCheck);
            if (mapParentheses.get(lastCheck).equals(strSplit[i])) {
                collectParentheses.remove(lastIndexCheck);
                continue;
            } else {
                return false;
            }
        }

        return collectParentheses.size() == 0;
    }
}

public class valid_parentheses {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("(]")); // false
        System.out.println(solution.isValid("()[]{}")); // true
        System.out.println(solution.isValid("([])")); // true
        System.out.println(solution.isValid("(}{)")); // false
        System.out.println(solution.isValid("([{}])")); // true
        System.out.println(solution.isValid("(){}}{")); // false
        System.out.println(solution.isValid("(([]){})")); // true
        System.out.println(solution.isValid("()))")); // false
    }
}
