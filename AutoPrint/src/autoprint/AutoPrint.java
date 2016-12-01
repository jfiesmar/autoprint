package autoprint;
import java.io.File;
import javax.print.*;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AutoPrint {

    public final String DIRECTORIO = "C:/autoprint";
    public final String FORMATO = ".pdf";
    private final int SLEEP_TIME = 10;
    FilenameFilter filter;

    public AutoPrint() {
        this.filter = new FilenameFilter() {
            @Override
            public boolean accept(File file, String name) {
                if (name.endsWith(FORMATO)) {
                    return true;
                } else {
                    return false;
                }
            }
        };
        
        
        Ini ini = new Ini(new File("/ini.txt"));
        System.out.println(ini.get("parametros", "directorio"));
    }

    public File[] listarDirectorio() throws IOException {
        File dir = new File(DIRECTORIO);
        File[] ficheros = dir.listFiles(filter);
        if (ficheros == null) {
            System.out.println("No hay ficheros en el directorio especificado");
        }
        return ficheros;

    }

    public void iniciarDemonio() throws IOException {
        while (true) {
            File[] listaFicheros = listarDirectorio();
            for (File fichero : listaFicheros) {
                System.out.println(fichero);
                imprimir(fichero);
                borrarFichero(fichero);
            }
            try {
                TimeUnit.SECONDS.sleep(SLEEP_TIME);
            } catch (InterruptedException ex) {
                Logger.getLogger(AutoPrint.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    /*   
     */
    public void imprimir(File fichero) throws IOException {
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

    }

    public void borrarFichero(File fichero) {
        fichero.delete();
    }

    public static void main(String args[]) throws IOException {

        AutoPrint ap = new AutoPrint();
        ap.iniciarDemonio();

    }
}
