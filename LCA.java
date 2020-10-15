 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
 }

public class LCA
{ 
	// Retrieve answer without returning a structure in recursion
	private TreeNode ans;

	private boolean recurseTree(TreeNode currentNode, TreeNode node1, TreeNode node2) {

        // If reached the end of a branch, return false.
        if (currentNode == null) {
            return false;
        }

        // Recurse on left child
        boolean left = this.recurseTree(currentNode.left, node1, node2);

        // Recurse on right child
        boolean right = this.recurseTree(currentNode.right, node1, node2);

        // If current matches either one
        boolean current = (currentNode == node1 || currentNode == node2);

        // If this is the node
        if (left&&right||left&&current||right&&current) {
            this.ans = currentNode;
        }

        return (left||current||right);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
        // Traverse the tree
        this.recurseTree(root, node1, node2);
        return this.ans;
    }
}
	

	

