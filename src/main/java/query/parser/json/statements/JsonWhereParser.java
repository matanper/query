package query.parser.json.statements;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import query.lang.components.ParseException;
import query.lang.components.QueryComponent;
import query.lang.components.QueryComponentParser;
import query.lang.expressions.Expression;
import query.lang.statements.Where;
import query.parser.json.expressions.JsonEqualsToParser;

public class JsonWhereParser extends QueryComponentParser<JsonElement> {

	@Override
	public QueryComponent parse(JsonElement obj) throws ParseException {
		if (!obj.isJsonObject()) {
			throw new ParseException("json 'WHERE' must be an object");
		}
		
		Iterator<Entry<String, JsonElement>> entiresIterator = obj.getAsJsonObject().entrySet().iterator();
		
		List<Expression> expressions = new ArrayList<Expression>();

		while(entiresIterator.hasNext()) {
			expressions.add(handleWhereEntry(entiresIterator.next()));
		}
		
		return new Where(expressions);
	}

	private Expression handleWhereEntry(Entry<String, JsonElement> next) throws ParseException {
		switch(next.getKey()) {
			case "EQ" : {
				return (Expression) new JsonEqualsToParser().parse(next.getValue());
			}
			default: {
				return null;
			}
		}
	}


}
