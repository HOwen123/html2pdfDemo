package Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

public class Html2pdf {
	public static final String HTML = "D:/a.html";
    public static final String DEST = "D:/a.pdf";
 
    /**
     * 
     * @param htmlPath(需要转换的html路径)
     * @param pdfPath(成功转成pdf后的目的路径)
     */
    public static void main(String[] args) {
		ProcessBuilder pb = new ProcessBuilder("D:\\tool\\wkhtmltopdf\\wkhtmltopdf\\bin\\wkhtmltopdf", HTML, DEST);  
        Process process;  
        try {  
            process = pb.start();  
            //注意，调用process.getErrorStream()而不是process.getInputStream()  
            BufferedReader errStreamReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));   
            System.out.println("read errstreamreader");  
            String line = null;  
            line = errStreamReader.readLine();   
            while(line != null) {   
                System.out.println(line);   
                line = errStreamReader.readLine();   
            }  
            process.destroy();  
            System.out.println("destroyed process");  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
	}
   
}
