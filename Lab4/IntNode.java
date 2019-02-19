/**
* @author Alexander Morgan
* @date 02/05/2019
*
*/
//https://www.cs.nmsu.edu/~hcao/teaching/cs272/lab/lab4_list2.html
public class IntNode{
   
   private int val; //for storing value
   private IntNode link;
 
   public IntNode(){
   
      val = 0;
      link = null;
   
   }//end default constructor

   /**
    * @precondition _data is not null.
    * @param _data Integer to be stored in node.
    * @param _node The next node in Chain. Null if this node is the end.
    */
   
   public IntNode(int _data, IntNode _node){
      
      val = _data;
      link = _node;
      
   }//end Constructor
   
   /**
    * @return The integer stored in the node.
    */
   
   public int getValue(){
      return val;
   }//end setValue
   
   /**
    * @param _data Sets the value stored in the node.
    */
   
   public void setValue(int _data){
      val = _data;
   }//end setValue
   
   /**
    * @param _node The next node in the chain.
    */
   
   public void setLink(IntNode _node){
      link = _node;
   }//end setLink
   
   /**
    * @return The next node in the chain.
    */
   
   public IntNode getLink(){
      return link;
   }// end getLink
   
   /**
    * @param head The starting node in the chain.
    * @return How many linked nodes there are after the head.
    */
   
   public static int listLength(IntNode head){
      
       if(head == null) {
	   return 0;
       }
       
      int nodes = 1;
      IntNode current = head;
      
      while(current.getLink() != null){
         current = current.getLink();
         nodes++;
      }//end while
      
      return nodes;
      
   }//end listLength
   
   /**
    * @note Prints out the value of current node and all nodes after.
    */
   
   public String toString(){
      
      String output = "";
      IntNode current = getLink();
      
      output += Integer.toString(getValue());
      
      while(current != null){
         output += "->";
         output += Integer.toString(current.getValue());
         current = current.getLink();
      }// end while
      
      return output;
      
   }// end toString
   
   /**
    * @param newdata The data to be stored in the new node.
    */
   public void addNodeAfterThis(int newdata){
      
      //make new node point to current node's link
      //creates new node
      IntNode newNode = new IntNode(newdata, this.getLink());
      
      //make current node point to it
      this.setLink(newNode);
      
   }//end addNodeAfterThis
   
   /**
    * @note Searches the linked list, starting from the head until the end of the linked list.
    * @param head The node start at.
    * @param data The data being searched for
    * @return True if data is contained in list, false if it is not.
    */
   public static boolean search(IntNode head, int data){
       
       if(head == null) {
	   return false;
       }//end if
      
      IntNode current = head;
      
      while(current != null){
         if(current.getValue() == data){
            return true;
         }//end while
         current = current.getLink();
      }//end while
      
      return false;
   }//end search
   
   /**
    * @note This function removes the node by relinking this node to the node the next node is linked to.
    */
   
   public void removeNodeAfterThis(){
      
      IntNode nextNode = this.getLink();
      if(nextNode == null){ //incase node is last anyway
         return;
      }//end if
      
      nextNode = nextNode.getLink();
      this.setLink(nextNode);
      
      //this.setLink() = nextNode;
      
   }//end removeNodeAfterThis
   
   /**
    * @param head The starting node of the list
    * @return How many even numbers are in the list
    */
   public static int listEvenNumber(IntNode head) {
       
       if(head == null) { //precondition
	   return 0;
       }//end if
       
       int count = 0; //storeage
       
       while(head != null) { //while node isn't null
	   
	   if(head.getValue() % 2 == 0) { //see if its even
	       count++; //if so increment count
	   }//end if
	   
	   head = head.getLink(); //set head to next node
	   
       }//end while
       
       return count;
   }//end listEvenNumber
   
   /**
    * @param newdata The value the new last node will have.
    */
   
   public void addToEnd(int newdata) {
       
       IntNode node = getLink(); //next node
       
       if(node == null) { //if it's null
	   addNodeAfterThis(newdata); //just made a node after this one
	   return;
       }// end if
       
       while(node.getLink() != null) { //loop until node's link is null
	   
	   node = node.getLink();
	   
       }//end while
       
       node.addNodeAfterThis(newdata); //then add next node
       
   }//end addToEnd
   
   /**
    * @param head The starting node
    * @param num how many nodes after head to add
    * @return summation of nodes from head to num after head.
    * @precondition head can't be null, and num cannot be negitive. 
    */
   
