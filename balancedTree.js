class Tree {}
class Leaf extends Tree {}
class Branch extends Tree { constructor(left,right) {
    super();
    this.left=left;
    this.right=right;
} }

const treeToParens = tree => (tree instanceof Leaf) ? '': '(' + treeToParens(tree.left) + ')' + treeToParens(tree.right);

const parensToTree=(parens)=> {
  if (parens == '') return new Leaf();
  let lvl = 0, pos = 0;
  for (;;) {
    lvl += parens[pos++] == '(' ? 1 : -1;
    if (lvl == 0) break;
  }
  return new Branch(parensToTree(parens.slice(1, pos - 1)), parensToTree(parens.slice(pos)));
}

let b=new Branch(new Branch(new Leaf(),new Leaf()),new Branch(new Leaf(),new Leaf()));

const str=treeToParens(b);
console.log(parensToTree(str))
