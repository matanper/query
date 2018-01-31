package query.deparser.postgres.statements;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import query.deparser.QueryComponentDeparser;
import query.deparser.postgres.projection.PgProjectionDeparser;
import query.lang.projection.Projection;
import query.lang.statements.Select;

public class PgSelectDeparser implements QueryComponentDeparser<Select, String> {

	@Override
	public String deparse(Select component) {
		StringBuilder builder = new StringBuilder("SELECT");
		
		Iterator<Entry<String, Projection>> entities = component.getEntities().entrySet().iterator();
		
		if (entities.hasNext()) {
			Entry<String,Projection> entry = entities.next();
			builder.append(" ");
			builder.append(new PgProjectionDeparser().deparse(entry.getValue()));
			builder.append(" FROM ");
			builder.append(entry.getKey());
		}
		
		return builder.toString();
	}

}
