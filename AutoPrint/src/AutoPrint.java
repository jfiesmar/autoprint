
import java.io.File;
import javax.print.*;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AutoPrint {

    public void listarDirectorio() throws IOException {
        File dir = new File("c:/prueba");
        String[] ficheros = dir.list();
        if (ficheros == null) {
            System.out.println("No hay ficheros en el directorio especificado");
        } else {
            for (String fichero : ficheros) {
                System.out.println(fichero);
                imprimir(fichero);
                
            }
        }
    }

    public void imprimir(String fichero) throws IOException {
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(fichero);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (inputStream == null) {
            return;
        }

        DocFlavor docFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
        Doc document = new SimpleDoc(inputStream, docFormat, null);

        PrintRequestAttributeSet attributeSet = new HashPrintRequestAttributeSet();

        PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();

        if (defaultPrintService != null) {
            DocPrintJob printJob = defaultPrintService.createPrintJob();
            try {
                printJob.print(document, attributeSet);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("No existen impresoras instaladas");
        }

        inputStream.close();
        File f = new File (fichero);
        f.delete();
        
    }

    public static void main(String args[]) throws IOException {

        AutoPrint ap = new AutoPrint();

        while (true) {
            ap.listarDirectorio();
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(AutoPrint.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
}
