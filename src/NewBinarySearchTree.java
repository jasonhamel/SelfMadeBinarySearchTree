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
        if (root == null) {
            return;
        }
        Node traversalNode = this.root;
        Node parentNode = null;

        while (traversalNode != null) {
            if (value < traversalNode.getValue()) {
                parentNode = traversalNode;
                traversalNode = traversalNode.getLeft();
            } else if (value > traversalNode.getValue()) {
                parentNode = traversalNode;
                traversalNode = traversalNode.getRight();
            } else if (value == traversalNode.getValue()) {
                /*Option 1*/if (traversalNode.getRight() == null) {
                    if (parentNode == null) {
                        this.root = traversalNode.getLeft();
                    } else {
                        if (traversalNode.getValue() < parentNode.getValue()) {
                            parentNode.setLeft(traversalNode.getLeft());
                        } else if (traversalNode.getValue() > parentNode.getValue()) {
                            parentNode.setRight(traversalNode.getLeft());
                        }
                    }
                } /*Option 2*/else if (traversalNode.getRight().getLeft() == null) {
                    if (parentNode == null) {
                        this.root = traversalNode.getLeft();
                    } else {
                        traversalNode.getRight().setLeft(traversalNode.getLeft());
                        if (traversalNode.getValue() < parentNode.getValue()) {
                            parentNode.setLeft(traversalNode.getRight());
                        } else if (traversalNode.getValue() > parentNode.getValue()) {
                            parentNode.setRight(traversalNode.getRight());
                        }
                    }
                } /*Option 3*/else {
                    Node leftmostNode = traversalNode.getRight().getLeft();
                    Node leftmostParentNode = traversalNode.getRight();
                    while (leftmostNode.getLeft() != null) {
                        leftmostParentNode = leftmostNode;
                        leftmostNode = leftmostNode.getLeft();
                    }

                    leftmostParentNode.setLeft(leftmostNode.getRight());
                    leftmostNode.setLeft(traversalNode.getLeft());
                    leftmostNode.setRight(traversalNode.getRight());

                    if (parentNode == null) {
                        this.root = leftmostNode;
                    } else {
                        if (traversalNode.getValue() < parentNode.getValue()) {
                            parentNode.setLeft(leftmostNode);
                        } else if (traversalNode.getValue() > parentNode.getValue()) {
                            parentNode.setRight(leftmostNode);
                        }
                    }
                }
                numberOfNodes--;
                return;
            }
        }
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
