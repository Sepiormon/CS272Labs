/**
* @author Alexander Morgan
* 
*/

public class StringSet{
   
   private int capacity;
   private String[] strings;
   
   public StringSet(){
      capacity = 2;
      strings = new String[2];      
   }//end contructor1
   
   
/**
* @param _capacity how many slots will be in the StringSet.
* @precondition - Capacity must be Positive.
*/
   public StringSet(int _capacity){
   
      if(_capacity <= 0){
         return;
      }//end if
      
      capacity = _capacity;
      strings = new String[_capacity];
   }//end contructor2
   
   /**
   * @param obj The object being cloned.
   * @precondition - Object is a StringSet.
   */
   public StringSet(Object obj){
      
      if(obj == null || !(obj instanceof StringSet)){
         return;
      }// end if
      
      StringSet copier = (StringSet) obj;
      String[] copyStrings = copier.getSet();
      
      capacity = copier.capacity();
      strings = new String[capacity];
      
      //copy the strings into new object
      for(int i = 0; i < copyStrings.length; i++) {
         strings[i] = copyStrings[i];
      }//end for
      
   }//end contructor3
   
   
   /**
   * @return the current capacity of the StringSet.
   */
   public int capacity(){
      return capacity;
   }//end capacity
   
   /**
   * @return All of the Strings in the set.
   */
   
   public String[] getSet(){ //only returns non-null portion of StringSet
       
      String[] output = new String[size()];
      int offset = 0;
      
      	for(int i = 0; i < size(); i++) {
      	    
      	    if(strings[i] != null) {
      		output[i - offset] = strings[i];
      	    } else {
      		offset++;
      	    }//end if else
      	    
      	}//end for
      
      return output;
      
   }// end getSet
   
   
   /**
   * @return How many Strings are in the Set
   */
   public int size(){
      int numString = 0;
      
      for(int i = 0; i < capacity; i++){
         //loop through strings, incremeant until null
         if(strings[i] != "" && strings[i] != null){
            numString++;
         } else {
            return numString;
         }
         
      }//end for
      return numString;
   }// end size
   
   /**
    * 
    * @param a The String being added to the set
    * @precondition a is not null or empty.
    */
   
   public void add(String a){
      
      if(a == null || a == ""){
         return;
      }//end if
      
      if(!contains(a)) { //if StringSet doesn't contain a, add it to StringSet
	  ensureCapacity(size() + 1);
      	  strings[size()] = a;
      }//end if	
      
   }//end add
   
   /**
    * 
    * @param a the string to check if this StringSet contains.
    * @return True if String a is part of the set, else false.
    */
   
   public boolean contains(String a) {
       
       for(int i = 0; i < size(); i++) {
	   if(strings[i].equals(a)) {
	       return true;
	   }//end if
       }//end for
       
       return false;
   }// end contains
   
   private void ensureCapacity(int minimumCapacity){
      
      if(capacity < minimumCapacity){
         
         String[] newArray = new String[capacity * 2];
         
         for(int i = 0; i < size(); i++) {
            newArray[i] = strings[i];
         }//end for
         
         strings = new String[capacity * 2];
         capacity = capacity * 2;
         
         for(int i = 0; i < capacity; i++) {
            strings[i] = newArray[i];
         }//end for
         
      }//end if
      
   }//end ensureCapacity
   
   /**
    * 
    * @param a the string to remove from StringSet
    * @return true if a removed, false if StringSet does not contain a
    */
   
   public boolean remove(String a) {
       
       if(contains(a)) { //if contains string a

	   for(int i = 0; i < size(); i++) {
	       if(strings[i] == a) { //if a is strings[i]
		   strings[i] = null; //remove a
		   	for(int j = i; j + 1 < capacity; j++) {// removes potential space between letters
		   	    strings[j] = strings[j + 1];
		   	}// end j for
		   return true;
	       }//end if
	   }// end for
       } else {// end if
	   //debug 
	   System.out.println("Not contained");
       }
       return false;
   }// end remove
   
   
   /**
    * @note This function is for Debugging.
    */
   public void printSet() {//basically toString(), but prints it out automatically
       
       String output = "";
       
       for(int i = 0; i < capacity; i++) {
	   if(strings[i] != null && strings[i] != "") {
	       output += "\"" + strings[i] + "\", ";
	   }// end if
       }//end for
       
       output += "Size: " + size();
       
       output += ", Capacity: " + capacity;
       
       System.out.println(output);
       
   }//end printSet
   
   /**
   * @param a String being added.
   * @precondition a is not null or an empty String
   */
   
