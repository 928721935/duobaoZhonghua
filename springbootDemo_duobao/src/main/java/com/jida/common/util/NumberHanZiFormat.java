package com.jida.common.util;

import java.util.Hashtable;

public class NumberHanZiFormat {

    private static String[] chinese = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
    private static String[] replace = {"|〇", "|壹", "|贰", "|叁", "|肆", "|伍", "", "", "", ""};
    private static Hashtable<Character, Long> digits = new Hashtable();
    private static String[] commonDigit = {"", "十", "百", "千"};
    private static String[] twiceDigit = {"万", "亿", "兆"};

    static {
        digits.put('十', 10L);
        digits.put('百', 100L);
        digits.put('千', 1000L);
        digits.put('万', 10000L);
        digits.put('亿', 100000000L);
        digits.put('兆', 10000000000000000L);
    }

    /**
     * 可用于处理年份(如二〇一六)及多位数字
     * 若需添加错字验证，可在replace中对应位置放置；以|隔开
     * 若需添加更高位运算，请在digits中put相应元素，并注意修改long
     *
     * @param chineseNum
     * @return
     */
    public static String parse(String chineseNum) {

        for (int i = 0, len = chinese.length; i < len; i++) {
            chineseNum = chineseNum.replaceAll(chinese[i] + replace[i], Integer.toString(i));
        }
        if (chineseNum.matches("[0-9]+")) {
            return chineseNum;
        }
        //十六处理为一十六
        if ("十".equals(chineseNum.substring(0, 1))) {
            chineseNum = "1".concat(chineseNum);
        }
        char[] cNums = chineseNum.toCharArray();
        return getNum(cNums);
    }

    /**
     * 算法思路：
     * 倒序累加数字乘以其叠加倍数，
     * 如3千8百万亿中,
     * 3的叠加倍数(multi)是一千万亿,当前倍数(current)是一千,基数(base)是一万亿
     * 8的叠加倍数       是一百万亿,当前倍数         是一百,基数      是一万亿
     *
     * @return
     */
    private static String getNum(char[] cNums) {
        long sum = 0, multi = 1, current, last = 1, base = 1;
        for (int i = cNums.length - 1; i >= 0; i--) {
            if (cNums[i] > '9') {
                current = digits.get(cNums[i]);
                //当前倍数比基数大，则更新叠加倍数和基数为当前倍数
                if (current > base) {
                    base = current;
                    current = 1;
                } else {
                    base = getBase(current, last, base);
                }
                multi = current * base;
                last = current;
            } else {
                sum += (cNums[i] - '0') * multi;
            }
        }
        return String.valueOf(sum);
    }

    /**
     * 如果当前倍数突然比上个倍数少，说明已进入到上个倍数的子倍数
     * 则更新叠加倍数为上个倍数
     * <p>
     * 比较基数和上个倍数
     * 基数>上个倍数时(如三百万亿,读取到百时，base(亿)>last(万))
     * 则更新基数为万亿
     * 基数<上个倍数时(如三十亿零六十万，
     * 读取到十时进入，last(万)>base(1)，更新基数为万
     * 读取到十时再次进入，last(亿)>base(万),更新基数为亿
     *
     * @return
     */
    private static long getBase(long current, long last, long base) {
        if (current < last) {
            base = base > last ? base * last : last;
        }
        return base;
    }

