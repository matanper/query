package query.parser.json.projection;

import com.google.gson.JsonElement;

import query.lang.components.ParseException;
import query.lang.components.QueryComponent;
import query.lang.components.QueryComponentParser;
import query.lang.projection.Projection;

public class JsonProjectionParser extends QueryComponentParser<JsonElement> {

	@Override
	public QueryComponent parse(JsonElement obj) throws ParseException {
		return new Projection();
	}

}
