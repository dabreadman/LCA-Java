import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class LCATest {
	   
	/**
	 *     1
	 *    / \
	 *   2   5
	 *  /   / \
	 * 3   4   6
	 */
	
	LCA LCA = new LCA();
	@Test
	void testLCA() {
		TreeNode three = new TreeNode(3,null,null);
		TreeNode two = new TreeNode(2,three,null);
		TreeNode four = new TreeNode(4,null,null);
		TreeNode six = new TreeNode(6,null,null);
		TreeNode five = new TreeNode(5,four,six);
		TreeNode root = new TreeNode(1,two,five);
		
		// Test no node
		assertEquals("test",null, LCA.lowestCommonAncestor(five,three, six));
		TreeNode imaginary = new TreeNode(-1,null,null);
	    assertEquals(null, LCA.lowestCommonAncestor(root,imaginary, six));
	    
		// Test available nodes
        assertEquals(root, LCA.lowestCommonAncestor(root,three, six));
        assertEquals(five, LCA.lowestCommonAncestor(root,four, six));
        
        // Test node of ancestor
        assertEquals(root, LCA.lowestCommonAncestor(root,root, six));
        assertEquals(five, LCA.lowestCommonAncestor(root,five, six));
        
	}

}