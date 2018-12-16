package com.zhangyi;

import java.util.UUID;

/**
 * @ClassName: parseHexBase64
 * @description:
 * @author: zhangyi
 * @since: 2018-12-13 15:42
 */
public class parseHexBase64 {

    private static final char[] _UUID64 =
            "-0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ_abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static final char[] _HEX = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
    public static void main(String[] args) {
        String a = UUID64(UUID.randomUUID());
        System.out.println(a);
        System.out.println(UUID16(a));
    }
    /**
     * @return java.lang.String
     * @Description 用64进制来表示UUID
     * @Param uu 传入由JDK获得的uuid对象
     **/
    public static String UUID64(UUID uu) {
            String uuidStr = uu.toString();
            int tmp = 0;
            int flag=0;
            StringBuffer result = new StringBuffer();
            for (int i = 0; i < 36; i++) {
                if (i == 8 || i == 13 || i == 18 || i == 23) {
                    continue;
                }
                flag++;
                char c = uuidStr.charAt(i);
                short shortValue = Short.valueOf(String.valueOf(c), 16);
                System.out.println(shortValue);
                tmp+=shortValue*(16^i);
                System.out.println();
                if(flag==4){
                    flag=0;
                    while(tmp>0){
                        result.append(_UUID64[tmp%64]);
                        tmp = tmp >> 6;
                    }
                    tmp=0;
                }
                System.out.println(flag+" "+tmp);

            }
            System.out.println(uuidStr);
        return result.toString();
    }


    public static String UUID16(String uuid64) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuffer result = new StringBuffer();
        char[] a  = uuid64.toCharArray();
        for(int i=0;i<16;i++){
            for(int j = 0;j<64; j++){
                if(_UUID64[j]==a[i]){
                    int num = j;
                    System.out.println(num);
//                    while (num >0){
//                        stringBuilder.append(_HEX[num % 16]);
//                        num = num >> 4 ;
//                    }
                }
            }

        }
        return stringBuilder.toString();
    }
}
