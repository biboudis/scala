object Test {
  def testPermutations1(num: Int, stream: LazyList[Int]): Unit = {
    val perm = stream.permutations
    print(num)
    while(perm.hasNext) {
      print(" " + perm.next().toList)
    }
    println()
  }
  def testPermutations2(num: Int, stream: List[Int]): Unit = {
    val perm = stream.permutations
    print(num)
    while(perm.hasNext) {
      print(" " + perm.next().toList)
    }
    println()
  }

  def main(args: Array[String]): Unit = {
    testPermutations1(1, LazyList(1))
    testPermutations2(1, List(1))

    testPermutations1(2, LazyList(1, 2))
    testPermutations2(2, List(1, 2))

    testPermutations1(2, LazyList(2, 1))
    testPermutations2(2, List(2, 1))

    testPermutations1(3, LazyList(1, 2, 3))
    testPermutations2(3, List(1, 2, 3))

    testPermutations1(3, LazyList(1, 3, 2))
    testPermutations2(3, List(1, 3, 2))

    testPermutations1(3, LazyList(2, 1, 3))
    testPermutations2(3, List(2, 1, 3))

    testPermutations1(3, LazyList(2, 3, 1))
    testPermutations2(3, List(2, 3, 1))

    testPermutations1(3, LazyList(3, 1, 2))
    testPermutations2(3, List(3, 1, 2))

    testPermutations1(3, LazyList(3, 2, 1))
    testPermutations2(3, List(3, 2, 1))
  }
}
