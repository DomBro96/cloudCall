package cn.dombro.cloudCall.util;




import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.UUID;

/**
 * Created by 18246 on 2017/7/16.
 */
public class GeneratorUtil {

     private static int order  = 1;

     private static int passwordLen = 8;

     private static void addOrder(){
         order  = order + 1;
     }
     //流水号生成器
     public static long createRunningId(int mid){
        //1.获取当前日期
        LocalDate today = LocalDate.now();
        //2.设置日期的格式 yyyymmdd
        DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;
        String formartDate = formatter.format(today);
        String number = String.format("%04d",order);
        String runningId = formartDate+mid+number;
        addOrder();
        return Long.parseLong(runningId);
    }

    //账号生成器 （20）
    public static String creatAccount(){
        UUID uuid = UUID.randomUUID();
        String account = uuid.toString().replace("-","").substring(12);
        return account;
    }

    //密码生成器 （8）
    public static String creatPassword(){
        int random = createRandomInt();
        return createPassWord(random,passwordLen);
    }

    private static String createPassWord(int random,int len){
        Random rd = new Random(random);
        final int  maxNum = 62;
        StringBuffer sb = new StringBuffer();
        //取得随机数
        int rdGet;
        char[] str = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
                'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
                'x', 'y', 'z', 'A','B','C','D','E','F','G','H','I','J','K',
                'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
                'X', 'Y' ,'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        int count=0;
        while(count < len){
            rdGet = Math.abs(rd.nextInt(maxNum));//生成的数最大为62-1
            if (rdGet >= 0 && rdGet < str.length) {
                sb.append(str[rdGet]);
                count ++;
            }
        }
        return sb.toString();
    }

    private static int createRandomInt(){
        //得到0.0到1.0之间的数字，并扩大100000倍
        double temp = Math.random()*100000;
        //如果数据等于100000，则减少1
        if(temp>=100000){
            temp = 99999;
        }
        int tempint = (int)Math.ceil(temp);
        return tempint;
    }


}
