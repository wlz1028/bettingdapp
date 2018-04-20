package org.bettingdapp.dao;

import java.util.ArrayList;
import java.util.List;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedScanList;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import org.bettingdapp.common.Util;
import org.bettingdapp.model.Bet;
import org.bettingdapp.model.Datasource;

/**
 * DynamoDB dao
 */
public class DynamoDbDao {
    protected AmazonDynamoDB ddb;
    protected DynamoDBMapper mapper;
    protected DynamoDB db;

    public DynamoDbDao() {
        ddb = AmazonDynamoDBClientBuilder.standard()
                .withRegion(Regions.US_WEST_2)
                .build();
        mapper = new DynamoDBMapper(ddb);
        db = new DynamoDB(ddb);
    }

    public List<Bet> getBets() {
        PaginatedScanList psl = mapper.scan(Bet.class, new DynamoDBScanExpression());
        List<Bet> bets = new ArrayList<>();
        for (int i = 0; i < psl.size(); i++)
            bets.add(Util.toObjectFromJson(Util.toJson((Bet) psl.get(i)), Bet.class));

        return bets;
    }

    public List<Datasource> getDatasources() {
        PaginatedScanList psl = mapper.scan(Datasource.class, new DynamoDBScanExpression());
        List<Datasource> datasources = new ArrayList<>();
        for (int i = 0; i < psl.size(); i++)
            datasources.add(Util.toObjectFromJson(Util.toJson((Datasource) psl.get(i)), Bet.class));

        return datasources;
    }

    public void addBet(Bet bet) {
        mapper.save(bet);
    }

    public void addDatasource(Datasource dataSource) {
        mapper.save(dataSource);
    }

    public void deleteBet(Bet bet) {
        mapper.delete(bet);
    }

    public void deleteDatasource(Datasource dataSource) {
        mapper.delete(dataSource);
    }
}
