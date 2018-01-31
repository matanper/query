package query.parser.json.expressions;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import query.lang.components.QueryComponent;
import query.lang.expressions.binary.EqualsTo;
import query.parser.ParseException;
import query.parser.QueryComponentParser;

public class JsonEqualsToParser implements QueryComponentParser<EqualsTo, JsonElement> {

	@Override
	public EqualsTo parse(JsonElement obj) throws ParseException {
		if (!obj.isJsonObject()) {
			throw new ParseException("json 'EQ' must be an object");
		}
		
		JsonObject jsonObj = obj.getAsJsonObject();
		
		JsonElement field = jsonObj.get("FIELD");
		JsonElement value = jsonObj.get("VALUE");
		
		if (!field.isJsonPrimitive()) {
			throw new ParseException("in 'EQ' field 'FIELD' must contian string");
		}
		
		if (!value.isJsonPrimitive()) {
			throw new ParseException("in 'EQ' field 'VALUE' must contain primitive");
		}
		
		return new EqualsTo(field.getAsString(), value);
	}

	
}
