package eg.edu.alexu.csd.datastructure.stack.csX22;

public interface IExpressionEvaluator {
	public String infixToPostfix(String expression);
	public int evaluate(String expression);
}
