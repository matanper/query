package query.parser;

import query.lang.components.QueryComponent;

/**
 * 
 * @param <T> class to parse from
 */
public interface QueryComponentParser<T extends QueryComponent, U> {
	
	public T parse(U obj) throws ParseException;
}
