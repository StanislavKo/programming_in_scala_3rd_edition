package chapter04

class ChecksumAccumulator1 {
	private var sum: Int = 0
	
	def add(x: Int): Unit = {
		sum += x
	}
	
	def checksum(): Int = sum & 0xFF
}

