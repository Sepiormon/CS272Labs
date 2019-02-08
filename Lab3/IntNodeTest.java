/**
* @author Alexander Morgan
* @date 02/05/2019
*
**/

class IntNodeTest{
   
   public static void main(String[] args){
      
      IntNode n1 = new IntNode();//testing default constructor
      IntNode n2 = new IntNode(2, n1); //testing argument constructor
      IntNode n3 = new IntNode();// get/set tester
      
      //testing get()'s and set()'s
      System.out.printf("Getting Value from default constructor. should be 0: (%d)\n", n3.getValue());
      System.out.print("Getting link reference, should be null: ");
      System.out.println(n3.getLink());
      System.out.println("Setting value and link, should be 24 and not null: ");
      n3.setValue(24);
      n3.setLink(n2);
      System.out.println(n3.getValue() + " & " + n3.getLink());
      System.out.println();
      
      System.out.print("Testing listLength(), should be 2: ");
      System.out.println(IntNode.listLength(n3));
      System.out.println();
      
      //n3->n2->n1
      System.out.println("Testing toString()");
      System.out.println(n3.toString());
      System.out.println(n2.toString());
      System.out.println(n1.toString());
      System.out.println();
      
      //n3->n2->newnode->n1
      System.out.println("Testing addNodeAfterThis():");
      n2.addNodeAfterThis(15);
      System.out.println(n3.toString());
      System.out.println();
      
      System.out.println("Testing Search(), Should be true false false true true");
      System.out.println(n3.search(n3, n3.getValue()));//case where head has value
      System.out.println(n3.search(n3, 255));//case where it is not in the list
      System.out.println(n3.search(n2, n3.getValue()));// case where its behind list
      System.out.println(n3.search(n3, n1.getValue()));//case where is last in list
      System.out.println(n3.search(n3, n2.getValue()));// case where it not first or last in list
      System.out.println();
      
      System.out.println("Testing removeNodeAfterThis():");
      n3.removeNodeAfterThis();
      System.out.println(n3.toString());
      n3.removeNodeAfterThis();
      System.out.println(n3.toString());
      n3.removeNodeAfterThis();
      System.out.println(n3.toString());
      System.out.println("Added two more");
      n3.addNodeAfterThis(234);
      n3.addNodeAfterThis(675);
      System.out.println(n3.toString());
      n3.removeNodeAfterThis();
      System.out.println(n3.toString());
      n3.removeNodeAfterThis();
      System.out.println(n3.toString());
      n3.removeNodeAfterThis();
      System.out.println(n3.toString());
      System.out.println();
      
   }//end main
   
}//end IntNodeTest class