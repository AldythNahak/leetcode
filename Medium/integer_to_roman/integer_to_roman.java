package integer_to_roman;

import java.util.LinkedHashMap;
import java.util.Map;

class Solution {
    public String intToRoman(int num) {
        Map<String, Integer> symbolMap = new LinkedHashMap<>();
        symbolMap.put("M", 1000);
        symbolMap.put("CM", 900);
        symbolMap.put("D", 500);
        symbolMap.put("CD", 400);
        symbolMap.put("C", 100);
        symbolMap.put("XC", 90);
        symbolMap.put("L", 50);
        symbolMap.put("XL", 40);
        symbolMap.put("X", 10);
        symbolMap.put("IX", 9);
        symbolMap.put("V", 5);
        symbolMap.put("IV", 4);
        symbolMap.put("I", 1);

        String romanText = "";

        for(Map.Entry<String, Integer> symbol : symbolMap.entrySet()) {
            if(num >= symbol.getValue()) {
                int totalSymbol = (int) Math.floor(num/symbol.getValue());
                for (int i = 0; i < totalSymbol; i++) {
                    romanText += symbol.getKey();
                    num -= symbol.getValue();
                }
            }
        }

        return romanText;
    }
}

public class integer_to_roman {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.intToRoman(3749)); // MMMDCCXLIX
        System.out.println(solution.intToRoman(58)); // LVIII
    }
}
