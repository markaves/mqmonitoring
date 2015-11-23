/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mqmonitoring;
import java.io.*; 
/**
 *
 * @author aves
 */
public class MQMonitoring {

  public static void main(String args[]) {
    try {
      String line;
      //Process p = Runtime.getRuntime().exec("cmd /c type C:\\mqmonitoring\\stub.txt");
        //Stub:
        //QMNAME(QMC01)                                             STATUS(Ended normally)
        //QMNAME(QMC02)                                             STATUS(Ended unexpectedly)
        //QMNAME(QML01)                                             STATUS(Ended unexpectedly)
        
      Process p = Runtime.getRuntime().exec("cmd /c dspmq");
      BufferedReader bri = new BufferedReader
        (new InputStreamReader(p.getInputStream()));
      BufferedReader bre = new BufferedReader
        (new InputStreamReader(p.getErrorStream()));
      while ((line = bri.readLine()) != null) {
        System.out.println(line);
              //Get MQNAME
              String delims_0 = "[(]";
              String[] tokens_0 = line.split(delims_0);
              String QMNAME_temp = tokens_0[1];
              String delims_1 = "[)]";
              String[] tokens_1 = QMNAME_temp.split(delims_1);
              String QMNAME = tokens_1[0];
              //System.out.println(QMNAME);
              
              //Get Status
              String status_temp = tokens_0[2];
              String delims_2 = "[)]";
              String[] tokens_2 = status_temp.split(delims_2);
              String QMNAME_status = tokens_2[0];
              //System.out.println(QMNAME_status);
              
            
              if (!QMNAME_status.equals("Running")) {
                  System.out.println("Not running");
                  sourceWriter logging = new sourceWriter();
                  logging.writeFile(QMNAME);
              }

                  
      }
      bri.close();
      while ((line = bre.readLine()) != null) {
        System.out.println(line);
      }
      bre.close();
      p.waitFor();
      System.out.println("Done.");
    }
    catch (Exception err) {
      err.printStackTrace();
    }
  }
}
