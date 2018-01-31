package query.lang.projection;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import query.lang.components.QueryComponent;

public class Projection extends QueryComponent {

	protected Set<String> fields;
	
	public Projection() {
		this.fields = Collections.emptySet();
	}
	
	public Set<String> getFields() {
		return new HashSet<>(this.fields);
	}
}
