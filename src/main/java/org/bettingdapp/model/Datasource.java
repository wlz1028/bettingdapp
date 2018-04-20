package org.bettingdapp.model;

import java.util.Map;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConvertedJson;

/**
 * Datasource model and DynamoDB mapper
 */
@DynamoDBTable(tableName = "Datasources")
public class Datasource {
    @DynamoDBHashKey
    private String gameName;

    @DynamoDBAttribute
    private String dsAdapterClass;

    @DynamoDBTypeConvertedJson
    private Map<String, Object> adapterConfig;

    @DynamoDBAttribute
    private String contractAddr;

    @DynamoDBAttribute
    private String EtherPubKey;

    @DynamoDBAttribute
    private String EtherPrivKey;

    public String getDsAdapterClass() {
        return dsAdapterClass;
    }

    public void setDsAdapterClass(String dsAdapterClass) {
        this.dsAdapterClass = dsAdapterClass;
    }

    public Map<String, Object> getAdapterConfig() {
        return adapterConfig;
    }

    public void setAdapterConfig(Map<String, Object> adapterConfig) {
        this.adapterConfig = adapterConfig;
    }

    public String getContractAddr() {
        return contractAddr;
    }

    public void setContractAddr(String contractAddr) {
        this.contractAddr = contractAddr;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getEtherPubKey() {
        return EtherPubKey;
    }

    public void setEtherPubKey(String etherPubKey) {
        EtherPubKey = etherPubKey;
    }

    public String getEtherPrivKey() {
        return EtherPrivKey;
    }

    public void setEtherPrivKey(String etherPrivKey) {
        EtherPrivKey = etherPrivKey;
    }

    @Override public String toString() {
        return "Datasource{" +
                "dsAdapterClass='" + dsAdapterClass + '\'' +
                ", adapterConfig=" + adapterConfig +
                ", contractAddr='" + contractAddr + '\'' +
                ", gameName='" + gameName + '\'' +
                ", EtherPubKey='" + EtherPubKey + '\'' +
                ", EtherPrivKey='" + EtherPrivKey + '\'' +
                '}';
    }
}
