package main;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Сергей on 27.12.2016.
 */
public class FileManipulator {

    public static FileWriter writer;

    FileManipulator(String fileName) throws Exception{
        try (FileWriter wr = new FileWriter(fileName, true)){
            FileManipulator.writer = wr;
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }

        //FileManipulator.writer = new FileWriter(fileName, true);

        System.out.println("Файл открыт: " + writer.toString());
    }

    void FileWrite(ArrayList<Goal> goals){
        System.out.println("Чтение и запись массива: " +  writer.toString());
        /*for (int i = 0; i < goals.size(); i++){
            try {
                //writer.write(goals.get(i).title+";"+goals.get(i).points+";");
                writer.write("1");
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
        try{
            FileManipulator.writer.write("1");
            writer.flush();
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    void FileClose(){
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
