package query.lang.statements;

import java.util.HashMap;
import java.util.Map;

import query.lang.components.QueryComponent;
import query.lang.projection.Projection;

public class Select extends QueryComponent {

	private final Map<String, Projection> entities;
	
	public Select(Map<String, Projection> entities) {
		this.entities = entities;
	}
	
	public Map<String, Projection> getEntities() {
		return new HashMap<>(this.entities);
	}
}
