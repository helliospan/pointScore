package main;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Сергей on 27.12.2016.
 */
public class FileManipulator {

    FileWriter writer;

    FileManipulator(String fileName){
        try (FileWriter wr = new FileWriter(fileName, true)){
            writer = wr;
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }

        System.out.println("Файл открыт.");
    }

    void FileWrite(ArrayList<Goal> goals){
        System.out.println("Чтение и запись массива");
        for (int i = 0; i < goals.size(); i++){
            try {
                //writer.write(goals.get(i).title+";"+goals.get(i).points+";");
                writer.write("1");
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
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
