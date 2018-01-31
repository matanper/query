package query.deparser.postgres.statements;

import java.util.List;

import query.deparser.QueryComponentDeparser;
import query.deparser.postgres.expressions.PgExpressionDeparser;
import query.lang.expressions.Expression;
import query.lang.statements.Where;

public class PgWhereDeparser implements QueryComponentDeparser<Where, String> {

	@Override
	public String deparse(Where component) {
		StringBuilder builder = new StringBuilder("WHERE ");
		List<Expression> expressions = component.getExpressions();
		
		if (expressions.size() > 0) {
			// Take first component
			Expression first = component.getExpressions().get(0);
			builder.append(new PgExpressionDeparser().deparse(first));
			
			// Remove first expression from list
			List<Expression> expressionsWithoutFirst = expressions.subList(1, expressions.size());
			
			// For each remaining append 'AND' in the start
			expressionsWithoutFirst.forEach(exp -> {
				builder.append(" AND ");
				builder.append(new PgExpressionDeparser().deparse(exp));
			});
		}
		
		return builder.toString();
	}
}
