package query.lang.expressions.multi;

import java.util.Arrays;
import java.util.List;

import query.lang.expressions.Expression;

public abstract class MultiExpression extends Expression {

	protected final List<Expression> expressions;
	
	@SafeVarargs
	public MultiExpression(Expression... expressions) {
		this.expressions = Arrays.asList(expressions);
	}
	
	public MultiExpression(List<Expression> expressions) {
		this.expressions = expressions;
	}
	
}
