package query.json.expressions;

import java.util.Map.Entry;

import com.google.gson.JsonElement;

import query.exceptions.Defect;
import query.exceptions.ParseException;
import query.lang.expressions.BinaryExpression;
import query.lang.expressions.Expression;
import query.lang.expressions.MultiExpression;

public class JsonExpression {

	public static Expression create(Entry<String, JsonElement> element) throws ParseException {
		switch(element.getKey()) {
			case "EQ": {
				return new JsonBinaryExpression(element.getValue(), BinaryExpression.Action.EQUALS_TO);
			}
			default: {
				throw new ParseException("Uknown expression " + element.getKey());
			}
		}
	}
	
	public static Expression create(Expression expression) {
		if (expression instanceof BinaryExpression) {
			return new JsonBinaryExpression((BinaryExpression)expression);
		}
		else if (expression instanceof MultiExpression) {
			// TODO
			return null;
		} else {
			throw new Defect("Uknown class of expression " + expression.getClass().getName());
		}
	}
}
