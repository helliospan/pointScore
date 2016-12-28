package main;

import java.io.*;

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
    }

    void FileWrite(Goal goal){

    }
}
