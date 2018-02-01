package query.postgres.expressions;

import query.exceptions.Defect;
import query.lang.expressions.BinaryExpression;
import query.lang.expressions.Expression;
import query.lang.expressions.MultiExpression;

public class PgExpression extends Expression {

	public static PgExpression create(Expression expression) {
		if (expression instanceof BinaryExpression) {
			return new PgBinaryExpression(expression);
		}
		else if (expression instanceof MultiExpression) {
			// TODO
			return null;
		} else {
			throw new Defect("Uknown calss type of expression " + expression.getClass().getName());
		}
	}
}
