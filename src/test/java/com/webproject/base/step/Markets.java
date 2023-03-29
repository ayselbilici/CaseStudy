package com.webproject.base.step;

import com.thoughtworks.gauge.Step;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;


public class Markets extends StepImplemention {


    @Step("excele yaz <pageNumber>")
    public void writeToExcel(int pageNumber) throws IOException {
        FileInputStream file = new FileInputStream(new File("KriptoList.xlsx"));
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);

        XSSFRow row;

        List<WebElement> nameList = findElements("name_list");
        List<WebElement> priceList = findElements("price_list");
        List<WebElement> capacityList = findElements("capacity_list");

        Map<String, Object[]> kriptoData = new TreeMap<String, Object[]>();

        kriptoData.put("1", new Object[] { "İsim", "Fiyat", "Hacim" });


        int i=0;
        int j=0;

        if(pageNumber!=1){
            j=(50*pageNumber)-49;
        }

        for (WebElement item: nameList ) {
            kriptoData.put(String.valueOf(j), new Object[] {nameList.get(i).getText() , priceList.get(i).getText(), capacityList.get(i).getText() });
            i++;
            j++;
        }

        Set<String> keyid = kriptoData.keySet();

        int rowid = 0;


        for (String key : keyid) {

            row = sheet.createRow(rowid++);
            Object[] objectArr = kriptoData.get(key);
            int cellid = 0;

            for (Object obj : objectArr) {
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String)obj);
            }
        }

        FileOutputStream outputStream = new FileOutputStream("KriptoList.xlsx");
        workbook.write(outputStream);
        outputStream.close();

    }

}

