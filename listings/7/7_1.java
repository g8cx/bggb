import java.io.File;

public class FileUtils {

    public static void deleteDir(String dirPath) {

        File walkDir = new File(dirPath);
        
        String[] dirList = walkDir.list(); 

        if (dirList != null) {
            for (int i = 0; i < dirList.length; i++) {
                
                File f = new File(walkDir, dirList[i]); 
                
                if (f.isDirectory()) {
                    deleteDir(f.getAbsolutePath()); 
                }
                
                f.delete(); 
            }
        }
        
        walkDir.delete();
        
    } 
}