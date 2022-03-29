/**
 * The class UnitMarksA1 holds the marks of the 25 students of a Unit Subject. From the input marks of the students, the 
 * Java Program calculates the highest marks, and the lowest marks of the class. Then, it also calculates the Mean and 
 * Standard Deviation of the marks of the Class of the Unit Subject.
 *
 * @author (Syeda Farheen Anjum)
 * @version (1.3/29-03-2022)
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class UnitMarksA1
{
 //Instance Variable
 private String unitName;
 private int studentNumber;
 private String line;
 private ArrayList<Double> unitMarks;
 //Constructor for the class UnitMarksA1
 public UnitMarksA1(String unitNameArgs)
 {
  unitName = unitNameArgs; 
  studentNumber = 25;
  unitMarks = new ArrayList<Double>();
 }
 public void readFile()
 {
  int countMarks=0; 
  try{
      File myFile = new File("ClassMarks.txt"); 
      Scanner myScanner = new Scanner(myFile); 
      while(myScanner.hasNextLine()){
          line = myScanner.nextLine(); 
          countMarks++;
          if(countMarks>=1){
            unitMarks.add(Double.valueOf(line));
          }
      }
  }catch(FileNotFoundException e){
    System.out.println("The file cannot be found");
    e.printStackTrace();
  }
 }
 
 public void MaximumStudentMarks()
 { 
  /**
  * Calculating the Maximum Marks of the List of Students
  */
  double maximumStudentMarks = unitMarks.get(0); //maximumStudentMarks holds the first value of the student marks array
  for(int i = 0; i < studentNumber; i++) //Looping through the Array of 25 Student Marks.
  {
   if(maximumStudentMarks < unitMarks.get(i)) //Checking with marks with maximumStudentMarks to be higher than it. 
   {
    maximumStudentMarks = unitMarks.get(i); //Reassigning the maximumStudentMarks
   }
  }
  System.out.println("The Maximum Student Marks in the Unit Subject: " + unitName + " is calculated as " + maximumStudentMarks);
 }
 
 public void MinimumStudentMarks()
 {
  /**
   * Calculating the Minimum Marks of the List of Students
   */
  double minimumStudentMarks = unitMarks.get(0); //minimumStudentMarks holds the first value of the student marks array
  for(int i = 0; i < studentNumber; i++)
  {
   if(minimumStudentMarks > unitMarks.get(i)) //Checking if any value in the array is lesser than minimumStudentMarks
   {
    minimumStudentMarks = unitMarks.get(i); //Reassigning the minimumStudentMarks
   }
  }
  System.out.println("The Minimum Student Marks in the Unit Subject: " + unitName + " is calculated as " + minimumStudentMarks);
 }
 
 public void MeanStudentMarks()
 {
  /**
   * Calculating the Mean (Average) Marks of the List of Students
   */
  double meanSum = 0;
  double meanStudentMarks; //Mean (Average) student marks
  for(int i = 0; i < studentNumber; i++)
  {
   meanSum = meanSum + unitMarks.get(i); //Total of the Sum of the Student Marks 
  }
  meanStudentMarks = meanSum / studentNumber; //Sum of Student Marks with the Number of Students to calculate the average.
  System.out.println("The Mean (Average) Student Marks in the Unit Subject: " + unitName + " is calculated as " + meanStudentMarks);
 }
 
 public void STDStudentMarks()
 {
  /**
   * Calculating the Standard Deviation Marks of the List of Students
   */
  double sumSD = 0; 
  double meanSum = 0;
  double meanStudentMarks; //Mean (Average) student marks
  double standarddeviationStudentMarks; 
  for(int i = 0; i < studentNumber; i++)
  {
   meanSum = meanSum + unitMarks.get(i); //Total of the Sum of the Student Marks 
  }
  meanStudentMarks = meanSum / studentNumber; //Sum of Student Marks with the Number of Students to calculate the average.
  //Formula for the calculation of the Standard Deviation Square Root (Sum(Marks - Average)/(Number - 1))
  for (int i = 0; i < studentNumber; i++) 
  {
   sumSD = sumSD + (unitMarks.get(i) - meanStudentMarks) * (unitMarks.get(i) - meanStudentMarks); 
  }
  sumSD = sumSD / (studentNumber - 1); 
  standarddeviationStudentMarks = (double)Math.round(Math.sqrt(sumSD)); //Standard Deviation of the Students
  System.out.println("The Standard Deviation of the Student Marks in the Unit Subject: " + unitName + " is calculated as " + standarddeviationStudentMarks);
 }
 public static void main(String[] args)
 {
  Scanner input = new Scanner(System.in); 
  //Input the Name of the Subject Unit
  System.out.println("Input the Name of the Unit: ");
  String unitName = input.nextLine(); 
  UnitMarksA1 myObj = new UnitMarksA1(unitName);
  System.out.print(System.lineSeparator()); //New line 
  System.out.print(System.lineSeparator()); //New line 
  System.out.println("The Name of Unit Subject: " + unitName);
  myObj.readFile();
  myObj.MaximumStudentMarks();
  myObj.MinimumStudentMarks();
  myObj.MeanStudentMarks();
  myObj.STDStudentMarks();
 }
}
