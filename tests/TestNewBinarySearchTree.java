import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestNewBinarySearchTree {

    NewBinarySearchTree nbst;

    @Before
    public void setup() {
        nbst = new NewBinarySearchTree();
    }

    @Test
    public void testInsert() {
        nbst.insert(9);
        nbst.insert(4);
        nbst.insert(1);
        nbst.insert(20);
        nbst.insert(170);
        nbst.insert(6);
        nbst.insert(15);
        Assert.assertEquals(7, nbst.getNumberOfNodes());
    }

    @Test
    public void testLookup() {
        Assert.assertNull(nbst.lookup(9));
        nbst.insert(9);
        nbst.insert(4);
        nbst.insert(1);
        nbst.insert(20);
        nbst.insert(170);
        nbst.insert(6);
        nbst.insert(15);
        Assert.assertEquals(9, nbst.lookup(9).getValue());
        Assert.assertEquals(4, nbst.lookup(4).getValue());
        Assert.assertEquals(1, nbst.lookup(1).getValue());
        Assert.assertEquals(20, nbst.lookup(20).getValue());
        Assert.assertEquals(170, nbst.lookup(170).getValue());
        Assert.assertEquals(6, nbst.lookup(6).getValue());
        Assert.assertEquals(15, nbst.lookup(15).getValue());
        Assert.assertNull(nbst.lookup(234));
        Assert.assertNull(nbst.lookup(-234));
    }

    @Test
    public void testRemove() {
        nbst.insert(9);
        nbst.insert(4);
        nbst.insert(1);
        nbst.insert(20);
        nbst.insert(170);
        nbst.insert(6);
        nbst.insert(15);
        nbst.remove(1);
        Assert.assertNull(nbst.lookup(1));
        Assert.assertEquals(6, nbst.getNumberOfNodes());
        nbst.insert(1);
        Assert.assertEquals(1, nbst.lookup(1).getValue());
        Assert.assertEquals(7, nbst.getNumberOfNodes());
        nbst.remove(4);
        Assert.assertNull(nbst.lookup(4));
        Assert.assertEquals(6, nbst.getNumberOfNodes());
        nbst.insert(4);
        Assert.assertEquals(4, nbst.lookup(4).getValue());
        Assert.assertEquals(7, nbst.getNumberOfNodes());
        nbst.remove(6);
        Assert.assertNull(nbst.lookup(6));
        Assert.assertEquals(6, nbst.getNumberOfNodes());
        nbst.insert(6);
        Assert.assertEquals(6, nbst.lookup(6).getValue());
        Assert.assertEquals(7, nbst.getNumberOfNodes());
        nbst.remove(20);
        Assert.assertNull(nbst.lookup(20));
        Assert.assertEquals(6, nbst.getNumberOfNodes());
        nbst.insert(20);
        Assert.assertEquals(20, nbst.lookup(20).getValue());
        Assert.assertEquals(7, nbst.getNumberOfNodes());
        nbst.remove(15);
        Assert.assertNull(nbst.lookup(15));
        Assert.assertEquals(6, nbst.getNumberOfNodes());
        nbst.insert(15);
        Assert.assertEquals(15, nbst.lookup(15).getValue());
        Assert.assertEquals(7, nbst.getNumberOfNodes());
        nbst.remove(170);
        Assert.assertNull(nbst.lookup(170));
        Assert.assertEquals(6, nbst.getNumberOfNodes());
        nbst.insert(170);
        Assert.assertEquals(170, nbst.lookup(170).getValue());
        Assert.assertEquals(7, nbst.getNumberOfNodes());
        nbst.remove(234);
        Assert.assertNull(nbst.lookup(234));
        Assert.assertEquals(7, nbst.getNumberOfNodes());
    }
}
