public class NewBinarySearchTree {
    private int numberOfNodes;
    private Node root;

    public NewBinarySearchTree() {
        this.numberOfNodes = 0;
        this.root = null;
    }

    public void insert(int value) {
        Node toAdd = new Node(value);
        if (this.root == null) {
            this.root = toAdd;
            numberOfNodes++;
            return;
        }
        Node traversalNode = this.root;
        while (traversalNode.getValue() != value) {
            if (toAdd.getValue() < traversalNode.getValue()) {
                traversalNode.setLeft(attemptAdd(traversalNode.getLeft(), toAdd));
                traversalNode = traversalNode.getLeft();
            } else if(toAdd.getValue() > traversalNode.getValue()) {
                traversalNode.setRight(attemptAdd(traversalNode.getRight(), toAdd));
                traversalNode = traversalNode.getRight();
            }
        }
        numberOfNodes++;
    }

    public Node lookup(int value) {
        Node traversalNode = this.root;
        while (traversalNode != null) {
            if (value == traversalNode.getValue()) {
                return traversalNode;
            }
            if (value < traversalNode.getValue()) {
                traversalNode = traversalNode.getLeft();
                continue;
            }
            if (value > traversalNode.getValue()) {
                traversalNode = traversalNode.getRight();
            }
        }
        return null;
    }

    // does this node match the value
    // if less, move left. if higher move right
    // if match found update pointer of previous to pointer of right node

    public void remove(int value) {

    }

    private Node attemptAdd(Node traversalNode, Node toAdd) {
        if (traversalNode == null) {
            traversalNode = toAdd;
        }
        return traversalNode;
    }

    public int getNumberOfNodes() {
        return numberOfNodes;
    }
}
