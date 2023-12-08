package controller;

import model.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.*;

public class BackupService {
    public static void start(boolean flagOperation,boolean flagCompressionType, String fileName){
        if(flagOperation){
            backup(flagCompressionType, fileName);
        }
        else{
            restore(fileName);
        }
    }

    private static void backup(boolean flagCompressionType, String fileName){
        try{
            if (flagCompressionType){
                File file = new File(fileName + ".gzip");
                FileOutputStream fos = new FileOutputStream(file);
                GZIPOutputStream gzip = new GZIPOutputStream(fos);
                ObjectOutputStream oos = new ObjectOutputStream(gzip);
                oos.writeObject(Repository.getEmployees());
                oos.close();
            }
            else{
                File file = new File(fileName + ".zip");
                FileOutputStream fos = new FileOutputStream(file);
                ZipOutputStream zip = new ZipOutputStream(fos);
                zip.putNextEntry(new ZipEntry("backup.bin"));
                ObjectOutputStream oos = new ObjectOutputStream(zip);
                oos.writeObject(Repository.getEmployees());
                zip.closeEntry();
                zip.close();
                oos.close();
            }
        }
        catch (Exception e){
            System.out.println("Could not write to file");
        }
    }

    private static void restore(String fileName){
        try{
            File file = new File(fileName);
            FileInputStream fis = new FileInputStream(file);

            if (fileName.contains(".gzip")){
                ObjectInputStream ois = new ObjectInputStream(fis);
            }
            else if(fileName.contains(".zip")){
                ZipInputStream zis = new ZipInputStream(fis);
                zis.getNextEntry();
                ObjectInputStream ois = new ObjectInputStream(zis);
                Object lista = ois.readObject();
                Repository.setEmployees((List<Employee>) lista);
                zis.closeEntry();
                zis.close();
                ois.close();
            }
        } catch (Exception e) {
            System.out.println("Could not read from file");
        }

    }
}
