**Binary trees** can be encoded as strings of balanced parentheses **(in fact, the two things are isomorphic)**.

Your task is to figure out such an encoding, and write the two functions which *convert* back and forth between the **binary trees** and **strings of parentheses**.

Here's the definition of binary trees:

```
class Tree {}
class Leaf extends Tree {}
class Branch extends Tree { constructor(left,right) {} }
```

And here are the functions you need to define:
```
function treeToParens(Tree) => String 
function parensToTree(String) => Tree 
```

The first function needs to return only strings of valid balanced parentheses `(like "()(())")`.
The second needs to accept any string of **balanced parentheses**.

Also, the functions need to be **inverses** of each other.
In other words, they need to satisfy the following equations:
```
treeToParens(parensToTree(parens)) === parens
parensToTree(treeToParens(tree)) === tree
```

   SOLUTION : -
   class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None
        
  def treeToParens(root, string):
    if root is None:
        return
 
    if not root.left and not root.right:
        return
 
    string.append('(')
    treeToParens(root.left, string)
    string.append(')')
 
    if root.right:
        string.append('(')
        treeToParens(root.right, string)
        string.append(')')
        
    def parensToTree(string):

	root = Node(string[0])

	if len(string) > 1:
		si = [1]
		ei = len(string)-1

		helper(si, ei, string, root)

	if (root == None):
		print("Empty")
	print(root.data, end=" ")
	preOrder(root.left)
	preOrder(root.right)
    
    
   def helper(si, ei, arr, root):

	if si[0] >= ei:
		return None

	if arr[si[0]] == "(":

		if arr[si[0]+1] != ")":
			if root.left is None:
				if si[0] >= ei:
					return
				new_root = Node(arr[si[0]+1])
				root.left = new_root
				si[0] += 2
				helper(si, ei, arr, new_root)

		else:
			si[0] += 2

		if root.right is None:
			if si[0] >= ei:
				return

			if arr[si[0]] != "(":
				si[0] += 1
				return

			new_root = Node(arr[si[0]+1])
			root.right = new_root
			si[0] += 2
			helper(si, ei, arr, new_root)
		else:
			return

	if arr[si[0]] == ")":
		if si[0] >= ei:
			return
		si[0] += 1
		return

	return

    
   
   
> Note: \
    \
    There is more than one possible answer to this puzzle! There are number of different ways to "encode" a tree as a string of parentheses. Any solution that follows the laws above will be accepted. \
    \
    Your functions will run in sandboxes; only Tree, Leaf, Branch and console ( for .log ) will be in scope, and they will be frozen. If you need helper functions, define them inside your functions. If you experience any problems with this setup, please leave a comment in the Discourse.
    
 

