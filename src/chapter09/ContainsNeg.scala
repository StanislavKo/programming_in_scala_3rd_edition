package chapter09

object ContainsNeg {
  def containsNeg(nums: List[Int]): Boolean = {
    if (nums.isEmpty) {
      return false
    }
    if (nums.head < 0) {
      true
    } else {
      containsNeg(nums.tail)
    }
  }
}