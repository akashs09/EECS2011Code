package analyzer;

import java.io.FileNotFoundException;

public class TextAnalyzer {

	public static void main(String[] args) throws FileNotFoundException {
		BinarySearchTree BST = new BinarySearchTree();
		
		BST.readIn("/Users/akashsharma/Documents/WisdomForRoad.txt");
		BST.printWordsSorted();
//		System.out.println(BST.size());
		BST.maxSearchPath();
		
		
		
	}

}
