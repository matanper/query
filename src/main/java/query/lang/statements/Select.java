package query.lang.statements;

import java.util.Map;

import query.lang.components.QueryComponent;
import query.lang.projection.Projection;

public abstract class Select extends QueryComponent {

	public abstract Map<String, Projection> getEntities();
}
