package query.parser.json.statements;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import query.lang.components.ParseException;
import query.lang.components.QueryComponent;
import query.lang.components.QueryComponentParser;
import query.lang.projection.Projection;
import query.lang.statements.Select;
import query.parser.json.projection.JsonProjectionParser;

public class JsonSelectParser extends QueryComponentParser<JsonElement> {

	@Override
	public QueryComponent parse(JsonElement obj) throws ParseException {
		if (!obj.isJsonObject()) {
			throw new ParseException("json Select must be an object");
		}
		
		JsonObject jsonObj = obj.getAsJsonObject();
		Map<String, Projection> entities = new HashMap<String, Projection>();
		Iterator<Entry<String, JsonElement>> entriesIterator = jsonObj.entrySet().iterator();
		
		while (entriesIterator.hasNext()) {
			addEntryToMap(entriesIterator.next(), entities);
		}
		
		return new Select(entities);
	}

	private void addEntryToMap(Entry<String, JsonElement> entry, Map<String, Projection> entities) throws ParseException {
		Projection proj = (Projection) new JsonProjectionParser().parse(entry.getValue());
		entities.put(entry.getKey(), proj);
	}
	
}
