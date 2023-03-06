class Tree {}
class Leaf extends Tree {}
class Branch extends Tree {
  constructor(left, right) {
    super();
    this.left = left;
    this.right = right;
  }
}

function treeToParens(tree) {
  if (tree instanceof Leaf) {
    return '';
  }
  return '(' + treeToParens(tree.left) + ')' + treeToParens(tree.right);
}

function parensToTree(str) {
  if (str == '') return new Leaf();
  let le = 0, tr = 0;
  for (let c of str) {
    le += str[tr++] === '(' ? 1 : -1;
    if (le === 0) break;
  }
    return new Branch(
        parensToTree(str.slice(1, tr - 1)),
        parensToTree(str.slice(tr))
  );
}


  

 
// Example usage
const tree = new Branch(
  new Leaf(),
  new Branch(new Branch(new Leaf(), new Leaf()), new Leaf(), new Leaf())
);
const parens = treeToParens(tree);
console.log(parens); // Outputs: ()(())
const treeFromParens = parensToTree(parens);
console.log(treeFromParens); // Outputs: Branch { left: Leaf {}, right: Branch { left: Branch { left: Leaf {}, right: Leaf {} }, right: Leaf {} }}

console.log(treeToParens(parensToTree(parens)) === parens)
console.log(JSON.stringify(parensToTree(treeToParens(tree))) === JSON.stringify(tree)); // prints "true"