   public void addOrdered(String a) {
       
       if(a == null || a == "") {
	   return;
       }
       
       int size = size();
       
       if(size() + 1 > capacity) {
	   ensureCapacity((capacity + 1) * 2);
       }
       
       strings[size()] = a;
       size++;
       
       boolean swap = false; //if true, swap [i] with [j]
       boolean decided = false;
       
       String temp = "";
       
       for(int i = 0; i < size; i++) { //spot looking to set next highest
	   
	   for(int j = i + 1; j < size; j++) { //comparing [j] to [i] spot
	       swap = false;
	       decided = false;
	       
	       for(int k = 0; k < strings[i].length() && k < strings[j].length(); k++) {//compares letter by letter until one is greater.
		   
		   if((int) strings[i].charAt(k) == (int) strings[j].charAt(k) && !decided) {// if same character
		       if(!decided) {//if its decided to swap or not
			   
			   if(k == strings[i].length() - 1) {//check if last character
			       decided = true;
			       break;
			       
		       	    }// end if

			   if(k == strings[j].length() - 1) {//check if last character
			       decided = true;
			       swap = true;
			       break;
			       
			   }// end if
			   
		       	} //end !decided if 
		       
		   } else if((int) strings[i].charAt(k) < (int)strings[j].charAt(k) && !decided) { //if i comes before j
		       	    
		       decided = true;
		       	    
		   } else if(!decided){// if j comes before i
		       
		       decided = true;
		       swap = true;
		       	    
		   } // end else if
		   
	       }// end k for
	       
	       if(swap) {
		   
		   temp = strings[i];
		   strings[i] = strings[j];
		   strings[j] = temp;
		   j = i + i;
		   
	       }// end if
	       
	   }// end j for
	   
       }// end i for
       
   }// end add ordered
   
   public static void main(String[] args){
      
      StringSet firstSet = new StringSet();//testing first contructor
      StringSet secondSet = new StringSet();//testing second contructor
      
      System.out.println("Base constructor, should have 0 size and 2 capacity");
      firstSet.printSet(); //testing size, should be 0 and capacity 2
      System.out.println();
      
      System.out.println("Testing Add function.");
      firstSet.add("orewa");
      firstSet.printSet();
      System.out.println();
      
      System.out.println("Testing copy constructor:");
      secondSet = new StringSet(firstSet);
      secondSet.printSet();
      System.out.println();
      
      System.out.println("Testing add() and checking clone for changes (it shouldn't have any):");
      firstSet.add("ohaiyo");
      System.out.println("First Set:");
      firstSet.printSet();
      System.out.println("Second (cloned) set:");
      secondSet.printSet();
      System.out.println();

      System.out.println("Testing EnsureCapacity(), should double capcity to 4");
      firstSet.add("ookiitsuteringu");
      firstSet.printSet();
      System.out.println();
      
      
      System.out.println("Testing addOrdered(), should order the string");
      firstSet.addOrdered("akunamatata");
      firstSet.printSet();
      System.out.println();
      
      System.out.println("A more thurough test of addOrdered():");
      StringSet thirdSet = new StringSet();
      thirdSet.add("a");
      thirdSet.add("d");
      thirdSet.add("c");
      thirdSet.add("e");
      thirdSet.add("g");
      thirdSet.add("h");
      thirdSet.add("f");
      thirdSet.add("q");
      thirdSet.add("b");
      thirdSet.add("n");
      thirdSet.addOrdered("u");
      thirdSet.printSet();
      System.out.println();
      
      System.out.println("Attempting to add duplicate string to first string (another 'orewa')");
      System.out.println("Before:");
      firstSet.printSet();
      firstSet.add("orewa");
      System.out.println("After (should be same):");
      firstSet.printSet();
      System.out.println();
      
      System.out.println("Checking addOrded() ensurecapacity increase (should be 8):");
      firstSet.add("oaiwawatashino");
      firstSet.printSet();
      System.out.println();
      
      System.out.println("Testing contains()");
      if(thirdSet.contains("a")) {
	  System.out.println("It is contained (not error)");
      } else {
	  System.out.println("It is not contained (error)");
      }// end if
      
      if(thirdSet.contains("e")) {
	  System.out.println("It is contained (not error)");
      } else {
	  System.out.println("It is not contained (error)");
      }// end if
      
      if(thirdSet.contains("z")) {
	  System.out.println("It is contained (error)");
      } else {
	  System.out.println("It is not contained (not error)");
      }// end if
      System.out.println();
      
      System.out.println("Testing Remove(): should be true, true, false, false");
      
      System.out.println(thirdSet.remove("a"));
      thirdSet.printSet();
      
      System.out.println(thirdSet.remove("c"));
      thirdSet.printSet();

      System.out.println(thirdSet.remove("c"));
      thirdSet.printSet();

      System.out.println(thirdSet.remove("D"));
      thirdSet.printSet();
      
   }//end main
   
}// end class