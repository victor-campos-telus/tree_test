import org.junit.Test;

import static org.junit.Assert.*;

public class NodeTest {
    BinaryTree tree = new BinaryTree();

    @Test
    public void shouldInsertNode(){
        Node node1 = new Node(1);
        Node node2 = new Node(50);
        Node node3 = new Node(35);
        Node node4 = new Node(90);
        tree.insertNode(node1.value);
        tree.insertNode(node2.value);
        tree.insertNode(node3.value);
        tree.insertNode(node4.value);
        assertEquals(1,node1.value);
    }
    @Test
    public void shouldBeNull(){
        Node node1 = new Node(1);
        tree.insertNode(node1.value);
        node1=null;
        assertNull(node1);
    }
}