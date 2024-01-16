package controller;

import model.Employee;

import java.io.*;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.zip.*;

public class BackupService extends Thread {
    static CompletableFuture<Void> completableFuture = new CompletableFuture<>();

    public static void start(boolean flagOperation, boolean flagCompressionType, String fileName){
        if(flagOperation){
            backup(flagCompressionType, fileName);
        }
        else{
            restore(fileName);
        }
    }

    private static void backupEmployeeInstance(Employee employee, boolean flagCompressionType){
        try{
            if(flagCompressionType) {
                File file = new File(employee.getPesel() + ".gz");
                FileOutputStream fileOutputStream = new FileOutputStream(file);

                GZIPOutputStream gzipOutputStream = new GZIPOutputStream(fileOutputStream);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(gzipOutputStream);

                objectOutputStream.writeObject(Repository.getEmployees());
                objectOutputStream.close();
            }
            else{
                File file = new File(employee.getPesel() + ".zip");
                FileOutputStream fileOutputStream = new FileOutputStream(file);

                ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
                zipOutputStream.putNextEntry(new ZipEntry("backup.bin"));

                ObjectOutputStream objectOutputStream = new ObjectOutputStream(zipOutputStream);
                objectOutputStream.writeObject(Repository.getEmployees());

                zipOutputStream.closeEntry();
                zipOutputStream.close();
                objectOutputStream.close();
            }
        }
        catch (Exception e){
            System.out.println("Could not backup employee");
        }
    }

    private static void restoreEmployeeInstance(){

    }

    private static void backup(boolean flagCompressionType, String fileName){
        try{
            if (flagCompressionType){ // Backup to GZIP
                File file = new File( fileName + ".gz");
                FileOutputStream fos = new FileOutputStream(file);

                GZIPOutputStream gzip = new GZIPOutputStream(fos);
                ObjectOutputStream oos = new ObjectOutputStream(gzip);

                oos.writeObject(Repository.getEmployees());
                oos.close();
            }
            else{ // Backup to ZIP
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

            if (fileName.contains(".gz")){ // Restore from GZIP
                GZIPInputStream gis = new GZIPInputStream(fis);

                ObjectInputStream ois = new ObjectInputStream(gis);
                Object list = ois.readObject();

                Repository.setEmployees((List<Employee>) list);

                gis.close();
                ois.close();
            }
            else if(fileName.contains(".zip")){ // Restore from ZIP
                ZipInputStream zis = new ZipInputStream(fis);
                zis.getNextEntry();

                ObjectInputStream ois = new ObjectInputStream(zis);
                Object list = ois.readObject();

                Repository.setEmployees((List<Employee>) list);

                zis.closeEntry();
                zis.close();
                ois.close();
            }
        }
        catch (Exception e) {
            System.out.println("Could not read from file");
        }
    }
}
