public class Node {
    Node node_left, node_right;
    int value;

    public Node(int newValue) {
        value = newValue;
        node_left = node_right = null;
    }
    public void insertValue(int newValue){
        if (newValue< value){ //evaluation to check if there is a value on the left side of the tree already
          if (node_left==null){
              node_left= new Node(newValue);
          }else{
              node_left.insertValue(newValue);
          }
        } else if (newValue> value){ //evaluation to check if there is a value on the right side of the tree already
            if (node_right==null){
                node_right= new Node(newValue);
            }else{
                node_right.insertValue(newValue);
            }
        }
    }
    public void print(Node treeNode){
        if (treeNode == null){
            return;
        }
        if(treeNode.node_left == null && treeNode.node_right == null){
            System.out.println(treeNode.value);
        }
        print(treeNode.node_left);
        print(treeNode.node_right);
    }
}
