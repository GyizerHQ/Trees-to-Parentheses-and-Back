public class Solution {
    public static void main(String[] args) {

        String s = "5(2(3)(1))(7(6))";

        TreeUtil m = new TreeUtil();

        Tree root = m.parensToTree(s);

        String str = m.treeToParens(root);

        System.out.println(str);
    }
}
