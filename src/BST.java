

public class BST<T extends Comparable<? super T>> 
{

	class BinaryNode 
	{	
		T element; // the data in the node
		BinaryNode left; // pointer to the left child
		BinaryNode right; // pointer to the right child
		
		// Initialize a childless binary node.
		// Pre: elem is not null
		// Post: (in the new node)
		// element == elem
		// left == right == null
		
		public BinaryNode( T elem ) 
		{
			if(elem != null){
				element = elem;
				left = null;
				right = null;
			}
			
		}
		
		// Initialize a binary node with children.
		// Pre: elem is not null
		// Post: (in the new node)
		// element == elem
		// left == lt, right == rt
		public BinaryNode( T elem, BinaryNode lt, BinaryNode rt ) 
		{	
			if(elem != null){
				element = elem;
				left = null;
				right = null;
			}
		}
		
	}
	private boolean duplicate = false;
	BinaryNode root; // pointer to root node, if present
	BinaryNode pool; // pointer to first node in the pool
	int pSize; // size limit for node pool
	
	
	// Initialize empty BST with no node pool. 
	 // Pre: none 
	 // Post: (in the new tree) 
	 // root == null, pool == null, pSize = 0 
	 public BST( ) 
	 { 	 
		 root = null;
		 pool = null;
		 pSize = 0;
	 } 
	 
	 // Initialize empty BST with a node pool of up to pSize nodes. 
	 // Pre: none 
	 // Post: (in the new tree) 
	 // root == null, pool = null, pSize == Sz 
	 public BST( int Sz ) 
	 { 
		 root = null;
		 pool = null;
		 pSize = Sz;
	 } 
	 
	 // Return true iff BST contains no nodes. 
	 // Pre: none 
	 // Post: the binary tree is unchanged 
	 public boolean isEmpty( ) 
	 { 
		 if (root == null)
		 {
			 return true;
		 }
		 else
		 {
			 return false;
		 }
	 }
	 
	 // Return pointer to matching data element, or null if no matching 
	 // element exists in the BST. "Matching" should be tested using the 
	 // data object's compareTo() method. 
	 // Pre: x is null or points to a valid object of type T 
	 // Post: the binary tree is unchanged 
	 public T find( T x ) 
	 { 
		 BinaryNode foundNode = findRecursive(root, x);
		 if ( foundNode != null)
			 return foundNode.element;
		 else
			 return null;
	 } 
	 
	 private BinaryNode findRecursive(BinaryNode myNode, T x)
	 {
		 if ( myNode.element.compareTo(x) == 0)
			 return myNode;
		 
		 if ( myNode.element.compareTo(x) < 0)
		 {
			 if ( myNode.left != null)
			 {
				 return findRecursive( myNode.left, x);
			 }
			 else
			 {
				 return null;
			 }
		 }
		 
		 if ( myNode.element.compareTo(x) > 0)
		 {
			 if ( myNode.right != null)
			 {
				 return findRecursive( myNode.right, x);
			 }
			 else
			 {
				 return null;
			 }
		 }
		return myNode;
	 }
	 
	 // Insert element x into BST, unless it is already stored. Return true 
	 // if insertion is performed and false otherwise. 
	 // Pre: x is null or points to a valid object of type T 
	 // Post: the binary tree contains x 
	 public boolean insert( T x ) 
	 { 
		 root = insertRecursive(root, x);
		 if ( !duplicate )
			 return true;
		 else
			 return false;
	 } 
	 
	 private BinaryNode insertRecursive(BinaryNode myNode, T x)
	 {
		 BinaryNode nodeInsert = getNode(pool);
		 
		 nodeInsert = new BinaryNode(x, null, null);
		 
		 if(myNode == null){
			 return nodeInsert;
		 }
		 
		 int res = x.compareTo(myNode.element);
		 
		 if(res > 0){
			 myNode.right = insertRecursive(myNode.right, x);
		 }
		 else if(res < 0){
			 myNode.left = insertRecursive(myNode.left, x);
		 }
		 else{
			 duplicate = true;
		 }
		 
		 return myNode;
		 
	 }
	 
