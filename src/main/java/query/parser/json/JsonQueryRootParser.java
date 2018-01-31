package query.parser.json;

import java.util.Optional;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import query.lang.QueryRoot;
import query.lang.components.QueryComponent;
import query.lang.statements.Select;
import query.lang.statements.Where;
import query.parser.ParseException;
import query.parser.QueryComponentParser;
import query.parser.json.statements.JsonSelectParser;
import query.parser.json.statements.JsonWhereParser;

public class JsonQueryRootParser implements QueryComponentParser<QueryRoot, JsonElement> {

	@Override
	public QueryRoot parse(JsonElement obj) throws ParseException {
		if (!obj.isJsonObject()) {
			throw new ParseException("Json query root must be object");
		}
		
		JsonObject jsonObj = obj.getAsJsonObject();
		Select select = parseSelect(jsonObj);
		Optional<Where> where = parseWhere(jsonObj);
		return new QueryRoot(select, where);
	}

	private Optional<Where> parseWhere(JsonObject jsonObj) throws ParseException {
		JsonElement element = jsonObj.get("WHERE");
		
		if (jsonObj.isJsonNull()) {
			return Optional.empty();
		} else {
			return Optional.of((Where)new JsonWhereParser().parse(element));
		}
	}

	private Select parseSelect(JsonObject obj) throws ParseException {
		JsonElement element = obj.get("SELECT");
		if (element.isJsonNull()) {
			throw new ParseException("Json query root must have SELECT");
		}
		
		return (Select) new JsonSelectParser().parse(element);
	}

}
