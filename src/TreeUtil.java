/**
 * Util to provide operations on tree
 */
public class TreeUtil {

    // use for making string from tree
   private StringBuilder str = new StringBuilder();

    // counter for string validation
   private int count = 0;

    // index for making tree from string
    private int start = 0;

    // Function to construct Tree from String
    public Tree parensToTree(String s) {
        //checking string valid parenthesis
        if (s== null || s.isEmpty())
        {
            return null;
        }
        if (checkStr(s)) {
            System.out.println("Valid String");
            //if string is valid calling stringToTree function
            return stringToTree(s);
        } else {
            System.out.println("Invalid String");
            return null;
        }
    }

    // Function to construct Tree from String
    private Tree stringToTree(String s) {
        // base case , break the recursion if the index go beyond the str length
        if (start > s.length()) {
            return null;
        }
        boolean neg = false;

        //if string contain negative value
        if (s.charAt(start) == '-') {
            neg = true;
            start++;
        }
        int num = 0;

        //if string contain more then one digit number, and assuming the number is of base10
        while (start < s.length() && isDigit(s.charAt(start))) {
            int digit = getNumericValue(s.charAt(start));
            num = num * 10 + digit;
            start++;
        }

        // for negative value node making
        if (neg) {
            num = -1 * num;
        }
        Tree root = new Tree(num);
        if (start >= s.length())
            return root;

        // for left sub tree
        if (s.charAt(start) == '(') {
            start++;
            root.left = stringToTree(s);
        }
        if (start < s.length() && s.charAt(start) == ')') {
            start++;
            return root;
        }

        // for right sub tree
        if (start < s.length() && s.charAt(start) == '(') {
            start++;
            root.right = stringToTree(s);
        }
        if (start < s.length() && s.charAt(start) == ')') {
            start++;
            return root;
        }

        // when tree can not be formed
        if (start < s.length()) {
            System.out.println("Tree can not be formed");
            return null;
        } else {
            return root;
        }


    }

    protected int getNumericValue(char charAt) {
        //if its digit is already checked by caller
        return charAt-'0';
    }

    // Function to construct String from Tree
    public String treeToParens(Tree node) {
        //base case
        if (node == null)
            return str.toString();

        str.append(node.data);
        if (node.left == null && node.right == null)
            return str.toString();
        // for left subtree
        str.append("(");
        treeToParens(node.left);
        str.append(')');
       //for right subtree
        if (node.right != null) {
            str.append('(');
            treeToParens(node.right);
            str.append(')');
        }
        return str.toString();
    }

   boolean checkStr(String s) {
            for (int i = 0; i < s.length(); i++) {

                if (isDigit(s.charAt(i)) || s.charAt(i) == '(' || s.charAt(i) == ')' || s.charAt(i) == '-') {
                   // for negative value
                    if (s.charAt(i) == '-') {
                        if (!isDigit(s.charAt(i + 1))) {
                            return false;
                        }
                    }
                    if (s.charAt(i) == '(') {
                        count++;
                    }
                    if (s.charAt(i) == ')') {
                        count--;
                    }
                    if (count < 0) {
                        return false;
                    }
                } else
                    return false;
            }
            return count == 0;
    }

    // function for checking is character is a digit
    private boolean isDigit(char charAt) {
        return (charAt >= '0' && charAt <= '9');
    }
}
