package nkher.datastructures.trees;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by nameshkher on 6/11/16.
 */
public class HashedArrayTreeTest {

    HashedArrayTree<Integer> hashedArrayTree;

    @Before
    public void setup() {
        hashedArrayTree = new HashedArrayTree();
    }

    @Test
    public void testAddWithOneElement() {

        int element = 10;

        Assert.assertTrue(hashedArrayTree.size() == 0);
        hashedArrayTree.add(element);
        Assert.assertTrue(hashedArrayTree.size() == 1);

        System.out.println(hashedArrayTree.toString());
    }

    // @Test
    public void testAddWithThreeElements() {

        int elem1 = 10, elem2 = 20, elem3 = 30;

        hashedArrayTree.add(elem1);
        hashedArrayTree.add(elem2);
        hashedArrayTree.add(elem3);

        System.out.println(hashedArrayTree.toString());
        Assert.assertTrue(hashedArrayTree.size() == 3);
    }

}
