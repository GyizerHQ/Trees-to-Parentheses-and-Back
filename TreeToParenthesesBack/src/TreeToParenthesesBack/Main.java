package TreeToParenthesesBack;

class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right = new TreeNode(6);

        TreeParenthesesEncoder encoder = new TreeParenthesesEncoder();
        String parenthesesStr = encoder.treeToParentheses(root);
        System.out.println(parenthesesStr);  // Output: (1(2(4))()(3(5(7)(8))(6)))

        TreeNode reconstructedRoot = encoder.parenthesesToTree(parenthesesStr);
    }
}