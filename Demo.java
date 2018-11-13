import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        ArrayList<NumberList> myArrayList;
        myArrayList = new ArrayList<>();
        getLines(myArrayList);
        printLists(myArrayList);
    }//end main
    
    public static void getLines(ArrayList<NumberList> theDubList) {
        Scanner infile;
        File theFile = new File("/Users/seanzelda/Java/workdr/Week11Example/src/new1.txt");
        String tempLine;
        
        try {
            infile = new Scanner(theFile);
            
            while(infile.hasNext()) {
                tempLine = infile.nextLine();
                NumberList tempNL = 
                        new NumberList(tempLine);
                theDubList.add(tempNL);
            }//end while
            infile.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println("Woops. File not found!");
        }//end try-catch
    }//end getLines
    
    public static void printLists(
            ArrayList<NumberList> theDubList) {
        
        for(int i = 0; i < theDubList.size(); i++) {
            theDubList.get(i).print();
            System.out.println();
        }//end for
    }//end printLists
}//end demo
