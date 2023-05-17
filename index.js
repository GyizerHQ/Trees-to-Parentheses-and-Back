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
  let left = treeToParens(tree.left);
  let right = treeToParens(tree.right);
  let str = '(' + left + ')' + right;
  return str;
}

function parensToTree(str) {
  if (str == '') 
    return new Leaf();
    
  let leaf = 0, tree = 0;
  for (let c of str) {
    leaf += str[tree++] === '(' ? 1 : -1;
    if (leaf === 0) break;
  }
    return new Branch(
        parensToTree(str.slice(1, tree - 1)),
        parensToTree(str.slice(tree))
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
