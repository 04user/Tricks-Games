package ua.nikiforov.main;

import java.io.*;

/**
 * @author Sergey Nikiforov
 */
public class ExecShell {
    public static void main(String[] args) throws IOException {
        Process process = Runtime.getRuntime().exec("cmd.exe");
        OutputStream outputStream = new BufferedOutputStream(process.getOutputStream());
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        outputStream.write("mvn -version\n".getBytes());
        outputStream.write("exit\n".getBytes());
        outputStream.flush();

//        long count = reader.lines().count();
//        System.out.println(count);
        reader.lines().forEach(System.out::println);
//        String line;
//        while ((line = reader.readLine()) != null) {
//            System.out.println("line = " + line);
//        }
    }
}
