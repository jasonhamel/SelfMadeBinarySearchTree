import java.util.ArrayList;

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

    public void breadthFirstSearch() {
        Node traversalNode = this.root;
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Node> queue = new ArrayList<>();
        queue.add(traversalNode);

        while (queue.size() > 0) {
            traversalNode = queue.get(0);
            queue.remove(0);
            list.add(traversalNode.getValue());

            if (traversalNode.getLeft() != null) {
                queue.add(traversalNode.getLeft());
            }
            if (traversalNode.getRight() != null) {
                queue.add(traversalNode.getRight());
            }
        }
    }

    public ArrayList<Integer> dfsInOrder() {
        return traverseInOrder(this.root, new ArrayList<>());
    }

    public ArrayList<Integer> dfsPostOrder() {
        return traversePostOrder(this.root, new ArrayList<>());
    }

    public ArrayList<Integer> dfsPreOrder() {
        return traversePreOrder(this.root, new ArrayList<>());
    }

    public ArrayList<Integer> traverseInOrder(Node traversalNode, ArrayList<Integer> list) {
        if (traversalNode.getLeft() != null) {
            traverseInOrder(traversalNode.getLeft(), list);
        }
        list.add(traversalNode.getValue());
        if(traversalNode.getRight() != null) {
            traverseInOrder(traversalNode.getRight(), list);
        }
        return list;
    }

    public ArrayList<Integer> traversePostOrder(Node traversalNode, ArrayList<Integer> list) {
        if (traversalNode.getLeft() != null) {
            traversePostOrder(traversalNode.getLeft(), list);
        }
        if (traversalNode.getRight() != null) {
            traversePostOrder(traversalNode.getRight(), list);
        }
        list.add(traversalNode.getValue());
        return list;
    }

    public ArrayList<Integer> traversePreOrder(Node traversalNode, ArrayList<Integer> list) {
        list.add((traversalNode.getValue()));
        if (traversalNode.getLeft() != null) {
            traversePreOrder(traversalNode.getLeft(), list);
        }
        if (traversalNode.getRight() != null) {
            traversePreOrder(traversalNode.getRight(), list);
        }
        return list;
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
