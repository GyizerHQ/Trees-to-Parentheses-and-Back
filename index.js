class Tree {}
class Leaf extends Tree {}
class Branch extends Tree {
  constructor(left, right) {
    super();
    this.left = left;
    this.right = right;
  }
}
