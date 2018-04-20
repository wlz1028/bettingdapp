package org.bettingdapp.dm;

import java.util.Hashtable;
import java.util.Map;

import org.bettingdapp.dao.DynamoDbDao;
import org.bettingdapp.dm.adapter.HttpAdapter;
import org.bettingdapp.model.Datasource;

/**
 * Add/Delete datasources to DynamoDB
 * Each datasource associates with DatasourceAdapterI
 * This feature is not fully automated
 */
public class DatasourceManager {
    DynamoDbDao dao = new DynamoDbDao();

    public void addDatasource(Datasource datasource){
        dao.addDatasource(datasource);
    }

    public void deleteDatasource(Datasource datasource) {
        dao.deleteDatasource(datasource);
    }

    public static void main(String[] args) {
        Datasource ds1 = new Datasource();
        ds1.setContractAddr("0x1");
        ds1.setDsAdapterClass(HttpAdapter.class.getName());
        ds1.setEtherPrivKey("fakePK");
        ds1.setEtherPubKey("fakeSK");
        Map<String, Object> config = new Hashtable<>();
        config.put("result", "101-21");
        config.put("url", "https://nba.com/20180401/raptorsheat");

        DatasourceManager dm = new DatasourceManager();
        dm.addDatasource(ds1);
    }




}
