package com.wayne.poi;


import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.*;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @author wayne
 */
public class POIMedical {
    // 是否有医保
    private static String[] MEDICAL = {"Y","N"};
    // 险种编码
    private static String  RISK_CODE = "121707";

    private static String SQL = "insert into t_risk_rate_detail_renewal " +
            "(risk_code, age, is_medical_insurance, amount_insured, rate) " +
            "values (\'";
    public static void main(String[] args) {
        try {
            // 需要读取的word文档
            File in = new File("C:\\Users\\fangw\\Desktop\\test.docx");
            // 内容输出文件
            File out = new File("C:\\Users\\fangw\\Desktop\\"+RISK_CODE+".sql");
            if(out.exists()){
                out.delete();
                out = new File("C:\\Users\\fangw\\Desktop\\"+RISK_CODE+".sql");
            }
            // 一个可追加的文件输出流
            FileOutputStream fos = new FileOutputStream(out, true);
            readAndWriteTest(in,fos);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void readAndWriteTest(File file, FileOutputStream fos){
        // 缓冲输出流，把SQL写入文件
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        try {
            FileInputStream fis = new FileInputStream(file);
            XWPFDocument xdoc = new XWPFDocument(fis);
            XWPFWordExtractor extractor = new XWPFWordExtractor(xdoc);
            String doc = extractor.getText();
            System.out.println(doc);
            // 每一行的内容
            String[] rows = doc.split("\\n");
            // 获取险种代码
            int length = rows[0].length();
            for (String row : rows){
                String[] cells = row.split("\\t");
                if(cells.length > 1){
                    System.out.println(Arrays.toString(cells));
                    analyzeStr(cells, bos);
                }
            }
            bos.flush();
            bos.close();
            fos.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String[] getAmountInsuredList(String[] strList){
        return null;
    }

    /**
     * 解析费率字符串，生成SQL
     * @param strList
     * @param bos
     * @throws IOException
     */
    public static void analyzeStr(String[] strList, BufferedOutputStream bos) throws IOException {
        String str = "insert into table_name ";
        // 年龄区间
        String[] minAndMaxAge = strList[0].split("-");
        // 区间最小年龄
        int minAge = Integer.valueOf(minAndMaxAge[0]);
        // 区间最大年龄年龄
        int maxAge = Integer.valueOf(minAndMaxAge[1]);
        // 遍历这个区间所有的年龄
        for (int i = minAge; i <= maxAge ; i++) {
            // 遍历所有的保额
            for (int j = 0; j < MEDICAL.length; j++) {
                StringBuilder stringBuilder = new StringBuilder(SQL);
                stringBuilder.append(RISK_CODE)
                        .append("\',")
                        .append(i)
                        .append(",\'")
                        .append(MEDICAL[j])
                        .append("\',\'\',\'")
                        .append(strList[j+1]).append("00")
                        .append("\');\n");
                String sql = stringBuilder.toString();
                System.out.println(sql);
                bos.write(sql.getBytes("utf-8"));
            }
        }
    }

}
