package query.lang.components;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Waiting for better name 
 *
 */
public abstract class QueryComponent {
	
	public static <T> QueryComponent parse(QueryComponentParser<T> parser, T obj) throws ParseException {
		return parser.parse(obj);
	}
	
	public <T> T deparse(QueryComponentDeparser<T> parser, T obj) {
		return parser.deparse(this);
	}
}
