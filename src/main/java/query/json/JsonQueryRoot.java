package query.json;

import java.util.Optional;

import com.google.gson.JsonElement;

import query.exceptions.ParseException;
import query.json.statements.JsonSelect;
import query.json.statements.JsonWhere;
import query.lang.QueryRoot;
import query.lang.statements.Select;
import query.lang.statements.Where;

public class JsonQueryRoot extends QueryRoot {

	private final Select select;
	private final Optional<Where> where;
	
	public JsonQueryRoot(JsonElement element) throws ParseException {
		if (!element.isJsonObject()) {
			throw new ParseException("json query root must be object");
		}
		
		this.select = new JsonSelect(element.getAsJsonObject().get("Select"));
		
		JsonElement jsonWhere = element.getAsJsonObject().get("Where");
		if (!jsonWhere.isJsonNull()) {
			this.where = Optional.of(new JsonWhere(jsonWhere));
		} else {
			this.where = Optional.empty();
		}
	}
	
	public JsonQueryRoot(QueryRoot root) {
		this.select = new JsonSelect(root.getSelect());
		if (root.getWhere().isPresent()) {
			this.where = Optional.of(new JsonWhere(root.getWhere().get()));
		} else {
			this.where = Optional.empty();
		}
	}

	@Override
	public Select getSelect() {
		return this.select;
	}

	@Override
	public Optional<Where> getWhere() {
		return this.where;
	}
}
