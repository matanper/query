package query.parser.json.statements;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import query.lang.components.QueryComponent;
import query.lang.expressions.Expression;
import query.lang.statements.Where;
import query.parser.ParseException;
import query.parser.QueryComponentParser;
import query.parser.json.expressions.ExpressionParser;
import query.parser.json.expressions.JsonEqualsToParser;

public class JsonWhereParser implements QueryComponentParser<Where, JsonElement> {

	@Override
	public Where parse(JsonElement obj) throws ParseException {
		if (!obj.isJsonObject()) {
			throw new ParseException("Json 'WHERE' must be an object");
		}
		
		Iterator<Entry<String, JsonElement>> entiresIterator = obj.getAsJsonObject().entrySet().iterator();
		
		List<Expression> expressions = new ArrayList<Expression>();

		while(entiresIterator.hasNext()) {
			expressions.add(new ExpressionParser().parse((entiresIterator.next())));
		}
		
		return new Where(expressions);
	}
}
