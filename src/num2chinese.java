import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class num2chinese {
    public static boolean isNumber(String str) {
        //采用正则表达式的方式来判断一个字符串是否为数字，这种方式判断面比较全
        //可以判断正负、整数小数

        boolean isInt = Pattern.compile("^-?[1-9]\\d*$").matcher(str).find();
        boolean isDouble = Pattern.compile("^-?([1-9]\\d*\\.\\d*|0\\.\\d*[1-9]\\d*|0?\\.0+|0)$").matcher(str).find();

        return isInt || isDouble;

    }


    public static String transfer(String num) {
        Map<String, String> chinese = new HashMap<>();
        chinese.put("0", "零");
        chinese.put("1", "壹");
        chinese.put("2", "贰");
        chinese.put("3", "叁");
        chinese.put("4", "肆");
        chinese.put("5", "伍");
        chinese.put("6", "陆");
        chinese.put("7", "柒");
        chinese.put("8", "捌");
        chinese.put("9", "玖");
        //此处根据小数点分割
        String[] str1 = num.split("\\.");
        //这里是根据空格拆分的整数数组
        String[] str2 = str1[0].split("");
        //这里是根据空格拆分的小数数组
        String[] str3 = str1[1].split("");
        //这里的c 是整数位用来累加遍历次数 以获取到 单位的（元，拾...）
        //
        StringBuffer sb1 = new StringBuffer();
        int n = str2.length;
        if (n > 5) {
            return "超出表示范围";
        }

        boolean isMatch = isNumber(num);

        System.out.println(isMatch);
        for (int i = 0; i < n; i++) {

            sb1.append(chinese.get(str2[i]));
            switch (n - i - 1) {
                case 0:
                    sb1.append("元");
                    break;
                case 1:
                    sb1.append("拾");
                    break;
                case 2:
                    sb1.append("佰");
                    break;
                case 3:
                    sb1.append("仟");
                    break;
                case 4:
                    sb1.append("万");
                    break;
                default:
            }

        }
        int n1 = str3.length;
        for (int i = 0; i < n1; i++) {

            sb1.append(chinese.get(str3[i]));
            switch (i) {
                case 0:
                    sb1.append("角");
                    break;
                case 1:
                    sb1.append("分");
                    break;
                default:
            }

        }
        return sb1.toString();
    }


    public static void main(String[] args) {
        String a = transfer("1234.0");
        System.out.println(a);
    }
}
