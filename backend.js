function treeToParens(tree) 
{
  if (tree instanceof Leaf) 
  {
    return "";
  }

  return "(" + treeToParens(tree.left) + ")" + treeToParens(tree.right);
}

function parensToTree(parens) 
{
  if (parens === "") 
  {
    return new Leaf();
  }

  let val = 0;

  for (let i = 0; i < parens.length; i++) 
  {
    switch (parens[i]) 
    {
      case "(":
        val++;
        break;
      case ")":
        val--;
        break;
    }
    if (val === 0) 
    {
      return new Branch(
        parensToTree(parens.slice(1, i)),
        parensToTree(parens.slice(i + 1))
      );
    }
  }
}
