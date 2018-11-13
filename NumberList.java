
public class NumberList {
    private Node firstNode;
    private int numberOfEntries;
    private String theLine;
       
    public NumberList(String singleLine) {
           String[] comps = singleLine.split(",");
           constructList(comps);
    }//end ctor
    
    private void constructList(String[] components) {
        for(int i = 0; i < components.length; i++) {
            int dataValue = Integer.parseInt(components[i]);
            Node newNode = new Node(dataValue);
            if(isEmpty()) {  //we're the first node
                firstNode = newNode;
            }
            else {
                Node walker = firstNode;
                //walk down the list to find your place
                
                while(walker.next != null) {
                    walker = walker.next;
                }//yay we found the end!
                walker.next = newNode;
                
            }//end if-else
            System.out.println(components[i]);
        }//end for
        //yay we constructed our entire number list!!!!!
        System.out.println("\n\n");
    }//end constructList
    
    public void print() {
        Node walker = firstNode;
        while(walker != null) {
            System.out.print(walker.data);
            if(walker.next != null) {
                System.out.print(" : ");
            }
            walker = walker.next;
        }//end while
    }//end print
    
    public boolean isEmpty() {
        return firstNode == null;
    }//end isEmpty
    
    private class Node {
        private int data;
        private Node next;
        
        public Node(int data) {
            this(data, null); //calls other ctor
        }
        
        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }//end node class
    
}//end NumberList
