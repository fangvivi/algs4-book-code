package com.wayne.doc;


import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class POIDemo {
    public static void main(String[] args) {
        try {
            readAndWriterTest4();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void readAndWriterTest4() throws IOException {
        File file = new File("C:\\Users\\fangw\\Desktop\\test.docx");
        try {
            FileInputStream fis = new FileInputStream(file);
            XWPFDocument xdoc = new XWPFDocument(fis);
            XWPFWordExtractor extractor = new XWPFWordExtractor(xdoc);
            String doc = extractor.getText();
            // 每一行的内容
            String[] rows = doc.split("\\n");
            List<RiskAmount> list = new ArrayList<>();
            for (String row : rows){
                String[] cells = row.split("\\t");
                if(cells.length > 1){
                    System.out.println(Arrays.toString(cells));
                    switch (cells[1]){
                        case "意外险风险保额（包括再保、自留）":
                            RiskAmount riskAmount3 = new RiskAmount();
                            riskAmount3.setRisk_code(cells[0]);
                            riskAmount3.setRisk_amount_code("3");
                            riskAmount3.setParameter_1(getValue(cells[2]));
                            list.add(riskAmount3);

                            RiskAmount riskAmount19 = new RiskAmount();
                            riskAmount19.setRisk_code(cells[0]);
                            riskAmount19.setRisk_amount_code("19");
                            riskAmount19.setParameter_1(getValue(cells[2]));
                            list.add(riskAmount19);

                            RiskAmount riskAmount23 = new RiskAmount();
                            riskAmount23.setRisk_code(cells[0]);
                            riskAmount23.setRisk_amount_code("23");
                            riskAmount23.setParameter_1(getValue(cells[2]));
                            list.add(riskAmount23);
                            break;

                        case "人身险风险保额（包括自留）":
                            RiskAmount riskAmount4 = new RiskAmount();
                            riskAmount4.setRisk_code(cells[0]);
                            riskAmount4.setRisk_amount_code("4");
                            riskAmount4.setParameter_1(getValue(cells[2]));
                            list.add(riskAmount4);

                            RiskAmount riskAmount24 = new RiskAmount();
                            riskAmount24.setRisk_code(cells[0]);
                            riskAmount24.setRisk_amount_code("24");
                            riskAmount24.setParameter_1(getValue(cells[2]));
                            list.add(riskAmount24);
                            break;
                        case "系统中校验契调校验保额（包括自留）":
                            RiskAmount riskAmount7= new RiskAmount();
                            riskAmount7.setRisk_code(cells[0]);
                            riskAmount7.setRisk_amount_code("7");
                            riskAmount7.setParameter_1(getValue(cells[2]));
                            list.add(riskAmount7);

                            RiskAmount riskAmount26 = new RiskAmount();
                            riskAmount26.setRisk_code(cells[0]);
                            riskAmount26.setRisk_amount_code("26");
                            riskAmount26.setParameter_1(getValue(cells[2]));
                            list.add(riskAmount26);
                            break;
                        case "系统中校验财务校验保额（包括自留）":
                            RiskAmount riskAmount8= new RiskAmount();
                            riskAmount8.setRisk_code(cells[0]);
                            riskAmount8.setRisk_amount_code("8");
                            riskAmount8.setParameter_1(getValue(cells[2]));
                            list.add(riskAmount8);

                            RiskAmount riskAmount27 = new RiskAmount();
                            riskAmount27.setRisk_code(cells[0]);
                            riskAmount27.setRisk_amount_code("27");
                            riskAmount27.setParameter_1(getValue(cells[2]));
                            list.add(riskAmount27);
                            break;
                        case "自驾车意外风险保额":
                            RiskAmount riskAmount30= new RiskAmount();
                            riskAmount30.setRisk_code(cells[0]);
                            riskAmount30.setRisk_amount_code("30");
                            riskAmount30.setParameter_1(getValue(cells[2]));
                            list.add(riskAmount30);
                            break;
                    }

                }
            }
            for (RiskAmount r : list) {
                System.out.println(r);
            }
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getValue(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str.charAt(0)+"");
        if(isNum.matches()){
            return str.substring(0,1);
        } else {
            return "0";
        }
    }


}
