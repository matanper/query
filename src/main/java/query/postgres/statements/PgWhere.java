package query.postgres.statements;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import query.lang.expressions.Expression;
import query.lang.statements.Where;
import query.postgres.expressions.PgExpression;

public class PgWhere extends Where {

	private final List<PgExpression> expressions;
	
	public PgWhere(Where other) {
		this.expressions = new ArrayList<>();
		Iterator<Expression> expressionIterator = other.getExpressions().iterator();
		while (expressionIterator.hasNext()) {
			this.expressions.add(PgExpression.create(expressionIterator.next()));
		}
	}
	
	@Override
	public List<Expression> getExpressions() {
		return this.expressions;
	}
	
	public String asSQL() {
		this.getExpressions().stream().map(exp -> exp.).collect(Collectors.joining(" AND"));
	}

}
