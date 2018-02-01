package query.postgres.projection;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import query.lang.projection.Projection;

public class PgProjection extends Projection{

	private final Set<String> fields;
	
	public PgProjection(Projection projection) {
		this.fields = projection.getFields();
	}
	
	@Override
	public Set<String> getFields() {
		return new HashSet<>(this.fields);
	}

	public String asSQL() {
		if (this.getFields().size() == 0) {
			return "*";
		} else {
			return this.getFields().stream().collect(Collectors.joining(", "));
		}
	}
}
