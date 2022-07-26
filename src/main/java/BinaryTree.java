public class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }
    public void insertNode(int value){
        if (root==null){
            root = new Node(value);
        } else {
            root.insertValue(value);
        }
    }
}

