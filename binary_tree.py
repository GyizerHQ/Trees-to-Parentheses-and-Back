class Tree:
    def __init__(self, data):
        self.data = data
        self.left = self.right = None

    @classmethod
    def treeToParens(cls, node):
        if not node:
            print("()", end="")
            return
        print(f"({node.data} ", end="")
        cls.treeToParens(node.left)
        print(" ", end="")
        cls.treeToParens(node.right)
        print(")", end="")
               

# For below binary tree
#      1
#     / \
#    2   3
#   /     \
#  4       5

node = Tree(1)
node.left = Tree(2)
node.right = Tree(3)
node.left.left = Tree(4)
node.right.right = Tree(5)
Tree.treeToParens(node)
print("\n")


# Still not completed. parensToTree() is yet to be developed.