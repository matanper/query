package query.deparser.postgres.projection;

import query.deparser.QueryComponentDeparser;
import query.lang.projection.Projection;

public class PgProjectionDeparser implements QueryComponentDeparser<Projection, String> {

	@Override
	public String deparse(Projection component) {
		if (component.getFields().size() == 0) {
			return "*";
		}
		
		return "";
	}
}
