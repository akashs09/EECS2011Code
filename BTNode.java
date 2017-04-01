

public class BTNode {
	 // Attributes
    private String word;                // A word in the file
    private int wordCounter;            // Number of occurrences of this word in
                                        // the file
    private BTNode left, right, parent; // This node's parent, and left and
                                        // right children
    // Constructor
   
    public BTNode(String s, BTNode left, BTNode right, BTNode parent)
    {
        this.wordCounter = 0;
        this.word = s;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

    // Methods
    
    public String element()
    {
       return this.word; 
    }

    
    public int getWordCounter()
    {
        return this.wordCounter;
    }

   
    public void increaseWordCounter()
    {
        this.wordCounter++;
    }

   
    public BTNode getLeft()
    {
        return this.left;
    }

    
    public void setLeft(BTNode v)
    {
        this.left = v;
    }

   
    public BTNode getRight()
    {
        return this.right;
    }

    
    public void setRight(BTNode v)
    {
        this.right = v;
    }

   
    public BTNode getParent()
    {
        return this.parent;
    }

   
    public void setParent(BTNode v)
    {
        this.parent = v;
    }
}
