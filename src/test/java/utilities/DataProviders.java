package utilities;

import java.io.IOException;
import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "LoginData")
    public String[][] getData() throws IOException {

        String path = "C:\\Users\\Admin\\eclipse-workspace\\OpenCartDeo26\\testData\\LoginCred.xlsx";
        String sheetName = "Sheet1"; // FIX: define sheet name once, use everywhere

        ExcelUtility xutil = new ExcelUtility(path);

        int totalRows = xutil.getRowCount(sheetName);       // FIX: pass sheetName, not path
        int totalCells = xutil.getCellCount(sheetName, 0);  // FIX: pass sheetName, not path
                                                             //      row 0 = header row, used to count columns

        String loginData[][] = new String[totalRows][totalCells];

        for (int i = 1; i <= totalRows; i++) {
            for (int j = 0; j < totalCells; j++) {  // FIX: j < totalCells, not j <= totalCells
                loginData[i - 1][j] = xutil.getCellData(sheetName, i, j);
            }
        }

        return loginData;
    }
}

