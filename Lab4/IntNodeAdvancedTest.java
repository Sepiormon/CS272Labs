
public class IntNodeAdvancedTest {

    public static void main(String[] args) {
	
	
	IntNode ichi = new IntNode(21, null);
	IntNode ni = new IntNode(16, ichi);
	IntNode san = new IntNode(44, ni);
	IntNode shi = new IntNode (31, san);
	
	IntNode newHead = new IntNode(0, null);
	for(int i = 0; i < 10; i = i + 2) {
	    IntNode I = newHead;
	    for(int j = i; j > 0; j = j - 2) {
		I = I.getLink();
	    }//end for
	    I.addNodeAfterThis(i + 2);
	}//end for to generate no odds
	
	System.out.println("Odd List: " + newHead);
	System.out.println();
	
	System.out.println("Testing listEvenNumber(), Should be: 2, 2, 1, 0");
	System.out.printf("Results: %d, %d, %d, and %d.\n\n", IntNode.listEvenNumber(shi), IntNode.listEvenNumber(san), IntNode.listEvenNumber(ni), IntNode.listEvenNumber(ichi));
	
	System.out.println("Testing addToEnd()");
	System.out.println("Before addToEnd(2) ( from end ):");
	System.out.println(shi);
	ichi.addToEnd(2);
	System.out.println("after: \n" + shi + "\n");
	
	System.out.println("Before addToEnd(4) (from head):");
	System.out.println(shi);
	shi.addToEnd(4);
	System.out.println("after: \n" + shi + "\n");
	
	System.out.println("Before addToEnd(5) ( from middle ):");
	System.out.println(shi);
	ichi.addToEnd(5);
	System.out.println("after: \n" + shi + "\n");
	

	System.out.println("Testing sumLast()");
	System.out.println("Nodes: " + shi);
	
	System.out.println("sumLast(31,0) should be 31.");
	System.out.println(IntNode.sumLast(shi, 0));
	System.out.println();
	
	System.out.println("sumLast(31, 1) (31 + 44 = 75):");
	System.out.println(IntNode.sumLast(shi, 1));
	System.out.println();
	
	System.out.println("sumLast(31, 10000) should add all values:");
	System.out.println(IntNode.sumLast(shi, 10000));
	System.out.println();
	
	System.out.println("Testing CopyOdd() on:\n" + shi);
	System.out.println("Case: Head odd");
	System.out.println(IntNode.copyOdd(shi));
	System.out.println();
	
	System.out.println("Testing CopyOdd() on:\n" + shi);
	System.out.println("Case: Head even");
	System.out.println(IntNode.copyOdd(san));
	System.out.println();
	
	System.out.println("Testing CopyOdd() on:\n" + shi);
	System.out.println("Case: no odd");
	System.out.println(IntNode.copyOdd(newHead));
	System.out.println();
	
	System.out.println("Testing CopyOdd() on:\n" + shi);
	System.out.println("Case: all odd");
	System.out.println(IntNode.copyOdd(IntNode.copyOdd(shi)));
	
	
	//TODO test Reverse()
	IntNode Jeff = new IntNode(2, null);
	IntNode Sam = new IntNode(40, Jeff);
	IntNode Alec = new IntNode(25, Sam);
	IntNode Eaof = new IntNode(72, Alec);
	IntNode Max = new IntNode(49, Eaof);
	System.out.println("Before Reverse()");
	System.out.println(Max);
	System.out.println("After Reverse");
	IntNode.reverse(Max);
	System.out.println(Jeff);
	System.out.println("Reversing Again (should be original)");
	IntNode.reverse(Jeff);
	System.out.println(Max);
	System.out.println();
	
	//test RemoveAll
	//none are value
	System.out.println("Testing Remove all");
	System.out.println("Case: None Are value (no change) (0)");
	System.out.println("Before:");
	System.out.println(Max);
	IntNode.removeAll(Max, 0);
	System.out.println("After:");
	System.out.println(Max);
	
	//one is value
	System.out.println();
	System.out.println("Case: One Value is Removed (25)");
	System.out.println("Before:");
	System.out.println(Max);
	IntNode.removeAll(Max, 25);
	System.out.println("After:");
	System.out.println(Max);
	
	//two in a row are value
	IntNode Jax = new IntNode(12, null);
	IntNode Irelia = new IntNode(16, Jax);
	IntNode Riven = new IntNode(16, Irelia);
	IntNode Kayne = new IntNode(14, Riven);
	System.out.println();
	System.out.println("Case: Two Values in a Row Removed (16)");
	System.out.println("Before:");
	System.out.println(Kayne);
	IntNode.removeAll(Kayne, 16);
	System.out.println("After:");
	System.out.println(Kayne);
	

	
	
	//last is value
	Jax = new IntNode(12, null);
	Irelia = new IntNode(16, Jax);
	Riven = new IntNode(13, Irelia);
	Kayne = new IntNode(14, Riven);
	System.out.println();
	System.out.println("Case: Last Value was Removed (12)");
	System.out.println("Before:");
	System.out.println(Kayne);
	IntNode.removeAll(Kayne, 12);
	System.out.println("After:");
	System.out.println(Kayne);
	
	//last is value
	Jax = new IntNode(12, null);
	Irelia = new IntNode(42, Jax);
	Riven = new IntNode(42, Irelia);
	Kayne = new IntNode(42, Riven);
	System.out.println();
	System.out.println("Case: Random Test Case (42)");
	System.out.println("Before:");
	System.out.println(Kayne);
	System.out.println("After: " + IntNode.removeAll(Kayne, 42));
	
	//all are value
	Jax = new IntNode(77, null);
	Irelia = new IntNode(77, Jax);
	Riven = new IntNode(77, Irelia);
	Kayne = new IntNode(77, Riven);
	System.out.println();
	System.out.println("Case: All are removed (77)");
	System.out.println("Before:");
	System.out.println(Kayne);
	System.out.println("After: " + IntNode.removeAll(Kayne, 77));
	
	
	//TODO test cylcical()
	System.out.println();
	Jax = new IntNode(11, null);
	Irelia = new IntNode(22, Jax);
	Riven = new IntNode(33, Irelia);
	Kayne = new IntNode(44, Riven);
	Jax.setLink(Kayne);
	System.out.println("Testing hasCycle(), should be true");
	if(IntNode.hasCycle(Jax)) {
	    System.out.println("Has cylce");
	} else {// end if
	    System.out.println("Has no cylce");
    	}//end else	
	
	
	System.out.println();
	Jax = new IntNode(7, null);
	Irelia = new IntNode(6, Jax);
	Riven = new IntNode(5, Irelia);
	Kayne = new IntNode(4, Riven);
	
	IntNode Aatrox = new IntNode(3, Jax);
	IntNode Kennen = new IntNode(2, Aatrox);
	IntNode OldIrelia = new IntNode(1, Kennen);
	Jax.setLink(OldIrelia);
	System.out.println("Testing hasCycle() on a P loop, should be true");
	if(IntNode.hasCycle(OldIrelia)) {
	    System.out.println("Has cylce");
	} else {// end if
	    System.out.println("Has no cylce");
    	}//end else	
	
	
	System.out.println();
	Jax = new IntNode(11, null);
	Irelia = new IntNode(22, Jax);
	Riven = new IntNode(33, Irelia);
	Kayne = new IntNode(44, Riven);
	Aatrox = new IntNode(666, Jax);
	Kennen = new IntNode(45, Aatrox);
	OldIrelia = new IntNode(404, Kennen);
	System.out.println("Testing hasCycle(), should be False");
	if(IntNode.hasCycle(OldIrelia)) {
	    System.out.println("Has cylce");
	} else {// end if
	    System.out.println("Has no cylce");
    	}//end else	
	
	
	
	
	
	
    }//end main

}//end IntNodeAdvancedTest
