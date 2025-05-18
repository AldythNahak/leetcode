package zigzag_conversion;

import java.util.ArrayList;

class Solution {
    public String convert(String s, int numRows) {
        if(s.length() <= 1 || s.length() > 1000 || numRows <= 1 || numRows > 1000) {
            return s;
        }

        ArrayList<String> collectZigzag = new ArrayList<>();
        int currRow = 0;
        Boolean isStraight = true;

        for(int i = 0; i < s.length(); i++) {
            if(i < numRows) {
                collectZigzag.add("");
            }

            if(currRow == 0) {
                isStraight = true;
            } else if(currRow == numRows - 1) {
                isStraight = false;
            }

            collectZigzag.set(currRow, collectZigzag.get(currRow) + s.charAt(i));

            if(isStraight) {
                currRow++;
            } else {
                currRow--;
            }
        }


        return String.join("", collectZigzag);
    }
}

public class zigzag_conversion {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.convert("PAYPALISHIRING", 3));
    }
}