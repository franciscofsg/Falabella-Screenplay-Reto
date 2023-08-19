package com.falabela.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

public class ExcelDataReader {

    public static Map<String, String> getMapData(String hojaDataDriver) {

        Map<String, String> testData = null;

        try {
            //Se crea variable map para almacenar la informacion del dataDriver
            testData = new HashMap<String, String>();

            //Se prepara el archivo dataDriver para obtener su informacion
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/Data/Data.xlsx");
            Workbook workbook = new XSSFWorkbook(fileInputStream);

            Sheet sheet=null;

            if (hojaDataDriver=="producto") {
                sheet = workbook.getSheet("producto");
            }

            //Se guarda en la variable numeroTotalColumna el numero de la ultima columna con informacion
            int numeroTotalColumna = sheet.getRow(0).getLastCellNum();

            //Se recorre cada columna de la hoja del dataDriver
            for (int i = 0; i < numeroTotalColumna; i++) {

                //Se posiciona en la celda con coordenadas, fila=0, columna=i, encabezados de las columnas
                Cell encabezado = sheet.getRow(0).getCell(i);

                //Se guarda en una variable de tipo String el valor que contiene la celda con las coordenadas definidas
                String key = encabezado.getStringCellValue().trim();

                //Se posiciona en la celda con coordenadas, fila=1, columna=i, valor de cada encabezado de las columnas
                Cell valores = sheet.getRow(1).getCell(i);

                //Se guarda en una variable de tipo String el valor que contiene la celda con las coordenadas definidas
                String valor = valores.getStringCellValue().trim();

                //Campo vacío en el datadriver se debe diligenciar con el signo "-"
                if (valor.equals("-")){
                    testData.put(key,"");
                }
                else {
                    testData.put(key, valor);
                }
            }

        } catch (Exception e) {
            System.out.println("No se pudo leer el dataDriver");
        }

        return testData;
    }

}