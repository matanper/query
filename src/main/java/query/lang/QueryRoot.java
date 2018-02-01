package query.lang;

import java.util.Optional;

import query.lang.components.QueryComponent;
import query.lang.statements.Select;
import query.lang.statements.Where;

public abstract class QueryRoot extends QueryComponent {

	public abstract Select getSelect();
	public abstract Optional<Where> getWhere();
}
