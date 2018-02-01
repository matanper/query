package query.json.statements;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import com.google.gson.JsonElement;

import query.exceptions.ParseException;
import query.json.expressions.JsonExpression;
import query.lang.expressions.Expression;
import query.lang.statements.Where;

public class JsonWhere extends Where {

	private final List<Expression> expressions;
	
	public JsonWhere(JsonElement element) throws ParseException {
		if (!element.isJsonObject()) {
			throw new ParseException("json where must be object");
		}
		
		this.expressions = new ArrayList<>();
		
		Iterator<Entry<String, JsonElement>> iterator = element.getAsJsonObject().entrySet().iterator();
		while (iterator.hasNext()) {
			this.expressions.add(JsonExpression.create(iterator.next()));
		}
	}
	
	public JsonWhere(Where other) {
		this.expressions = new ArrayList<>();
		other.getExpressions().forEach(expression -> {
			this.expressions.add(JsonExpression.create(expression));
		});
	}
	
	@Override
	public List<Expression> getExpressions() {
		return new ArrayList<>(this.expressions);
	}

}
