import sys
sys.stdin = open("input.txt","r")
sys.stdout = open("output.txt","w")





class Tree:
    pass

class Leaf(Tree):
    pass

class Branch(Tree):
    def __init__(self, left, right):
        self.left = left
        self.right = right

def treeToParens(tree):
    if isinstance(tree, Leaf):
        return "()"
    if isinstance(tree, Branch):
        return "(" + treeToParens(tree.left) + ")(" + treeToParens(tree.right) + ")"

def parensToTree(parens):
    if parens == "":
        return None
    if parens[0] != "(":
        raise ValueError("Invalid encoding: Missing opening parenthesis")
    if len(parens) == 2:
        return Leaf()

    count = 1
    i = 2
    while count != 0:
        if parens[i] == "(":
            count += 1
        elif parens[i] == ")":
            count -= 1
        i += 1

    left = parens[1:i-1]
    right = parens[i:len(parens)-1]

    return Branch(parensToTree(left), parensToTree(right))


tree = Branch(Leaf(), Branch(Leaf(), Leaf()))
parens = treeToParens(tree)
# reconstructedTree = parensToTree(parens)

print(parens)  # Output: "(()())"
# print(treeToParens(reconstructedTree) == parens)  # Output: True
# print(parensToTree(parensToTree(parens)) == tree)  # Output: True
