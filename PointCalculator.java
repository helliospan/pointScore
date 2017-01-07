package main;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by poltaretskiyss on 22/12/2016.
 */
public class PointCalculator {

    String fileName = "c:\\polt\\java\\pointScore\\src\\files\\score.txt";
    private ArrayList<Goal> goalList = new ArrayList<Goal>();
    //FileManipulator fm = new FileManipulator(fileName);

    PointCalculator(){
        String strLine;

        // Чтение файла с массивом значений перед началом работы
        try {
            FileReader reader = new FileReader(fileName);
            BufferedReader bReader = new BufferedReader(reader);
            StringBuffer sBuffer = new StringBuffer();
            while ((strLine = bReader.readLine()) != null) {
                int firstParse = strLine.indexOf(";", 0);
                int secondParse = strLine.indexOf(";", firstParse + 1);
                int thirdParse = strLine.indexOf(";", secondParse + 1);
                String goalName = strLine.substring(0, firstParse);
                int goalScore = Integer.parseInt(strLine.substring(firstParse+1, secondParse));
                int goalTarget = Integer.parseInt(strLine.substring(secondParse+1, thirdParse));
                goalList.add(new Goal(goalName, goalScore, goalTarget));
            }
            bReader.close();
            reader.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }


    public void option(){

        printList();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the menu option: \n1: Insert goal \n2: Add point \n3: Save \n5: View list of goals");
        int var = sc.nextInt();

        if (var == 1){
            System.out.print("Enter a name of a goal: ");
            String title = sc.next();
            System.out.print("Enter a target of a goal: ");
            int target  = sc.nextInt();
            goalList.add(new Goal(title, 0, target));
            System.out.println("Element added (" + goalList.size() + ")");
            System.out.println();

            option();
        }
        else if (var == 2){
            System.out.print("Choose the goal to add point: ");
            int goalNum = sc.nextInt();
            goalList.set(goalNum - 1, new Goal(goalList.get(goalNum - 1).title, goalList.get(goalNum - 1).points + 1, goalList.get(goalNum - 1).target));
            System.out.println("");
            System.out.println();

            option();
        }
        else  if (var == 3){

            saveToFile();

            option();
        }
        else if (var == 5){
            printList();
            option();
        }
        else{

            return;
        }
    }

    public void saveToFile(){
        try {
            FileWriter writer = new FileWriter(fileName);
            for (int i = 0; i < goalList.size(); i++) {
                String wrtBuff = goalList.get(i).title + ";" + goalList.get(i).points + ";" + goalList.get(i).target + ";";
                System.out.println("Writing to file: " + wrtBuff);
                writer.write(wrtBuff);
                writer.write(System.getProperty( "line.separator" ));
                writer.flush();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printList (){
        System.out.println();
        System.out.println("The list of a goals (" + goalList.size() + "): ");
        for (int i = 0; i < goalList.size(); i++){
            System.out.println("The goal[" + (i+1) + "]: " + goalList.get(i).title + "(" + goalList.get(i).points + "/" + goalList.get(i).target+ ")" );
        }
        System.out.println();
    }

    public static void main(String[] args) {
        PointCalculator pc = new PointCalculator();
        pc.option();

        pc.saveToFile();
    }
}
