package controller;

public class BackupService {
    public void start(boolean flagOperation,boolean flagCompressionType, String fileName){
        if(flagOperation){
            backup(flagCompressionType, fileName);
        }
        else{
            restore(flagCompressionType, fileName);
        }
    }

    private void backup(boolean flagCompressionType, String fileName){
        if (flagCompressionType){

        }
        else{

        }
    }

    private void restore(boolean flagCompressionType, String fileName){
        if (flagCompressionType){

        }
        else{

        }
    }
}
