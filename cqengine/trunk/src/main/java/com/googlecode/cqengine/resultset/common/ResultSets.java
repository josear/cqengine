package com.googlecode.cqengine.resultset.common;

import com.googlecode.cqengine.resultset.ResultSet;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

/**
 * Utility methods for working with {@link com.googlecode.cqengine.resultset.ResultSet} objects.
 *
 * @author Niall Gallagher
 */
public class ResultSets {

    /**
     * Returns a Collection-like view of the given ResultSet.
     * <p/>
     * The collection simply delegates to the ResultSet, which in turn will reflect
     * any changes made to the underlying IndexedCollection by other threads.
     * For example consecutive calls to the size() method
     * may return different values if objects are added to or removed from the IndexedCollection.
     *
     * @param resultSet The ResultSet to wrap
     * @return A Collection-like view of the given ResultSet
     */
    public static <O> Collection<O> asCollection(final ResultSet<O> resultSet) {
        return new AbstractCollection<O>() {
            @Override
            public Iterator<O> iterator() {
                return resultSet.iterator();
            }
            @Override
            public int size() {
                return resultSet.size();
            }

            @Override
            public boolean contains(Object o) {
                @SuppressWarnings("unchecked")
                O object = (O)o;
                return resultSet.contains(object);
            }

            @Override
            public boolean isEmpty() {
                return resultSet.isEmpty();
            }
        };
    }

    /**
     * Private constructor, not used.
     */
    ResultSets() {
    }
}
