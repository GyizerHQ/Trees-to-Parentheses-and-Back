import java.util.Stack;

class Tree {
    // Base class for binary trees
}

class Leaf extends Tree {
    // Represents a leaf node in the binary tree
}

class Branch extends Tree {
    Tree left;
    Tree right;

    public Branch(Tree left, Tree right) {
        this.left = left;
        this.right = right;
    }
}

public class BinaryTreeEncoding {
    public static String treeToParens(Tree tree) {
        if (tree instanceof Leaf) {
            return "";
        } else if (tree instanceof Branch) {
            Branch branch = (Branch) tree;
            return "(" + treeToParens(branch.left) + ")" + "(" + treeToParens(branch.right) + ")";
        }
        return "";
    }

    public static Tree parensToTree(String parens) {
        int n = parens.length();
        if (n == 0) {
            return new Leaf();
        }

        Stack<Tree> stack = new Stack<>();
        Tree root = null;

        for (int i = 0; i < n; i++) {
            char ch = parens.charAt(i);
            if (ch == '(') {
                stack.push(root);
            } else if (ch == ')') {
                if (stack.isEmpty()) {
                    return null; // Invalid string
                }
                root = stack.pop();
            } else {
                return null; // Invalid character
            }
        }

        if (!stack.isEmpty()) {
            return null; // Invalid string
        }

        return root;
    }

    public static void main(String[] args) {
        // Example usage
        Tree tree = new Branch(new Leaf(), new Branch(new Leaf(), new Leaf()));
        String parens = treeToParens(tree);
        System.out.println("Encoded: " + parens);
        Tree decodedTree = parensToTree(parens);
        System.out.println("Decoded: " + decodedTree);
    }
}**
