package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" enter source file: ");
        String sourcePath= scanner.nextLine();
        System.out.println("enter destination file: ");
        String destPath = scanner.nextLine();

        File sourceFile = new File(sourcePath);
        File destFile = new File(destPath);

        try {
            copyFileUsingJava7File(sourceFile, destFile);
            System.out.println("copy completed");
        } catch (IOException ioe) {
            System.out.println(" can't copy that file");
            System.out.println(ioe.getMessage());

        }

    }
    private static void copyFileUsingJava7File(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);

    }
    private static void copyFileUsingStream (File souce, File dest) throws IOException{
        InputStream is= null;
        OutputStream os=null;
        try{
            is = new FileInputStream(souce);
            os = new FileOutputStream(dest);
            byte [] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer))>0){
                os.write(buffer, 0, length);
            }
        } finally {
           is.close();
           os.close();
        }

    }
}
