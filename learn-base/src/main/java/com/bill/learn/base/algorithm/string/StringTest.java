package com.bill.learn.base.algorithm.string;

/**
 * Created by bill on 2018/11/28.
 */
public class StringTest {
    public static String charReverse(String str) {
        if (str == null || "".equals(str)) {
            return str;
        }
        int length = str.length();
        if (length == 0 || length == 1) {
            return str;
        }
        char[] chars = str.toCharArray();
        for (int low = 0, high = length - 1; low < high; ) {
            if (chars[low] == '*' || chars[high] == '*') {
                if (chars[high] == '*') {
                    high--;
                    continue;
                }
                if (chars[low] == '*') {
                    low++;
                    continue;
                }
            }
            char temp = chars[low];
            chars[low] = chars[high];
            chars[high] = temp;
            low++;
            high--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String str = "12*34*33**7659*9";
        String strResult = charReverse(str);
        System.out.println(strResult);
    }
}
