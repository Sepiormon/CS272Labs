/**
* @author Alexander Morgan
* @date 02/05/2019
*
*/

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
      
      int nodes = 0;
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
      
      IntNode current = head;
      
      while(current != null){
         if(current.getValue() == data){
            return true;
         }
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
   
}//end IntNode class