import java.util.ArrayList;
import java.util.Iterator;


public class FileStructure {
    //Instance variable
    private NLNode<FileObject> root;

    private void FileStructureHelper(NLNode<FileObject> node) throws FileObjectException {
        // Getting the nodes data
        FileObject fileObj = node.getData();

        // Checking if the node is a directory
        if (fileObj.isDirectory()) {
            // Creating an iterator to iterate over fileObject
            Iterator<FileObject> iterator = fileObj.directoryFiles();

            // Iterating through the subdirectories
            while (iterator.hasNext()) {
                FileObject childObj = iterator.next();
                NLNode<FileObject> child = new NLNode<FileObject>(childObj, node);

                // Recursivley calling the function
                FileStructureHelper(child);
                // Adding sub file to the node
                node.addChild(child);
            }
        }
    }

    // Constructor
    public FileStructure(String fileObjectName) throws FileObjectException {
        FileObject fileObj = new FileObject(fileObjectName);
        root = new NLNode<FileObject>(fileObj, null);

        FileStructureHelper(root);
    }

    // Returns the root node
    public NLNode<FileObject> getRoot() {
        return root;
    }

    // Finding the file of a certain type
    public Iterator<String> filesOfType(String type) {

        // Creating a new arraylist to store file names
        ArrayList<String> file = new ArrayList<>();
        filesOfTypeHelper(root, type, file);
        return file.iterator();
    }

    private void filesOfTypeHelper(NLNode<FileObject> node, String type, ArrayList<String> file) {
        Iterator<NLNode<FileObject>> iterate = node.getChildren();

        // Iterating through the subdirectories
        while (iterate.hasNext()) {
            NLNode<FileObject> childNode = iterate.next();
            FileObject fileObj = childNode.getData();

            // Checking if the object file is a file
            if (fileObj.isFile()){
                // Checking if the file extension is correct
                if (fileObj.getLongName().endsWith(type)) {
                    // Adding the path
                    file.add(fileObj.getLongName());
                }
            }
            else{
            // Recursivly calling the function
                filesOfTypeHelper(childNode, type, file);
            }
        }
    }
    public String findFile(String name) {
        // Creating a stack and adding the root
        java.util.LinkedList<NLNode<FileObject>> list = new java.util.LinkedList<>();
        list.push(root);

        // Iterating until not empty
        while (!list.isEmpty()) {
            // Checking and remoing the current node
            NLNode<FileObject> currentNode = list.pop();
            FileObject fileObj = currentNode.getData();
            java.util.Iterator<NLNode<FileObject>> iterate = currentNode.getChildren();

            // Checking if the name file parameter is the same 
            if (fileObj.getName().equals(name)) {
                // If so, retrn the filee path
                return fileObj.getLongName();
            }

            // Iterating through the subdirectories
            while (iterate.hasNext()) {
                list.push(iterate.next());
            }
        }
        
        // Otherwise retrn empty string
        return "";
    }

}
