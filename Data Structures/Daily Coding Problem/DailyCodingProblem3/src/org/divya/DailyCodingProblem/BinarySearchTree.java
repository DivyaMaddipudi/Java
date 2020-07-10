package org.divya.DailyCodingProblem;

import java.io.*;

public class BinarySearchTree {
	
	 static Node root;
	
	 @SuppressWarnings("resource")
	void serialize(Node node, String path) throws IOException { 
		
		 FileWriter writer = new FileWriter(path, true);
		 BufferedWriter   fw = new BufferedWriter(writer);

		 
		 if (node == null) {
			fw.write("-1");
		 	return;
		 }
	    // Else, store current node and recur for its children 
		 else {
			fw.write(String.valueOf(node.key)+ " ");
		    serialize(node.left, path); 
		    
		    serialize(node.right, path); 
		    
		 }
		 fw.close();
	} 


	void printInorder(Node node) 
	{ 
		if (node == null) 
			return; 
		
		printInorder(node.left); 
		System.out.print(node.key + " "); 
		printInorder(node.right); 
	} 

	public static void main(String[] args) throws IOException 
	{ 
		BinarySearchTree tree = new BinarySearchTree(); 
		tree.root = new Node(20); 
		tree.root.left = new Node(8); 
		tree.root.right = new Node(22); 
		tree.root.left.left = new Node(4); 
		tree.root.left.right = new Node(12); 
	    root.left.right.left  = new Node(10); 
	    root.left.right.right = new Node(14); 


        File fp = new File("E:\\output.txt"); 
        
        String path = fp.getPath();
        
       tree.serialize(root, path); 
        tree.printInorder(root);
        
      
        // Let us deserialize the storeed tree into root1 
//        Node root1 = null; 
//        
//        FileReader fr = new FileReader("tree.txt"); 
//        deSerialize(root1, fr); 
//      
//        printf("Inorder Traversal of the tree constructed from file:\n"); 
//        inorder(root1); 
//      
			

	} 
} 

