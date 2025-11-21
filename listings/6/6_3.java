import java.io.*;

public class ReadInput {

    Process proc = null;
    InputStream input = null;
    BufferedReader in = null;
    String cmd = null;

    public ReadInput(String cmd) throws IOException {
        this.cmd = cmd;
    }

    public String readLine() throws IOException {
        String line = null;

        if (in == null) {

            proc = Runtime.getRuntime().exec(cmd);
            input = proc.getInputStream();
            in = new BufferedReader(new InputStreamReader(input));
            
        }

        line = in.readLine();
        
        return line;
    } 

    public void close() {
        try {
            if (in != null) in.close();
            if (input != null) input.close();
            if (proc != null) proc.destroy();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            in = null;
            input = null;
            proc = null;
        }
    }

    public static void main(String[] args) {
        String cmd = null;

        if (args.length > 0) {
            cmd = args[0];
        } else {
            cmd = "ping localhost"; 
        }

        ReadInput ri = null;

        try {
            ri = new ReadInput(cmd);
            
            String line = null;
            while ((line = ri.readLine()) != null) {
                 System.out.println("-> " + line);
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (ri != null) ri.close();
        }

    }
    
}