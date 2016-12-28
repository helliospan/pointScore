package main;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by poltaretskiyss on 22/12/2016.
 */
public class PointCalculator {

    String fileName = "c:\\polt\\java\\pointScore\\src\\files\\score.txt";
    private ArrayList<Goal> goalList;

    {
        goalList = new ArrayList<Goal>();
    }

    public void option(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the menu option: \n1: Insert goal \n2: Add point \n3: Save \n5: View list of goals");
        int var = sc.nextInt();

        if (var == 1){
            System.out.print("Enter a name of a goal: ");
            String title = sc.next();
            goalList.add(new Goal(title, 0));
            System.out.println("Element added (" + goalList.size() + ")");
            System.out.println();

            option();
        }
        else if (var == 2){
            System.out.print("Choose the goal to add point: ");
            int goalNum = sc.nextInt();
            goalList.set(goalNum - 1, new Goal(goalList.get(goalNum - 1).title, goalList.get(goalNum - 1).points + 1));
            System.out.println("");
            System.out.println();

            option();
        }
        else  if (var == 3){
            FileManipulator fm = new FileManipulator(fileName);
            option();
        }
        else if (var == 5){
            System.out.println("The list of a goals (" + goalList.size() + "): ");
            for (int i = 0; i < goalList.size(); i++){
                System.out.println("The goal[" + (i+1) + "]: " + goalList.get(i).title + "(" + goalList.get(i).points + ")" );
            }
            System.out.println();

            option();
        }
        else{
            return;
        }
    }

    public static void main(String[] args) {
        PointCalculator pc = new PointCalculator();
        pc.option();

    }
}
