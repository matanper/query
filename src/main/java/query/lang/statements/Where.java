package query.lang.statements;

import java.util.ArrayList;
import java.util.List;

import query.lang.components.QueryComponent;
import query.lang.expressions.Expression;

public  class Where extends QueryComponent {

	protected final List<Expression> expressions;
	
	public Where(List<Expression> expressions) {
		this.expressions = expressions;
	}
	
	public List<Expression> getExpressions() {
		return new ArrayList<Expression>(this.expressions);
	}
}
