package query.lang.components;

/**
 * 
 * @param <T> class to parse from
 */
public abstract class QueryComponentParser<T> {
	
	public abstract QueryComponent parse(T obj) throws ParseException;
}
