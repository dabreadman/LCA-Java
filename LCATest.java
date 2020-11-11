import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class LCATest {
	   
	/**
	 * Directed downwards
	 * e.g. 1->2, 5->8, 6->8
	 * 
	 *       1
	 *       |
	 *       2   
	 *   /      \
	 *  3        4
	 * | | |     |
	 * 9 7 6     5
	 *      \    /
	 *        8
	 */
	
	LCA LCA = new LCA();
	@Test
	void testLCA() {
		TreeNode nine = new TreeNode(9,null);
		TreeNode eight = new TreeNode(8,null);
		TreeNode seven = new TreeNode(7,null);
		TreeNode six = new TreeNode(6,new TreeNode[] {eight});
		TreeNode five = new TreeNode(5,new TreeNode[] {eight});
		TreeNode four = new TreeNode(4,new TreeNode[] {five});
		TreeNode three = new TreeNode(3,new TreeNode[] {six,seven,nine});
		TreeNode two = new TreeNode(2,new TreeNode[] {three,four});
		TreeNode one = new TreeNode(1,new TreeNode[] {two});
		
		// Test no node
		TreeNode imaginary = new TreeNode(-1,null);
	    assertEquals(null, LCA.lowestCommonAncestor(one,imaginary, six));
	    
		// Test available nodes
        assertEquals(three, LCA.lowestCommonAncestor(one,six,seven));
        assertEquals(two, LCA.lowestCommonAncestor(one,five, seven));
        assertEquals(three, LCA.lowestCommonAncestor(one,eight,nine));
        assertEquals(two, LCA.lowestCommonAncestor(one,six,five));
        
        // Test node of ancestor
        assertEquals(three, LCA.lowestCommonAncestor(one,three,six));
        assertEquals(four, LCA.lowestCommonAncestor(one,five,four));
        
	}

}