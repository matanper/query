package query.lang.expressions;

public abstract class BinaryExpression extends Expression {

	public abstract String getField();
	
	public abstract Object getValue();
	
	public abstract Action getAction();
	
	public enum Action {
		EQUALS_TO,
		GREATER_THAN
	}
}
