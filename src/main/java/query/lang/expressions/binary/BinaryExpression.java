package query.lang.expressions.binary;

import query.lang.expressions.Expression;

public abstract class BinaryExpression extends Expression {

	protected final String field;
	protected final Object value;

	public BinaryExpression(String field, Object value) {
		this.field = field;
		this.value = value;
	}
	
	public String getField() {
		return this.field;
	}
	
	public Object getValue() {
		return this.value;
	}
}
