package query.lang.statements;

import java.util.ArrayList;
import java.util.List;

import query.lang.components.QueryComponent;
import query.lang.expressions.Expression;

public abstract class Where extends QueryComponent {

	public abstract List<Expression> getExpressions();
	
}
