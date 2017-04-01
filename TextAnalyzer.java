import java.io.FileNotFoundException;

public class TextAnalyzer {

	public static void main(String[] args) throws FileNotFoundException {
		BinarySearchTree BST = new BinarySearchTree();
		BST.readIn("WisdomForRoad.txt");
		BST.printWordsSorted();
		BST.maxSearchPath();
		BST.printTenMostCommonWords();
		

	}

}
