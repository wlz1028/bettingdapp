package org.bettingdapp.dao;

import org.bettingdapp.model.Datasource;

/**
 * Any Ethereum interaction should be hanled by the Infura gate way.
 * Infura allows Ethereum access without running a full node.
 */
public interface InfuraDao {
    //TODO: Simulate on REMIX. Having some issue with INFURA gateway setup
    boolean updateResult(Datasource ds, String result);

}
