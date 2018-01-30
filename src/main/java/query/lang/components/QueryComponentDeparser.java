package query.lang.components;

/**
 * 
 * @param <T> class to deparse to
 */
public abstract class QueryComponentDeparser<T> {

	public abstract T deparse(QueryComponent component);

}
