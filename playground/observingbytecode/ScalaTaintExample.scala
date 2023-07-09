object ScalaTaintExample {
	def taintSource(i: Int): Int = {
		i
	}

	def taintSink(i: Int): Unit = {
		println("Sink")
	}

	def main(args: Array[String]): Unit = {
		if (args.length != 2) {
			println("Please provide two integer arguments.")
		}

		val num1 = taintSource(args(0).toInt)
		val num2 = taintSource(args(1).toInt)
		val sum = num1 + num2

		println(s"The sum of $num1 and $num2 is: $sum")
		taintSink(sum)
	}
}
