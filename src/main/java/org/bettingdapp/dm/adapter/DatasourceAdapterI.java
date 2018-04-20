package org.bettingdapp.dm.adapter;

import java.util.Map;

/**
 * An adapter is able to fetch data from trusted third-party sources, source websites, database, or REST API.
 * For instance, HttpAdapter implements this interface to fetch data from websites.
 */
public interface DatasourceAdapterI {
    void init(Map<String, Object> config);

    boolean isFinished();

    String getResult();

    HttpAdapter.Status getStatus();
}
