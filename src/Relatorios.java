
import java.awt.Label;
import java.io.File;
import jxl.Workbook;
import jxl.write.NumberFormat;
import jxl.write.WritableCell;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import jxl.format.UnderlineStyle;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author paulo.bezerra
 */
public class Relatorios {


    public static void main(String[] args) throws Exception {

        File file = new File("C:\\Users\\paulo.hbezerra\\Desktop\\Export.csv");

        WritableWorkbook myexcel = Workbook.createWorkbook(file);
        WritableSheet mysheet = myexcel.createSheet("Report PI", 1);

        
        myexcel.write();
        myexcel.close();

    }

}
