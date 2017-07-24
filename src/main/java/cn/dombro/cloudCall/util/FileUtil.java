package cn.dombro.cloudCall.util;
import com.jfinal.kit.PathKit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;


/**
 * Created by 18246 on 2017/7/16.
 */
public class FileUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileUtil.class);

    private static String filePath;

    //文件在 当前 web 项目根路径下的位置
    private static String fileView;

    //设置 文件 上传位置
    public static void setFileview(String  view){
        fileView = view;
    }

    // 文件的 绝对路径
    public static String getFilePath(){
        return filePath;
    }

    //参数 源文件 ，新文件的名字
    public static void upload(File source, String filename){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        //1.获取 扩展名
        String fileName = source.getName();
        String extension = fileName.substring(fileName.lastIndexOf("."));

        if (".jpg".equals(extension) || ".png".equals(extension)){
             fileView = "imgFile";
        }else{
             fileView = "excleFile";
        }


        fileName = filename + extension;
        //2.将文件 写入目标文件
        try {
            fis = new FileInputStream(source);
            //目标文件夹
            File targetDir = new File(PathKit.getWebRootPath()+"/"+fileView);
            if (!targetDir.exists()){
                targetDir.mkdir();
            }
            File target = new File(targetDir,fileName);
            if (!target.exists()){
                target.createNewFile();
            }
            filePath = target.getPath();
            fos = new FileOutputStream(target);
            byte[] buff = new byte[500];
            while (fis.read(buff,0,buff.length) != -1){
                fos.write(buff,0,buff.length);
            }
        } catch (FileNotFoundException e) {
            LOGGER.error("文件上传失误",e);
            e.printStackTrace();
        } catch (IOException e) {
            LOGGER.error("文件写入服务器出现失误 ",e);
            e.printStackTrace();
        }finally {
            try {
                fos.close();
            } catch (IOException e) {
                LOGGER.error("文件输出流关闭失败",e);
                e.printStackTrace();
            }
            try {
                fis.close();
            } catch (IOException e) {
                LOGGER.error("文件输入流关闭失败",e);
                e.printStackTrace();
            }
        }
    }
}

