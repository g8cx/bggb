import java.util.zip.*;
import java.io.*;


public class ZipDirTest {

    public static void main(String[] args) {
        
        if (args.length != 2) {
            System.out.println("Usage: java ZipDirTest <имя_архива> <имя_папки>");
            return;
        }

        String zipFile = args[0];
        String zippedDir = args[1];

        try {
            System.out.println("Начало архивации папки: " + zippedDir);
            
            exec(zipFile, zippedDir); 
            
            System.out.println("Архив был записан успешно: " + zipFile);

        } catch (FileNotFoundException fnfe) {
            System.err.println(fnfe.getMessage());
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }
        
    }
    
    public static void exec(String zipFile, String zippedDir) throws IOException {
        
        FileOutputStream fos = new FileOutputStream(zipFile);
        ZipOutputStream zos = new ZipOutputStream(fos);

        walkingDir(zos, zippedDir);

        zos.close();
        fos.close(); 
    }


    public static void walkingDir(ZipOutputStream zos, String zippedDir) throws IOException {
        
        File dir = new File(zippedDir);
        String[] dirList = dir.list(); 

        final int BUFFER_SIZE = 2048; 
        byte[] bytes = new byte[BUFFER_SIZE];
        
        if (dirList != null) {
            for (int i = 0; i < dirList.length; i++) {
                
                String fullPath = zippedDir + File.separator + dirList[i];
                File f = new File(fullPath); 
                
                if (f.isDirectory()) {
                    walkingDir(zos, fullPath); 
                    continue;
                } 
                
                else {
                    
                    try {

                        String entryPath = Paths.get(zippedDir).getParent().relativize(Paths.get(fullPath)).toString();
                        
                        ZipEntry ze = new ZipEntry(entryPath);
                        zos.putNextEntry(ze);

                        FileInputStream fis = new FileInputStream(fullPath);
                        int bytesRead;

                        while ((bytesRead = fis.read(bytes, 0, BUFFER_SIZE)) != -1) {
                            zos.write(bytes, 0, bytesRead);
                        }

                        fis.close();
                        zos.closeEntry();
                        
                    } catch (FileNotFoundException fnfe) {
                        System.err.println("Ошибка (FileNotFound): " + fnfe.getMessage());
                    } catch (IOException ioe) {
                        System.err.println("Ошибка (IO): " + ioe.getMessage());
                    }
                } 
            }
        }
    }
}