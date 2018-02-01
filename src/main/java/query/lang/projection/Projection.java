package query.lang.projection;

import java.util.Set;

import query.lang.components.QueryComponent;

public abstract class Projection extends QueryComponent {

	public abstract Set<String> getFields();
}
