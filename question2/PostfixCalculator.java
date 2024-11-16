import java.util.Stack;

public class PostfixCalculator {

	// Driver code
	public static void main(String[] args) {
		String exp = "5 1 2 + 4 * + 3 -";

		// Function call
		System.out.println(evaluatePostfix(exp));
	}

	// Method to evaluate value of a postfix expression
	static int evaluatePostfix(String exp) {
		// Create a stack
		Stack<Integer> stack = new Stack<>();

		// Split the expression by spaces
		String[] tokens = exp.split("\\s+");

		// Scan all tokens one by one
		for (String token : tokens) {
			// If the token is empty, skip it
			if (token.trim().isEmpty()) {
				continue;
			}

			// If the token is an operand (number), push it to the stack
			if (token.matches("\\d+")) {
				stack.push(Integer.parseInt(token));
			}
			// If the token is an operator, pop two elements from stack and apply the
			// operator
			else {
				int val1 = stack.pop();
				int val2 = stack.pop();

				switch (token.charAt(0)) {
					case '+':
						stack.push(val2 + val1);
						break;
					case '-':
						stack.push(val2 - val1);
						break;
					case '/':
						stack.push(val2 / val1);
						break;
					case '*':
						stack.push(val2 * val1);
						break;
				}
			}
		}
		return stack.pop();
	}
}