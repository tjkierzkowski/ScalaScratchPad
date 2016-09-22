/**IntSet examples*/
val t1 = new NonEmpty(3, Empty, Empty)
val t2 = t1 incl 4

/**Our abstract class that serves as a basis
  * for our binary tree representation of a set*/
abstract class IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(other: IntSet): IntSet
}
/** Class representation of the Leaf node in a binary tree.
  * contains => false because it is always 'Empty'
  * incl => IntSet with a NonEmpty node with 2 Empty objects as children*/
//class Empty extends IntSet {
object Empty extends IntSet {
  def contains(x: Int): Boolean = false
  def incl(x: Int): IntSet = new NonEmpty(x, Empty, Empty)
  def union(other: IntSet): IntSet = other
  override def toString = "."
}
/** Class representation of every other node in the binary tree
  * contains checks to see if the item exists
  * incl can add a new NonEmpty node*/
class NonEmpty (elem: Int, left: IntSet, right: IntSet) extends IntSet{
  def contains(x: Int): Boolean =
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true

  def incl(x: Int): IntSet =
    if (x < elem) new NonEmpty(elem, left incl x, right)
    else if (x > elem) new NonEmpty(elem, left, right incl x)
    else this

  def union(other: IntSet): IntSet =
    ((left union right) union other) incl elem
  override def toString = "{" + left + elem + right + "}"
}

/**You can override functions inherited by an abstract class*/
abstract class Base {
  def foo = 1
  def bar: Int
}

class Sub extends Base {
  override def foo = 2 //overrides the value
  def bar = 3         // <- Simply just implements, override is optional
}
