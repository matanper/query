package query.parser.json.expressions;

import java.util.Map.Entry;

import com.google.gson.JsonElement;

import query.lang.expressions.Expression;
import query.parser.ParseException;
import query.parser.QueryComponentParser;

public class ExpressionParser implements QueryComponentParser<Expression, Entry<String,JsonElement>> {

	@Override
	public Expression parse(Entry<String, JsonElement> entry) throws ParseException {
			switch(entry.getKey()) {
			case "EQ" : {
				return new JsonEqualsToParser().parse(entry.getValue());
			}
			default: {
				return null;
			}
		}
	}

}
