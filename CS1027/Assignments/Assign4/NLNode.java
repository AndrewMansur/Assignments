import java.util.Comparator;
import java.util.Iterator;

public class NLNode<T>{

    // Instance Variables
    private NLNode<T> parent;
    private ListNodes<NLNode<T>> children;
    private T data;

    // Constructor
    public NLNode(){
        parent = null;
        data = null;
        children = new ListNodes<NLNode<T>>();
    }

    // Constructor
    public NLNode (T d, NLNode<T> p){
        children = new ListNodes<NLNode<T>>();
        data = d;
        parent = p;
    }

    // Set the parent of a node
    public void setParent(NLNode<T> p){
        parent = p;
    }

    // Returns the parent
    public NLNode<T> getParent(){
        return parent;
    }

    // Adding a child method
    public void addChild(NLNode<T> newChild){
        newChild.setParent(this);
        children.add(newChild);
    }

    // Returns the chilren
    public Iterator<NLNode<T>> getChildren() {
        return this.children.getList();
    }

    // Returns the children
    public Iterator<NLNode<T>> getChildren(Comparator<NLNode<T>> sorter) {
        return this.children.sortedList(sorter);
    }

    // returns the data
    public T getData() {
        return data;
    }

    // Sets the data
    public void setData(T d) {
        data = d;
    }
}

