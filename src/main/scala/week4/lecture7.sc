/** Lists
  *   - immutable
  *   - recursive and not flat (much like our previous implementations)
  * */
val ex_fruit = List("apples", "oranges", "pears")
val ex_diag = List(List(1,0,0),List(0,1,0),List(0,0,1))

val init_fruit: List[String] = List("apples", "oranges", "pears")
val init_nums: List[Int] = List(1, 2, 3, 4)
val diag: List[List[Int]] = List(List(1,0,0),List(0,1,0),List(0,0,1))
val empty: List[Nothing] = List()

val fruit = "apples" :: ("oranges" :: ("pears" :: Nil))
val nums = 1 :: (2 :: (3 :: (4 :: Nil)))
val lh_nums = 1 :: 2 :: 3 :: 4 :: Nil
val rh_nums = Nil.::(4).::(3).::(2).::(1)

fruit.head
fruit.tail.head
diag.head
//empty.head
