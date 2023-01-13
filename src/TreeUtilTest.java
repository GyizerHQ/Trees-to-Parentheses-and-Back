import org.junit.Assert;

class TreeUtilTest {

    /**
     * Test 1:
     * Creating tree 10 as root
     * 15 as right node to 10 and 5 as left
     * expected output 10(5)(15)
     */
    @org.junit.jupiter.api.Test
    void treeToParensTest1() {
        TreeUtil m = new TreeUtil();

        Tree t1 = new Tree(10);
        t1.left = new Tree(5);
        t1.right = new Tree(15);

        String result = m.treeToParens(t1);

        Assert.assertEquals("10(5)(15)", result);
    }

    /**
     * Test 1:
     * Creating tree 10 as root
     * 15 as right node to 10
     * expected output 10()(15)
     */
    @org.junit.jupiter.api.Test
    void treeToParensTest2() {
        TreeUtil m = new TreeUtil();

        Tree t1 = new Tree(10);
        t1.right = new Tree(15);

        String result = m.treeToParens(t1);

        Assert.assertEquals("10()(15)", result);
    }

    /**
     * testcase : tree with height 2
     */
    @org.junit.jupiter.api.Test
    void parensToTreeTest1() {
        TreeUtil m = new TreeUtil();
        String s = "5(2(3)(1))(7(6)(10))";
        Tree root = m.parensToTree(s);
        String result = m.treeToParens(root);

        Assert.assertEquals("5(2(3)(1))(7(6)(10))", result);
    }

    /**
     * testcase : Invalid case at parent level
     */
    @org.junit.jupiter.api.Test
    void checkStrTest1() {
        TreeUtil m = new TreeUtil();
        String s = "5(2)(-3)(1)";
        boolean result = m.checkStr(s);
        Assert.assertEquals(true, result);
    }

    /**
     * testcase : invalid string on right sub tree
     */
    @org.junit.jupiter.api.Test
    void testStringValidity1() {
        String str1 = "15(10)(25(20)(35)(24))";

        Tree tree = new TreeUtil().parensToTree(str1);
        Assert.assertNull(tree);
    }

    /**
     * testcase : return null for empty and null string
     */
    @org.junit.jupiter.api.Test
    void testStringValidity2() {
        String str1 = "";

        Tree tree = new TreeUtil().parensToTree(str1);
        Assert.assertNull(tree);
    }

    /**
     * testcase : return 9 for char '9'
     */
    @org.junit.jupiter.api.Test
    void getNumericValueTest()
    {
        TreeUtil m= new TreeUtil();
       int value= m.getNumericValue('9');
       Assert.assertEquals(9,value);

    }

}