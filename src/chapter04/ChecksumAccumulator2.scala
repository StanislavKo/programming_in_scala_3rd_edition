package chapter04

import scala.collection.mutable

object ChecksumAccumulator2 {
	val cache = mutable.Map.empty[String, Int]
	
	def calculate(s: String): Int = {
		if (cache.contains(s)) cache(s)
		else {
			val acc = new ChecksumAccumulator1
			for (c <- s) acc.add(c.toByte)
			val chs = acc.checksum()
			cache += (s -> chs)
			chs
		}
	}
}

