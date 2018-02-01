package query.json.statements;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.JsonElement;

import query.exceptions.ParseException;
import query.json.projection.JsonProjection;
import query.lang.projection.Projection;
import query.lang.statements.Select;

public class JsonSelect extends Select {

	private final Map<String, Projection> entities;
	
	public JsonSelect(JsonElement element) throws ParseException {
		if (!element.isJsonObject()) {
			throw new ParseException("json select must be object");
		}
		
		this.entities = new HashMap<>();
		
		element.getAsJsonObject().entrySet().forEach(entity -> {
			this.entities.put(entity.getKey(), new JsonProjection(entity.getValue()));
		});
		
	}
	
	public JsonSelect(Select select) {
		Map<String, Projection> otherEntities = select.getEntities();
		otherEntities.replaceAll((key, val) -> new JsonProjection(val));
		this.entities = otherEntities;
	}
	
	@Override
	public Map<String, Projection> getEntities() {
		return new HashMap<>(this.entities);
	}

}