	 public BinaryNode getNode(BinaryNode pool){
		 BinaryNode aNode;
		 if(pool == null){
			 return null;
		 }
		 
		 if(pool.right != null){
			 pool.right = getNode(pool.right);
		 }
		 
		 aNode = pool;
		 pool = null;
		 return aNode;
		 
	 }
	 
	 // Delete element matching x from the BST, if present. Return true if 
	 // matching element is removed from the tree and false otherwise. 
	 // Pre: x is null or points to a valid object of type T 
	 // Post: the binary tree does not contain x 
	 public boolean remove( T x ) 
	 {
		T elem = find(x);
		
		if(elem == null || root == null){
			return false;
		}
		
		root = removeRecursive(root, x);
		 return true;
	 } 
	 
	 public BinaryNode removeRecursive(BinaryNode node, T x){
		 
		 BinaryNode removeNode = node;
		 
		 int res = x.compareTo(node.element);
		 
		 if(res < 0){
			 node.left = removeRecursive(node.left, x);
		 }
    	 else if(res > 0){
			 node.right = removeRecursive(node.right, x);
		 }else{
			 if(node.right == null && node.left == null){
				 removeNode = null;
			 }
			 else if(node.right != null && node.left != null){
				 
				 BinaryNode right = minimum(node.right);
				 right.right = removeRecursive(node.right, right.element);
				 right.left = node.left;
				 removeNode = right;
				 
			 }else if(node.left != null){
				 removeNode = node.left;
			 }else if(node.right != null){
				 removeNode = node.right;
			 }
		 }
		 	return removeNode;
	 }

	 public BinaryNode minimum(BinaryNode node){
		 if(node != null){
			 if(node.left == null){
				 return node;
			 }
			 return minimum(node.left);
		 }
		 return null;
	 }
	 
	 // Delete the subtree, if any, whose root contains an element matching x. 
	 // Pre: x is null or points to a valid object of type T 
	 // Post: if the tree contained x, then it the subtree rooted at that 
	 // node has been removed 
	 public boolean prune(T x) 
	 { 
		 BinaryNode foundNode = findRecursive(root, x);
		 if ( foundNode == null)
			 return false;
		 else
		 {
			 if ( foundNode.left != null )
				 clearRecursive(foundNode.left);
			 if ( foundNode.right != null )
				 clearRecursive(foundNode.right);
			 
			 return true;
		 }
	 } 
	 
	 // Return the tree to an empty state. 
	 // Pre: none 
	 // Post: the binary tree contains no elements 
	 public void clear( ) 
	 { 
		 clearRecursive(root);
	 }
	 
	 public void clearRecursive(BinaryNode myNode)
	 {
		 if ( myNode.left != null )
		 {
			 //first delete all the left children, whether they exist or not
			 clearRecursive(myNode.left);
		 }
		 
		 if ( myNode.right != null )
		 {
			 //then delete all the right children, whether they exist or not
			 clearRecursive(myNode.right);
		 }
		 
		 if ( myNode.left == null && myNode.right == null)
		 {
			 //eventually, all nodes, once their left and right children are deleted, will enter THIS condition
			 //delete myNode; then delete the node itself, now that it has NO children.
			 root = null;
		 }
	 }
	 
	 
	// Return number of levels in the tree. 
	 // Pre: tree is a valid BST<> object 
	 // Post: the binary tree is unchanged 
	 public int height() 
	 { 		 
	    return heightRecursive(root);
	 }
	 
	 public int heightRecursive(BinaryNode myNode)
	 {
		 if ( myNode == null )
			 return 0;
			 
		 int leftHeight = 0;
		 int rightHeight = 0;
		 
		 if(myNode.left != null)
		 {
			 leftHeight = heightRecursive(myNode.left);
		 }
		 
		 if(myNode.right != null)
		 {
			 rightHeight = heightRecursive(myNode.right);

		 }
		 
		 if ( leftHeight > rightHeight )
			 return 1 + leftHeight;
		 else
			 return 1 + rightHeight;
	 }
	 
} 

