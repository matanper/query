package query.deparser.postgres.expressions;

import query.deparser.QueryComponentDeparser;
import query.lang.expressions.Expression;
import query.lang.expressions.binary.EqualsTo;

public class PgExpressionDeparser implements QueryComponentDeparser<Expression, String> {

	@Override
	public String deparse(Expression component) {
		
		if (component instanceof EqualsTo) {
			return new PgEqualsToDeparser().deparse((EqualsTo)component);
		} 
		
		return "";
	}
}
