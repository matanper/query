package query.lang.expressions;

import java.util.Arrays;
import java.util.List;

public abstract class MultiExpression extends Expression {

	public abstract List<Expression> getExpressions();
	public abstract Action getAction();
	
	public enum Action {
		OR,
		AND
	}
}
