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

> Note: \
    \
    There is more than one possible answer to this puzzle! There are number of different ways to "encode" a tree as a string of parentheses. Any solution that follows the laws above will be accepted. \
    \
    Your functions will run in sandboxes; only Tree, Leaf, Branch and console ( for .log ) will be in scope, and they will be frozen. If you need helper functions, define them inside your functions. If you experience any problems with this setup, please leave a comment in the Discourse.

