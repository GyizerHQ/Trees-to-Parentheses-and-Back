class Tree:
    
	pass


class Leaf(Tree):
    
	pass


class Branch(Tree):
    
	def _init_(self, left, right):
        
		self.left = left
        
		self.right = right



	
def Parens(tree):
    
		if isinstance(tree, Leaf):
        				return "()"
    
		else:
        
			return f"({Parens(tree.left)}{Parens(tree.right)})"



	def tree(parens):
    
		stack = []
    
		i = 0
    
		while i < len(parens):
        
			if parens[i] == "(":
            				stack.append(parens[i])
        			elif parens[i] == ")":
            				subtree = stack.pop()
   
				right = stack.pop()
            				
				left = stack.pop()
            				
				subtree = Branch(left,right)

				stack.append(subtree)
			i+=1
		return stack.pop()




   