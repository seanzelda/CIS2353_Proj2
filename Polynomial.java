public class Polynomial {
    private static Node firstNode;
    private int numberOfNodes;
    
    public Polynomial() {
        firstNode = null;
        numberOfNodes = 0;
    }
    
    public Polynomial(String poly) {
        String[] polyArray = parsePolyString(poly);
        for(int i = 0; i < polyArray.length; i++) {
            Node node = getNode(polyArray[i]);
            if(isEmpty()) {
                firstNode = node;
                numberOfNodes++;
            }
            else {
                Node walker = firstNode;
                while(walker.nextNode != null) {
                    walker = walker.nextNode;
                }
                walker.nextNode = node;
                numberOfNodes++;
            }
            System.out.println(polyArray[i]);
        }
    }
    
    public Polynomial(Polynomial otherPoly) {
    
//        for(int i = 0; i < otherPoly.numberOfNodes; i++) {
//            if(isEmpty()) {
//                firstNode = otherPoly.firstNode;
//                numberOfNodes++;
//            }
//            else {
//                Node walker = otherPoly.firstNode;
//                Node newWalker = firstNode;
//                while(walker.nextNode != null) {
//                    walker = walker.nextNode;
//                    newWalker = newWalker.nextNode;
//                }
//                newWalker.nextNode = walker;
//                numberOfNodes++;
//            }
//        }
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < numberOfNodes; i++) {
            Node walker = firstNode;
                while(walker.nextNode != null) {
                    walker = walker.nextNode;
                }                
        }
        return builder.toString();
    }
    
    public String print() {
        return this.toString();
    }
    
    //public static boolean add(Polynomial poly1, Polynomial poly2) {
        //Node newNode = new Node();
        
        //newNode.nextNode = firstNode;
        
        //firstNode = newNode;
        //numberOfNodes++;
        
        //return true;     
    //}
    
    public boolean isEmpty() {
        return firstNode == null;
    }

    private Node getNode(String monomial) {

            String[] monArray = monomial.split("x");
            try {
                monArray[1] = monArray[1].replace("^", "");
            }
            catch (Exception ex) {
                
            }
            if(monArray.length == 1) {
                return new Node(Integer.parseInt(monArray[0]), -1);
            }
            return new Node(Integer.parseInt(monArray[0]), Integer.parseInt(monArray[1]));
    }
    
    private String[] parsePolyString(String poly) {
        String[] polyArray = poly.split("\\+");
        for(int i = 0; i < polyArray.length; i++) {
            polyArray[i] = polyArray[i].replace("-", "+-");
        }
        return polyArray;
    }
    
    private static class Node {
        private final int coefficient;
        private final int exponent;
        private Node nextNode;
    
        private Node(int coefficient, int exponent) {
            this.coefficient = coefficient;
            this.exponent = exponent;
            nextNode = null;
        }
        
        private Node(int coefficient, int exponent, Node nextNode) {
            this.coefficient = coefficient;
            this.exponent = exponent;
            this.nextNode = nextNode;
        }
    }
}
