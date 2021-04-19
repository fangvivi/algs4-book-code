package com.wayne.poi;


import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.*;
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
                            riskAmount3.setFormula("101");
                            list.add(riskAmount3);

                            RiskAmount riskAmount19 = new RiskAmount();
                            riskAmount19.setRisk_code(cells[0]);
                            riskAmount19.setRisk_amount_code("19");
                            riskAmount19.setParameter_1(getValue(cells[2]));
                            riskAmount19.setFormula("101");
                            list.add(riskAmount19);

                            RiskAmount riskAmount23 = new RiskAmount();
                            riskAmount23.setRisk_code(cells[0]);
                            riskAmount23.setRisk_amount_code("23");
                            riskAmount23.setParameter_1(getValue(cells[2]));
                            riskAmount23.setFormula("101");
                            list.add(riskAmount23);
                            break;

                        case "人身险风险保额（包括自留）":
                            RiskAmount riskAmount4 = new RiskAmount();
                            riskAmount4.setRisk_code(cells[0]);
                            riskAmount4.setRisk_amount_code("4");
                            riskAmount4.setParameter_1(getValue(cells[2]));
                            riskAmount4.setFormula("101");
                            list.add(riskAmount4);

                            RiskAmount riskAmount24 = new RiskAmount();
                            riskAmount24.setRisk_code(cells[0]);
                            riskAmount24.setRisk_amount_code("24");
                            riskAmount24.setParameter_1(getValue(cells[2]));
                            riskAmount24.setFormula("101");
                            list.add(riskAmount24);
                            break;
                        case "未成年人身故保额（包括自留）":
                            RiskAmount riskAmount5= new RiskAmount();
                            riskAmount5.setRisk_code(cells[0]);
                            riskAmount5.setRisk_amount_code("5");
                            riskAmount5.setParameter_1(getValue(cells[2]));
                            riskAmount5.setFormula("101");
                            list.add(riskAmount5);

                            RiskAmount riskAmount25= new RiskAmount();
                            riskAmount25.setRisk_code(cells[0]);
                            riskAmount25.setRisk_amount_code("7");
                            riskAmount25.setParameter_1(getValue(cells[2]));
                            riskAmount25.setFormula("101");
                            list.add(riskAmount25);
                            break;
                        case "系统中校验契调校验保额（包括自留）":
                            RiskAmount riskAmount7= new RiskAmount();
                            riskAmount7.setRisk_code(cells[0]);
                            riskAmount7.setRisk_amount_code("7");
                            riskAmount7.setParameter_1(getValue(cells[2]));
                            riskAmount7.setFormula("101");
                            list.add(riskAmount7);

                            RiskAmount riskAmount26 = new RiskAmount();
                            riskAmount26.setRisk_code(cells[0]);
                            riskAmount26.setRisk_amount_code("26");
                            riskAmount26.setParameter_1(getValue(cells[2]));
                            riskAmount26.setFormula("101");
                            list.add(riskAmount26);
                            break;
                        case "系统中校验财务校验保额（包括自留）":
                            RiskAmount riskAmount8= new RiskAmount();
                            riskAmount8.setRisk_code(cells[0]);
                            riskAmount8.setRisk_amount_code("8");
                            riskAmount8.setParameter_1(getValue(cells[2]));
                            riskAmount8.setFormula("101");
                            list.add(riskAmount8);

                            RiskAmount riskAmount27 = new RiskAmount();
                            riskAmount27.setRisk_code(cells[0]);
                            riskAmount27.setRisk_amount_code("27");
                            riskAmount27.setParameter_1(getValue(cells[2]));
                            riskAmount27.setFormula("101");
                            list.add(riskAmount27);
                            break;
                        case "再保寿险净风险保额":
                            RiskAmount riskAmount20= new RiskAmount();
                            riskAmount20.setRisk_code(cells[0]);
                            riskAmount20.setRisk_amount_code("20");
                            riskAmount20.setParameter_1(getValue(cells[2]));
                            riskAmount20.setFormula("110");
                            if("0".equals(riskAmount20.getParameter_1())){
                                break;
                            }
                            list.add(riskAmount20);
                            break;
                        case "自驾车意外风险保额":
                            RiskAmount riskAmount30= new RiskAmount();
                            riskAmount30.setRisk_code(cells[0]);
                            riskAmount30.setRisk_amount_code("30");
                            riskAmount30.setParameter_1(getValue(cells[2]));
                            riskAmount30.setFormula("101");
                            if("0".equals(riskAmount30.getParameter_1())){
                                break;
                            }
                            list.add(riskAmount30);
                            break;
                        case "公路交通（含网约车）意外风险保额":
                            RiskAmount riskAmount31= new RiskAmount();
                            riskAmount31.setRisk_code(cells[0]);
                            riskAmount31.setRisk_amount_code("31");
                            riskAmount31.setParameter_1(getValue(cells[2]));
                            riskAmount31.setFormula("101");
                            if("0".equals(riskAmount31.getParameter_1())){
                                break;
                            }
                            list.add(riskAmount31);
                            break;
                        case "轨道交通意外风险保额":
                            RiskAmount riskAmount32= new RiskAmount();
                            riskAmount32.setRisk_code(cells[0]);
                            riskAmount32.setRisk_amount_code("32");
                            riskAmount32.setParameter_1(getValue(cells[2]));
                            riskAmount32.setFormula("101");
                            if("0".equals(riskAmount32.getParameter_1())){
                                break;
                            }
                            list.add(riskAmount32);
                            break;
                        case "水路交通意外风险保额":
                            RiskAmount riskAmount33= new RiskAmount();
                            riskAmount33.setRisk_code(cells[0]);
                            riskAmount33.setRisk_amount_code("33");
                            riskAmount33.setParameter_1(getValue(cells[2]));
                            riskAmount33.setFormula("101");
                            if("0".equals(riskAmount33.getParameter_1())){
                                break;
                            }
                            list.add(riskAmount33);
                            break;
                        case "民用航空意外风险保额":
                            RiskAmount riskAmount34= new RiskAmount();
                            riskAmount34.setRisk_code(cells[0]);
                            riskAmount34.setRisk_amount_code("34");
                            riskAmount34.setParameter_1(getValue(cells[2]));
                            riskAmount34.setFormula("101");
                            if("0".equals(riskAmount34.getParameter_1())){
                                break;
                            }
                            list.add(riskAmount34);
                            break;
                        case "骑行（不含乘坐）共享单车意外风险保额":
                            RiskAmount riskAmount35= new RiskAmount();
                            riskAmount35.setRisk_code(cells[0]);
                            riskAmount35.setRisk_amount_code("35");
                            riskAmount35.setParameter_1(getValue(cells[2]));
                            riskAmount35.setFormula("101");
                            if("0".equals(riskAmount35.getParameter_1())){
                                break;
                            }
                            list.add(riskAmount35);
                            break;
                        default:
                    }

                }
            }
            // 一个可追加的文件输出流流
            FileOutputStream fos = new FileOutputStream("C:\\Users\\fangw\\Desktop\\s.sql", true);
            // 缓冲输出流，把SQL写入文件
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            for (RiskAmount r : list) {
                System.out.println(r);
                String sql = "insert into t_risk_amount_parameter (formula, risk_code, " +
                        "risk_amount_code, customer, parameter_1) values (" +
                "\""+ r.getFormula()+"\", \"" + r.getRisk_code() + "\", \"" + r.getRisk_amount_code() +"\", \"" +
                "I\", \"" + r.getParameter_1() + "\");\n";
                System.out.println(sql);
                bos.write(sql.getBytes("utf-8"));
            }
            bos.flush();
            bos.close();
            fos.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取风险保额的参数
     * @param str
     * @return
     */
    public static String getValue(String str){
        // 一个数字开头的
        String pattern_a = "[0-9][\\u4e00-\\u9fa5]*";
        // 两个数字开头的
        String pattern_b = "[0-9][0-9][\\u4e00-\\u9fa5]*";
        // 含有小数的
        String pattern_c = "0\\.[0-9][0-9]\\*[\\u4e00-\\u9fa5]*\\*[\\u4e00-\\u9fa5]*";
        boolean oneNum = Pattern.matches(pattern_a,str);
        boolean twoNum = Pattern.matches(pattern_b,str);
        boolean threeNum = Pattern.matches(pattern_c,str);
        if(oneNum){
            return str.substring(0,1);
        }
        if(twoNum){
            return str.substring(0,2);
        }
        if(threeNum){
            return str.substring(0,4);
        }
        return "0";
    }


}
