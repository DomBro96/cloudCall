package cn.dombro.cloudCall.util;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by 18246 on 2017/7/16.
 */
public class PoiUtil {

    private static XSSFWorkbook workbook = null;

    private static List<String> cellList = null;

    public static List<String> getCellList(){
        return cellList;
    }
 //获取 到 该 Excle 文件对应的 cellList 后
// 1.遍历 cellList 获取 每一行 的单元格合并后字符串
// 2.使用正则表达式 将 1 的字符串 拆分为 字符串数组，数组中对应索引元素就是 电话，姓名，内容
//    for (String cell:cellList){
//        String[] cellArray = cell.split("/");
//        System.out.print("流水号 : "+GeneratorUtil.createRunningId(3342));
//        System.out.print(" 电话 : " + cellArray[0]);
//        System.out.print(" 姓名 : " + cellArray[1]);
//        System.out.print(" 业务 ：" + cellArray[2]);
//        System.out.println();
//
//    }

    public static void readSheet(File file,int sheetNum){
        try {
            workbook = new XSSFWorkbook(file);
            if (workbook == null) {
                System.out.println("file not found");
            }
            cellList = new ArrayList<>();
            //查看 Excle 第一个 表格
            XSSFSheet sheet = workbook.getSheetAt(sheetNum);
            for (int numRow = 1; numRow <= sheet.getLastRowNum(); numRow++){

                XSSFRow row = sheet.getRow(numRow);
                String phoneCell = getCellValue(row.getCell(0));
                String name = getCellValue(row.getCell(1));
                String matter = getCellValue(row.getCell(2));
                //1.每行的 单元格 的字符串形式 拼成一个长的字符串
                String cell = phoneCell+"/"+name+"/"+matter;
                //2.把 1 获取 的 String 添加 到 List<String> 中
                cellList.add(cell);
            }
        } catch ( Exception e) {
            e.printStackTrace();
        }
    }

    //将 每个 单元格 内容 转为 String 类型
    private static String getCellValue(XSSFCell cell) {
        DecimalFormat df = new DecimalFormat("0");
        String value ;
        if (cell == null) return "";
        if (cell.getCellType() == cell.CELL_TYPE_BOOLEAN) {
            value = String.valueOf(cell.getBooleanCellValue());
            return value;
        } else if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
            value = df.format(cell.getNumericCellValue());
            return value;
        } else {
            value =  String.valueOf(cell.getStringCellValue());
            return value;
        }
    }
}
