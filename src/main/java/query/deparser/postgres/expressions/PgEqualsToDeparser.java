package query.deparser.postgres.expressions;

import query.deparser.QueryComponentDeparser;
import query.lang.expressions.binary.EqualsTo;

public class PgEqualsToDeparser implements QueryComponentDeparser<EqualsTo, String> {

	@Override
	public String deparse(EqualsTo component) {
		return component.getField() + "=" + component.getValue();
	}
}
