package chapter09

object MyAssert {
  def assert(assertEnabled: Boolean)(predicate: () => Boolean) = {
    if (assertEnabled && !predicate()) {
      throw new AssertionError
    }
  }
}