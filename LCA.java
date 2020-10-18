 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     
     TreeNode (int val, TreeNode left, TreeNode right){
    	 this.val = val;
    	 this.left=left;
    	 this.right=right;
     }
 }

public class LCA
{ 
	// Retrieve answer without returning a structure in recursion
	private static TreeNode ans = null;

	public static boolean recurseTree(TreeNode currentNode, TreeNode node1, TreeNode node2) {

        // If reached the end of a branch, return false.
        if (currentNode == null) {
            return false;
        }

        // Recurse on left child
        boolean left = recurseTree(currentNode.left, node1, node2);

        // Recurse on right child
        boolean right = recurseTree(currentNode.right, node1, node2);

        // If current matches either one
        boolean current = (currentNode == node1 || currentNode == node2);

        // If this is the node
        if (left&&right||left&&current||right&&current) {
            ans = currentNode;
        }

        return (left||current||right);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
        // Traverse the tree
        recurseTree(root, node1, node2);
        return ans;
    }
    
    public static void main(String[] args) {
		TreeNode three = new TreeNode(3,null,null);
		TreeNode two = new TreeNode(2,three,null);
		TreeNode four = new TreeNode(4,null,null);
		TreeNode six = new TreeNode(6,null,null);
		TreeNode five = new TreeNode(5,four,six);
		TreeNode root = new TreeNode(1,two,five);
		
		System.out.println(lowestCommonAncestor(five,three, six));
	}
}
	

	

