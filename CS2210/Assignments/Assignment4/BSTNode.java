public class BSTNode {

    // Instance variables
    private Record record; 
    private BSTNode parent, left, right;  

    // Constructor
    public BSTNode(Record item) {
        this.record = item;
        this.parent = null;
        this.left = null;
        this.right = null;
    }

    // Returns the Record object stored in this node.
    public Record getRecord() {
        return this.record;
    }

    // Stores the given record in this node.
    public void setRecord(Record d) {
        this.record = d;
    }

    // Returns the left child.
    public BSTNode getLeftChild() {
        return this.left;
    }

    //Return the right child
    public BSTNode getRightChild() {
        return this.right;
    }

 
    // Returns the parent.
    public BSTNode getParent() {
        return this.parent;
    }

    // Sets the left child to the specified value
    public void setLeftChild(BSTNode u) {
        this.left = u;
    }

    // Sets the right child to the specified value.
    public void setRightChild(BSTNode u) {
        this.right = u;
    }

    // Sets the parent to the specified value.
    public void setParent(BSTNode u) {
        this.parent = u;
    }

    // : Returns true if this node is a leaf; false otherwise. A node is a leaf if both of its children are null.
    public boolean isLeaf() {
        return (left == null && right == null);
    }
}
