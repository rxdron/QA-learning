package example;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ParsingTest {

    ClassLoader cl = ParsingTest.class.getClassLoader();

    @Test
    void parsingZipTest() throws Exception {
        try (InputStream resource = cl.getResourceAsStream("s.zip");
            ZipInputStream zis = new ZipInputStream(resource)) {

            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().endsWith(".csv")){
                    CSVReader csvReader = new CSVReader(new InputStreamReader(zis));
                    List<String[]> content = csvReader.readAll();
                    assertThat(content.get(0)[1]).contains("Lesson 13");

                } else if (entry.getName().endsWith(".xlsx")){
                    XLS content = new XLS(zis);
                    assertThat(
                            content.excel.getSheetAt(0).getRow(2).getCell(0).
                                    getStringCellValue()).contains("red0901d97c8280192f");
                } else if (entry.getName().contains("_page_fact_sheet.pdf")){
                    PDF content = new PDF(zis);
                    assertThat(content.numberOfPages).isEqualTo(1);
                }


            }
        }

    }
}
