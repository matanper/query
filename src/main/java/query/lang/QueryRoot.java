package query.lang;

import java.util.Optional;

import query.lang.components.QueryComponent;
import query.lang.statements.Select;
import query.lang.statements.Where;

public class QueryRoot extends QueryComponent {

	protected final Select select;
	protected final Optional<Where> where;
	
	public QueryRoot(Select select, Optional<Where> where) {
		this.select = select;
		this.where = where;
	}
	
	public QueryRoot(Select select) {
		this(select, Optional.empty());
	}
}
