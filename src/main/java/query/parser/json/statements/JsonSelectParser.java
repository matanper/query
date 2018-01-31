package query.parser.json.statements;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import query.lang.components.QueryComponent;
import query.lang.projection.Projection;
import query.lang.statements.Select;
import query.parser.ParseException;
import query.parser.QueryComponentParser;
import query.parser.json.projection.JsonProjectionParser;

public class JsonSelectParser implements QueryComponentParser<Select, JsonElement> {

	@Override
	public Select parse(JsonElement obj) throws ParseException {
		if (!obj.isJsonObject()) {
			throw new ParseException("json Select must be an object");
		}
		
		JsonObject jsonObj = obj.getAsJsonObject();
		Map<String, Projection> entities = new HashMap<String, Projection>();
		Iterator<Entry<String, JsonElement>> entriesIterator = jsonObj.entrySet().iterator();
		
		while (entriesIterator.hasNext()) {
			addEntityToMap(entriesIterator.next(), entities);
		}
		
		return new Select(entities);
	}

	private void addEntityToMap(Entry<String, JsonElement> entry, Map<String, Projection> entities) throws ParseException {
		Projection proj = new JsonProjectionParser().parse(entry.getValue());
		entities.put(entry.getKey(), proj);
	}
	
}
