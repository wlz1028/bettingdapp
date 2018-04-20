package org.bettingdapp.dm;

import java.util.List;

import org.bettingdapp.dao.DynamoDbDao;
import org.bettingdapp.dao.InfuraDao;
import org.bettingdapp.dm.adapter.DatasourceAdapterI;
import org.bettingdapp.dm.adapter.HttpAdapter;
import org.bettingdapp.model.Datasource;

/**
 * Poll datasources from DynamoDB every 5 mins.
 * For each datasource, fetch data from external source via adapter.
 * Update result to smart contract iff game ended
 */
public class DatasourceExecutor {
    private DynamoDbDao ddbDao = new DynamoDbDao();
    private InfuraDao infuraDao;

    public DynamoDbDao getDdbDao() {
        return ddbDao;
    }

    public void setDdbDao(DynamoDbDao ddbDao) {
        this.ddbDao = ddbDao;
    }

    /**
     * Execute a datasource and update result to smart contract
     * @param datasource
     */
    private void execute(Datasource datasource) {
        try {
            DatasourceAdapterI adapter = (DatasourceAdapterI) Class.forName(datasource.getDsAdapterClass()).newInstance();
            adapter.init(datasource.getAdapterConfig());

            //Only process data that's not done
            if(adapter.getStatus() != HttpAdapter.Status.DONE) {
                String res =adapter.getResult();
                //update result via INFURA gateway
                if (infuraDao.updateResult(datasource, res)){
                    ddbDao.deleteDatasource(datasource);
                }
            }
        } catch (Exception e) {
            System.err.println("Unable to execute datasource");
        }
    }

    public static void main(String[] args) throws Exception {
        while (true) {
            DatasourceExecutor executor = new DatasourceExecutor();
            List<Datasource> dataSourceList = executor.getDdbDao().getDatasources();

            //Execute each datasource and update smart contract if result is ready
            for (Datasource ds : dataSourceList) {
                executor.execute(ds);
            }

            //Poll datasource executor every 5 mins
            Thread.sleep(1000*60*5L);
        }
    }
}
