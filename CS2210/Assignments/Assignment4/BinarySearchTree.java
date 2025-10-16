public class BinarySearchTree {

    private BSTNode root = null;

    public BinarySearchTree() {
        root = new BSTNode(null);
    }

    public BSTNode getRoot() {
        return this.root;
    }

    public BSTNode get(BSTNode r, Key k) {
        while (r != null && !r.isLeaf()) {
            int cmp = k.compareTo(r.getRecord().getKey());
            r = cmp < 0 ? r.getLeftChild() : cmp > 0 ? r.getRightChild() : r;
        }
        return r != null && !r.isLeaf() ? r : null;
    }

    public void insert(BSTNode r, Record d) throws DictionaryException {
        BSTNode parent = null;
        while (r != null && !r.isLeaf()) {
            parent = r;
            int cmp = d.getKey().compareTo(r.getRecord().getKey());
            if (cmp == 0) throw new DictionaryException("Key already stored in tree.");
            r = cmp < 0 ? r.getLeftChild() : r.getRightChild();
        }
        if (parent == null) {
            root.setRecord(d);
            createChildNodes(root);
        } else {
            BSTNode newNode = new BSTNode(d);
            createChildNodes(newNode);
            if (d.getKey().compareTo(parent.getRecord().getKey()) < 0) {
                parent.setLeftChild(newNode);
            } else {
                parent.setRightChild(newNode);
            }
            newNode.setParent(parent);
        }
    }

    public void remove(BSTNode r, Key k) throws DictionaryException {
        BSTNode targetNode = get(r, k);
        if (targetNode == null) throw new DictionaryException("Key is not in the tree.");

        if (targetNode.getLeftChild().isLeaf() || targetNode.getRightChild().isLeaf()) {
            BSTNode child = targetNode.getLeftChild().isLeaf() ? targetNode.getRightChild() : targetNode.getLeftChild();
            replaceNode(targetNode, child);
        } else {
            BSTNode successor = smallest(targetNode.getRightChild());
            targetNode.setRecord(successor.getRecord());
            replaceNode(successor, successor.getRightChild());
        }
    }

    public BSTNode successor(BSTNode r, Key k) {
        BSTNode current = get(r, k);
        if (current == null) return null;
        if (!current.getRightChild().isLeaf()) return smallest(current.getRightChild());

        BSTNode parent = current.getParent();
        while (parent != null && current == parent.getRightChild()) {
            current = parent;
            parent = parent.getParent();
        }
        return parent;
    }

    public BSTNode predecessor(BSTNode r, Key k) {
        BSTNode current = get(r, k);
        if (current == null) return null;
        if (!current.getLeftChild().isLeaf()) return largest(current.getLeftChild());

        BSTNode parent = current.getParent();
        while (parent != null && current == parent.getLeftChild()) {
            current = parent;
            parent = parent.getParent();
        }
        return parent;
    }

    public BSTNode smallest(BSTNode r) {
        while (r != null && !r.isLeaf()) {
            r = r.getLeftChild();
        }
        return r != null ? r.getParent() : null;
    }

    public BSTNode largest(BSTNode r) {
        while (r != null && !r.isLeaf()) {
            r = r.getRightChild();
        }
        return r != null ? r.getParent() : null;
    }

    private void createChildNodes(BSTNode node) {
        node.setLeftChild(new BSTNode(null));
        node.getLeftChild().setParent(node);
        node.setRightChild(new BSTNode(null));
        node.getRightChild().setParent(node);
    }

    private void replaceNode(BSTNode oldNode, BSTNode newNode) {
        if (oldNode.getParent() == null) {
            root = newNode;
        } else if (oldNode == oldNode.getParent().getLeftChild()) {
            oldNode.getParent().setLeftChild(newNode);
        } else {
            oldNode.getParent().setRightChild(newNode);
        }
        if (newNode != null) {
            newNode.setParent(oldNode.getParent());
        }
    }

}
