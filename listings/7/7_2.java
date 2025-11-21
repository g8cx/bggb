import java.io.*;

public class BinaryFileReader {
    
    public static void readBinaryFile(String filename) throws IOException {

        File file = new File(filename);
        InputStream is = new FileInputStream(file);
        long length = file.length(); 

        if (length > Integer.MAX_VALUE) { 
            throw new IOException("Файл " + file.getName() + " слишком длинный!");
        }

        byte[] bytes = new byte[(int)length];

        int offset = 0;
        int numRead = 0;
        
        while (offset < bytes.length && 
               (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
            
            offset += numRead;
        }

        if (offset < bytes.length) {
            throw new IOException("Не удалось прочитать файл " + file.getName() + " целиком.");
        }

        is.close();
        
    }
    
    public static void main(String[] args) {
        try {
            readBinaryFile("file.bin"); 
            System.out.println("Файл успешно прочитан в байтовый массив.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}