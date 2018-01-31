package query.deparser.postgres;

import query.deparser.QueryComponentDeparser;
import query.deparser.postgres.statements.PgSelectDeparser;
import query.deparser.postgres.statements.PgWhereDeparser;
import query.lang.QueryRoot;

public class PgQueryRootDeparser implements QueryComponentDeparser<QueryRoot, String>{

	@Override
	public String deparse(QueryRoot component) {
		StringBuilder builder = new StringBuilder();
		
		builder.append(new PgSelectDeparser().deparse(component.getSelect()));
		builder.append(System.lineSeparator());
		
		component.getWhere().ifPresent(where -> {
			builder.append(new PgWhereDeparser().deparse(where));
		});
		
		return builder.toString();
	}

}
