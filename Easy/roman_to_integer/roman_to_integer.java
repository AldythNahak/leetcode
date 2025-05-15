package roman_to_integer;
import java.util.HashMap;

class Solution {
    public int romanToInt(String s) {
        HashMap<String, Integer> symbolMap = new HashMap<String, Integer>();
        symbolMap.put("I", 1);
        symbolMap.put("V", 5);
        symbolMap.put("X", 10);
        symbolMap.put("L", 50);
        symbolMap.put("C", 100);
        symbolMap.put("D", 500);
        symbolMap.put("M", 1000);

        String[] strSplit = s.toUpperCase().split("");
        Integer total = 0;

        for (int i = 0; i < strSplit.length; i++) {
            if (!symbolMap.containsKey(strSplit[i])) {
                break;
            }

            if (i > 0) {
                if ((strSplit[i].equals("V") || strSplit[i].equals("X")) && strSplit[(i - 1)].equals("I")) {
                    total -= 2;
                }

                if ((strSplit[i].equals("L")  || strSplit[i].equals("C")) && strSplit[(i - 1)].equals("X")) {
                    total -= 20;
                }

                if ((strSplit[i].equals("D") || strSplit[i].equals("M")) && strSplit[(i - 1)].equals("C")) {
                    total -= 200;
                }
            }

            total += symbolMap.get(strSplit[i]);
        }

        return total;
    }
}

public class roman_to_integer {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.romanToInt("MCMXCIV"));
    }
}