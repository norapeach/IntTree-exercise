import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

/**
 * 
 */

/**
 * @author Nora P.
 * @version 6/15/20
 */
class JTestIntTree {


	@Test
	void testEmptyTree() {
		IntTree empty = new IntTree(); // empty IntTree (1 empty branch e.g. overallRoot)
		int count = empty.countEmpty();
		int expected = 1;
		assertEquals(expected, count);
	}
	/**
	 * @see https://www.codejava.net/testing/junit-test-exception-examples-how-to-assert-an-exception-is-thrown
	 */
	@Test
	void testBuildIntTreeNegativeMaxException() {
		assertThrows(IllegalArgumentException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				IntTree neg = new IntTree(-4);
			}
			
		});
	}
	
	
	@Test
	void testSequencialTree() {
		IntTree sequence = new IntTree(12);
		int count = sequence.countEmpty();
		int expected = 13;
		assertEquals(expected, count);
	}
	
	@Test
	void testIntSearchTree() {
		IntTree sorted = new IntTree();
		int[] treeVals = {3, 1, 2, 4, 6, 5};
		for (int val : treeVals) {
	    	 sorted.add(val);
	     }
		int count = sorted.countEmpty();
		assertTrue(sorted.size() == 6);
		assertTrue(count == 7);
	}
	

}
