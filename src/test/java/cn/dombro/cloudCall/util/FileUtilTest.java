package cn.dombro.cloudCall.util;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Created by 18246 on 2017/7/16.
 */
public class FileUtilTest {

    @Test
    public void uploadFiletest(){
        FileUtil.upload(new File("C:\\Users\\18246\\Desktop\\test.xlsx"),"test2");
        System.out.println(FileUtil.getFilePath());
    }
}