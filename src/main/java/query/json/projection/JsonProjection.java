package query.json.projection;

import java.util.HashSet;
import java.util.Set;

import com.google.gson.JsonElement;

import query.lang.projection.Projection;

public class JsonProjection extends Projection {

	private final Set<String> fields;

	public JsonProjection(JsonElement element) {
		this.fields = new HashSet<>();
	}
	
	public JsonProjection(Projection other) {
		this.fields = other.getFields();
	}
	@Override
	public Set<String> getFields() {
		return new HashSet<>(fields);
	}

}
