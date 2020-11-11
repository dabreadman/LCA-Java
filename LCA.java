 class TreeNode {
     int val;
     TreeNode[] child;
     
     TreeNode (int val, TreeNode[] child){
    	 this.val = val;
    	 this.child=child;
     }
 }

public class LCA
{ 
	// Retrieve answer without returning a structure in recursion
	private static TreeNode ans = null;

	public static int recurseTree(TreeNode currentNode, TreeNode node1, TreeNode node2) {

        // If reached the end of a branch, return false.
        if (currentNode == null) {
            return 0;
        }
        
        int matches=0;

        if(currentNode.child!=null) {
        	for(int i=0;i<currentNode.child.length;i++) {
        		matches += recurseTree(currentNode.child[i],node1,node2);
        	}
        }
        
        if(currentNode.val==node1.val||currentNode.val==node2.val) {
        	matches++;
        }
        // If this is the node
        if (matches==2) {
            ans = currentNode;
            matches=0;
        }

        return matches;
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
        // Traverse the tree
        recurseTree(root, node1, node2);
        return ans;
    }
    
    public static void main(String[] args) {
		TreeNode nine = new TreeNode(9,null);
		TreeNode eight = new TreeNode(8,null);
		TreeNode seven = new TreeNode(7,null);
		TreeNode six = new TreeNode(6,new TreeNode[] {eight});
		TreeNode five = new TreeNode(5,new TreeNode[] {eight});
		TreeNode four = new TreeNode(4,new TreeNode[] {five});
		TreeNode three = new TreeNode(3,new TreeNode[] {six,seven,nine});
		TreeNode two = new TreeNode(2,new TreeNode[] {three,four});
		TreeNode one = new TreeNode(1,new TreeNode[] {two});
		
		System.out.println(lowestCommonAncestor(one,eight,nine).val);
	}
}
	

	

