package cn.dombro.cloudCall.util;

import org.junit.Test;
import java.io.File;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by 18246 on 2017/7/16.
 */
public class PoiUtilTest {

    @Test
    public void testReadShell(){
       File file = new File("C:\\Users\\18246\\Desktop\\test.xlsx");
       PoiUtil.readSheet(file,0);
       //形如 {小张/1399211231/, 小李/1399211232/, 小刘/1399211233/, 小赵/1399211234/}
       List<String> stringList = PoiUtil.getCellList();
       System.out.println(stringList);
       System.out.println(stringList.get(0));
       for (String cell:stringList){
           String[] cellArray = cell.split("/");
               System.out.print("流水号 : "+GeneratorUtil.createRunningId(3342));
               System.out.print(" 电话 : " + cellArray[0]);
               System.out.print(" 姓名 : " + cellArray[1]);
               System.out.print(" 业务 ：" + cellArray[2]);
               System.out.println();

       }
    }

}