/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mqmonitoring;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.text.*;
/**
 *
 * @author aves
 */
public class sourceWriter {
    public static void writeFile(String text) {    
		try {

			String content = "This is the content to write into file";

			File file = new File("C:\\mqmonitoring\\monitoring_log.txt");

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
			BufferedWriter bw = new BufferedWriter(fw);
                        
                        Date dNow = new Date( );
                        SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd hh:mm:ss a zzz");
                        //System.out.println("Current Date: " + ft.format(dNow));
                        
			bw.write(ft.format(dNow) + " - QManager " + text + " is not running...");
                        //bw.write(text);
                        bw.newLine();
			bw.close();

			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}  
}
