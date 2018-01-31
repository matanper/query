package query.deparser;

import query.lang.components.QueryComponent;

/**
 * 
 * @param <T> class to deparse from
 */
public interface QueryComponentDeparser<T extends QueryComponent, U> {

	public U deparse(T component);

}
