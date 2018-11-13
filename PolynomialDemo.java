import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PolynomialDemo {
    public static void main(String[] args) {
        ArrayList<Polynomial> myArrayList = getPolyList();

        
        boolean keepGoing = true;
        Scanner input = new Scanner(System.in);
        String inputString;
        ArrayList<Integer> addNumbers = new ArrayList<>();
        while (keepGoing) {
            for(int i = 0; i < myArrayList.size(); i++) {
                System.out.println(i + " : " + myArrayList.get(i).toString());
            }//end for
            
            System.out.println("Which do you wish to add? Press -1 to Exit.");
            inputString = input.nextLine();
            
            String[] inputArray = inputString.split(" ");
            boolean goodInput = checkNumberRange(inputArray, myArrayList);
            if (!goodInput) {
                if(Integer.parseInt(inputArray[0]) == -1) {
                    keepGoing = false;
            }
            else {
                System.out.println("Sorry, that input is invalid.");
            }
            if (Integer.parseInt(inputArray[0]) == -1) {
                keepGoing = false;
            }
            else {
                for(String out : inputArray) {
                    addNumbers.add(Integer.parseInt(out));                  
                }
                //Remove after testing
                
                for(int out : addNumbers) {
                    System.out.println(out);
                }

            }
        }
    }
}
    
    private static ArrayList<Polynomial> getPolyList() {
        ArrayList<Polynomial> myArrayList = new ArrayList<>();
        
        try {
            File file = new File("/Users/seanzelda/Java/workdr/Node/src/polylist.txt");
            Scanner infile = new Scanner(file);
            infile = new Scanner(file);
            
            while(infile.hasNext()) {
                Polynomial poly = 
                        new Polynomial(infile.nextLine());
                myArrayList.add(poly);
                
                System.out.println(poly);
            }//end while
            infile.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println("Woops. File not found!");
        }//end try-catch
        
        return myArrayList;
    }
    
    private static boolean checkNumberRange(String[] addNumbers, ArrayList<Polynomial> polys) {
        for(String index : addNumbers) {
            try {
                polys.get(Integer.parseInt(index));
            }
            catch (IndexOutOfBoundsException ex) {

                return false;
            }
        }
        return true;
        
    }
} 
