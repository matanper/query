package query.postgres.expressions;

import query.exceptions.Defect;
import query.lang.expressions.BinaryExpression;

public class PgBinaryExpression extends BinaryExpression {

	private final String field;
	private final Object value;
	private final Action action;
	
	public PgBinaryExpression(BinaryExpression expression) {
		this.field = expression.getField();
		this.value = expression.getValue();
		this.action = expression.getAction();
	}
	
	@Override
	public String getField() {
		return this.field;
	}

	@Override
	public Object getValue() {
		return this.value;
	}

	@Override
	public Action getAction() {
		return this.action;
	}
	
	public String asSQL() {
		StringBuilder builder = new StringBuilder(this.getField());
		
		switch(this.getAction()) {
			case EQUALS_TO: {
				builder.append("=");
				break;
			}
			case GREATER_THAN: {
				builder.append(">");
				break;
			}
			default: {
				throw new Defect("Uknown binary expression action " + this.getAction().name());
			}
		}
		
		builder.append(this.getValue());
		return builder.toString();
	}

}
