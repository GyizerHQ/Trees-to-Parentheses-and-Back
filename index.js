class Tree {}
class Leaf extends Tree {}
class Branch extends Tree { constructor(left,right) }

let treeToParens = t => (t instanceof Leaf) ? '': '(' + treeToParens(t.left) + ')' + treeToParens(t.right);

function parensToTree(parens) {
  if (parens == '') return new Leaf();
  let lvl = 0, pos = 0;
  for (;;) {
    lvl += parens[pos++] == '(' ? 1 : -1;
    if (lvl == 0) break;
  }
  return new Branch(parensToTree(parens.slice(1, pos - 1)), parensToTree(parens.slice(pos)));
}