    /**
     * 将阿拉伯数字转换为中文
     *
     * @param number
     * @return
     */
    public static String format(long number) {
        //千以上位计数器
        int[] twiceDigitCounter = new int[twiceDigit.length];
        String numStr = simpleFormat(number);
        //{三,零,零,零,零,五}
        char[] nums = numStr.toCharArray();
        StringBuffer addDigit = new StringBuffer(nums.length * 2);
        int index = 0;
        boolean appendZero = false;
        //倒序装载十百千，若遇千位以上，特殊处理(getDigitByCounter)
        for (int i = nums.length - 1; i >= 0; i--) {
            if (appendZero && lastIsNum(addDigit)) {
                addDigit.append("零");
                appendZero = false;
            }
            if (index == commonDigit.length) {
                String current = getDigitByCounter(twiceDigitCounter);
                String last = getLast(addDigit);
                if (indexOf(last) < indexOf(current)) {
                    addDigit.delete(addDigit.length() - 1, addDigit.length());
                }
                addDigit.append(current);
                index = 0;
            }
            if (nums[i] == '零') {
                appendZero = true;
            } else {
                if (index != commonDigit.length) {
                    addDigit.append(commonDigit[index]);
                }
                addDigit.append(nums[i]);
            }
            index++;

        }
        return addDigit.reverse().toString();
    }

    /**
     * 200173518 简单转换为 二零零一七三五一八
     *
     * @param number
     * @return
     */
    private static String simpleFormat(long number) {
        String numStr = String.valueOf(number);
        for (int i = 0, len = chinese.length; i < len; i++) {
            numStr = numStr.replaceAll(Integer.toString(i), chinese[i]);
        }
        return numStr;
    }

    /**
     * 转换为中文的年
     */
    public static String getChineseNumYear(long number) {
        if (number < 2000 || number > 2100) {
            System.out.println("日期格式错误");
            return null;
        }
        return simpleFormat(number);
    }

    /**
     * 万出现两次则为亿，亿出现两次则为兆
     * 因此，千位以上从万计数，
     * 若万没出现过，则为万。
     * 若万出现过，则置万为没出现过，进位到亿
     *
     * @return
     */
    private static String getDigitByCounter(int[] twiceDigitCounter) {
        for (int i = 0, len = twiceDigit.length; i < len; i++) {
            if (twiceDigitCounter[i] == 0) {
                twiceDigitCounter[i] = 1;
                return twiceDigit[i];
            } else if (twiceDigitCounter[i] == 1) {
                twiceDigitCounter[i] = 0;
            }
        }
        twiceDigitCounter[0] = 1;
        return twiceDigit[0];
    }

    /**
     * 得到最后一位
     *
     * @param addDigit
     * @return
     */
    private static String getLast(StringBuffer addDigit) {
        if (addDigit.length() == 0) {
            return null;
        }
        return addDigit.substring(addDigit.length() - 1);
    }

    /**
     * 万亿兆。。。的位置
     *
     * @param digit
     * @return
     */
    private static int indexOf(String digit) {
        for (int i = 0, len = twiceDigit.length; i < len; i++) {
            if (twiceDigit[i].equals(digit)) {
                return i;
            }
        }
        return twiceDigit.length;
    }

    /**
     * 最后一位是否为非零数字(不可为万/亿等计位符)
     *
     * @param addDigit
     * @return
     */
    private static boolean lastIsNum(StringBuffer addDigit) {
        String last = getLast(addDigit);
        for (int i = 1, len = chinese.length; i < len; i++) {
            if (chinese[i].equals(last)) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        //测试年份及错别字
        System.out.println(NumberHanZiFormat.parse("贰〇一八"));
        System.out.println(NumberHanZiFormat.parse("三十亿零四十万"));
        System.out.println(NumberHanZiFormat.parse("九千万零一"));
        System.out.println(NumberHanZiFormat.parse("三百万亿"));
        System.out.println(NumberHanZiFormat.parse("一百二十三兆四千五百六十七万八千九百零一亿二千三百四十五万六千七百八十九"));

        System.out.println(NumberHanZiFormat.getChineseNumYear(2018));
        System.out.println(NumberHanZiFormat.format(3000400000L));
        System.out.println(NumberHanZiFormat.format(90000001));
        System.out.println(NumberHanZiFormat.format(300000000000000L));
        System.out.println(NumberHanZiFormat.format(1234567890123456789L));

    }
}
