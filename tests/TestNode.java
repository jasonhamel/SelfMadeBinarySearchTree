import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestNode {
    Node node;

    @Before
    public void setup() {
        node = new Node(50);
    }

    @Test
    public void testNode() {
        Assert.assertEquals(50, node.getValue());
        Assert.assertNull(node.getLeft());
        Assert.assertNull(node.getRight());
    }

    @Test
    public void testLeft() {
        node.setLeft(new Node(45));
        Assert.assertEquals(45, node.getLeft().getValue());
        Assert.assertNull(node.getRight());
        Assert.assertNull(node.getLeft().getLeft());
        Assert.assertNull(node.getLeft().getRight());
    }

    @Test
    public void testRight() {
        node.setRight(new Node(55));
        Assert.assertEquals(55, node.getRight().getValue());
        Assert.assertNull(node.getLeft());
        Assert.assertNull(node.getRight().getRight());
        Assert.assertNull(node.getRight().getLeft());
    }
}
