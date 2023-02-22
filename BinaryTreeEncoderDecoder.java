//package com.aritra;
import java.util.*;

class Tree {
    Tree left, right;

    @Override
    public String toString() {
        return "Tree{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}
class Leaf extends Tree {
    Tree left, right;

    @Override
    public String toString() {
        return "Leaf{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}
class Branch extends Tree {
    Tree left, right;
    public Branch(Tree left, Tree right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}
public class BinaryTreeEncoderDecoder {
    public static String treeToParens(Tree tree) {
        if (tree instanceof Leaf) return "()";
        Branch branch = (Branch) tree;
        return "(" + treeToParens(branch.left) + treeToParens(branch.right) + ")";
    }

    public static Tree parensToTree(String parens) {
        Stack<Tree> stack = new Stack<Tree>();
        Stack<Character> chStk = new Stack<>();
        for(int i = 0; i < parens.length(); i++) {
            if(parens.charAt(i) == '(') {
                chStk.push('(');
            }else {
                chStk.pop();
                if(i != parens.length() - 1) {
                    if(stack.size() > chStk.size()) {
                        Tree right = stack.pop();
                        Tree left = stack.pop();
                        stack.push(new Branch(left, right));
                    }else {
                        stack.push(new Leaf());
                    }
                }else {
                    Tree right = stack.pop();
                    Tree left = stack.pop();
                    stack.push(new Branch(left, right));
                }
            }
        }
        return stack.peek();
    }
    public static boolean isIdentical(Tree root1, Tree root2) {
        if(root1 == null && root2 == null) return true;
        if(root1 != null && root2 != null) {
            return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
        }
        return false;
    }

    public static void main(String[] args) {
        // Sample 1
        Tree tree = new Branch(new Leaf(), new Branch(new Leaf(), new Leaf()));
        String parens = treeToParens(tree);
        System.out.println(parens);  // Output: "(()(()()))"
        Tree decodedTree = parensToTree(parens);
        System.out.println(decodedTree.toString());  //Output: "Branch{left=Leaf{left=null, right=null}, right=Branch{left=Leaf{left=null, right=null}, right=Leaf{left=null, right=null}}}"
        System.out.println(isIdentical(tree, decodedTree));  // Output: true

        // Sample 2
        Tree tree2 = new Branch(new Leaf(), new Leaf());
        String parens2 = treeToParens(tree2);
        System.out.println(parens2);  // Output: "(()())"
        Tree decodedTree2 = parensToTree(parens2);
        System.out.println(decodedTree2.toString());  // Output: "Branch{left=Leaf{left=null, right=null}, right=Leaf{left=null, right=null}}"
        System.out.println(isIdentical(tree2, decodedTree2));  // Output: true
    }
}
