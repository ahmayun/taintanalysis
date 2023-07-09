public class TaintExample {
	public static int taintSource(int i) {
		return i;
	}

	public static void taintSink(int i) {
		System.out.println("Sink");
	}

	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("Please provide two integer arguments.");
			return;
		}

		int num1 = taintSource(Integer.parseInt(args[0]));
		int num2 = taintSource(Integer.parseInt(args[1]));
		int sum = num1 + num2;

		System.out.println("The sum of " + num1 + " and " + num2 + " is: " + sum);
		taintSink(sum);
	}
}
