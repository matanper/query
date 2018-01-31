package query.parser.json.projection;

import com.google.gson.JsonElement;

import query.lang.components.QueryComponent;
import query.lang.projection.Projection;
import query.parser.ParseException;
import query.parser.QueryComponentParser;

public class JsonProjectionParser implements QueryComponentParser<Projection,JsonElement> {

	@Override
	public Projection parse(JsonElement obj) throws ParseException {
		return new Projection();
	}

}
