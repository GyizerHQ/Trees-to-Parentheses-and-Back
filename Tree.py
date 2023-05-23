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
    elif isinstance(tree, Branch):
        left_parens = treeToParens(tree.left)
        right_parens = treeToParens(tree.right)
        return f"({left_parens}{right_parens})"
    else:
        return ""

def parensToTree(parens):
    list = []
    root = 1,4,3,2,5

    for char in parens:
        if char == "(":
            list.append(root)
            root = None
        elif char == ")":
            root = list.pop()
        else:
            return None

    return root

leaf1 = Leaf()
leaf2 = Leaf()
branch = Branch(leaf1, leaf2)

parens = treeToParens(branch)
print(parens)

reconstructedTree = parensToTree(parens)
print(reconstructedTree)
