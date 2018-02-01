package query.json.expressions;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;

import query.exceptions.ParseException;
import query.lang.expressions.BinaryExpression;

public class JsonBinaryExpression extends BinaryExpression {

	private final String field;
	private final Object value;
	private final Action action;
	
	public JsonBinaryExpression(JsonElement element, Action action) throws ParseException {
		if (!element.isJsonObject()) {
			throw new ParseException("binary expression must be object");
		}
		
		JsonElement fieldJson = element.getAsJsonObject().get("Field");
		JsonElement valueJson = element.getAsJsonObject().get("Value");
		
		if (!fieldJson.isJsonPrimitive()) {
			throw new ParseException("json binary expression 'field' must be string");
		}
		if (!valueJson.isJsonPrimitive()) {
			throw new ParseException("json binary expression 'value' must be primitive");
		}

		this.value = getJsonPrimitiveAsObject(valueJson.getAsJsonPrimitive());
		this.field = fieldJson.getAsString();
		this.action = action;
	}
	
	public JsonBinaryExpression(BinaryExpression other) {
		this.field = other.getField();
		this.action = other.getAction();
		this.value = other.getValue();
	}
	
	private Object getJsonPrimitiveAsObject(JsonPrimitive primitive) {
		if (primitive.isBoolean()) {
			return primitive.getAsBoolean();
		}
		else if (primitive.isNumber()) {
			return primitive.getAsNumber();
		} else {
			return primitive.getAsString();
		}
	}
	@Override
	public String getField() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Action getAction() {
		// TODO Auto-generated method stub
		return null;
	}

}