   public static int sumLast(IntNode head, int num) {
       
       int sum = head.getValue(); //starting value
       
       if(head == null || num < 0) { //precondition. 
	   return sum; //if not met, return node's value
       }//end if
       
       while(num != 0 && head.getLink() != null) {
	   //while num isnt 0 and there is a next node
	   
	   head = head.getLink(); //make head into it's link
	   
	   sum += head.getValue(); //add link's value to sum
	   
	   num--; //decrement num
       }//end while
       
       return sum;
   }//end sumLast
   
   /**
    * @param head The starting node to copy from
    * @return New head of new linked list of the copied odd numbers. Null if there are no odd numbers in list or head is null.
    * @note This function creates a new linked list, but only returns the head. It does not just copy a single node.
    */
   public static IntNode copyOdd (IntNode head) {
       
       if(head == null) {
	   return null;
       }//end if
       
       IntNode newHead = null;
       
       while(newHead == null && head != null) { //select first odd element to be new head
	   
	   if(head.getValue() % 2 == 1) {
	       
	       newHead = new IntNode(head.getValue(), null);//assign as new head
	       
	   }// end if
	   
	   head = head.getLink();//increment nodes
	   
       }//end while
       
       if(newHead == null) {
	   return null; //case where no odds are found
       }//end if
       
       while(head != null) {
	   //while there are still more nodes
	   if(head.getValue() % 2 == 1) {
	       newHead.addToEnd(head.getValue());// will add all odds to end, in order.
	   }//end if
	   
	   head = head.getLink();
	   
       }// end while
       
       return newHead;
       
   }//end copyOdd
   
   public static IntNode reverse (IntNode head) {
   
       if(head == null) { //no list
	   return null;
       } else if(head.getLink() == null) {
	   return head; //if head only element
       } //end if else
       
       
       IntNode currlast = head.getLink().getLink();
       IntNode beforeLast = head.getLink();
       
       head.setLink(null);
       
       while(currlast != null) {
	   
	   beforeLast.setLink(head);
	   head = beforeLast;
	   beforeLast = currlast;
	   currlast = currlast.getLink();
	   
       }//end while
       
       beforeLast.setLink(head);
       
       return currlast;
   }//end reverse
   
   /**
    * @param head The head of the Linked List to be tested
    * @return True - If has a cycle, else False
    */
   
   public static boolean hasCycle(IntNode head) {
       
       IntNode turtle = head;
       IntNode hare = turtle.getLink();
       
       while(hare != null && hare.getLink() != null) {
	   
	   if(hare == turtle) {
	       return true;
	   } //end if
	   System.out.println("ewqeqw");
	   hare = hare.getLink().getLink();
	   turtle = turtle.getLink();
	   
	   System.out.printf("Turtle: %d, Hare: %d\n", turtle.getValue(), hare.getValue());
	   
       }// end while
       
       // This method works, because if there is a loop,
       // eventually, both the hare and turtle will get inside it
       // The hare will jump 2 nodes per loop and the turtle will only jump one
       // Mathmatically speaking, it will always take 
       // X Steps once turtle enters loop, 
       // where X = K - Y
       // where Y is how many steps away Turtle is away from Hare
       // where K is the length of the loop
       // if there is no loop, hare can never reach turtle
       // if there is a loop, turtle and hare will meet in X steps once both are in loop
       // (i did this on paper so it might not be what you're looking for)
       
       return false;
       
   }//end hasCycle
   
   

   /**
    * @param head The head of the Linked list
    * @param e The value to be removed
    * @return The head of the linked list after removals.
    */
   public static IntNode removeAll(IntNode head, int e) {
       
       if(head == null) {
	   return null;
       }// end if
       
       while( head.getValue() == e ) { //finding first non-e node
	   
	   if(head.getLink() == null) {
	       return null;
	   }
	   
	   head = head.getLink();
	   
       }// end while
       
       IntNode next = head;
       
       while(next != null) {
	   
	   if(next.getLink() != null) { //make sure next link exists
	       
	       if(next.getLink().getValue() == e) { //if its value is e
		  next.setLink(next.getLink().getLink()); //remove
	   	} else { // do NOT increment if next node was changed
	   	    next = next.getLink(); //keep going
	   	}//end else if
	   	
	   } else {
	       
	       break; //exit loop
	       
	   }// end if else
	   
       }//end while
       
       return head;
       
   }//end removeAll
   
   
   
   
   
   
   
   
   
}//end IntNode class