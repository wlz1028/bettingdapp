package org.bettingdapp.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

/**
 * Bet model and DynamoDB mapper
 */
@DynamoDBTable(tableName = "Bets")
public class Bet {
    @DynamoDBHashKey
    private String gameName;

    @DynamoDBAttribute
    private String contractAddr;

    @DynamoDBAttribute
    private String ownerAddr;

    @DynamoDBAttribute
    private String solidity;

    @DynamoDBAttribute
    private String timestamp;

    public String getContractAddr() {
        return contractAddr;
    }

    public void setContractAddr(String contractAddr) {
        this.contractAddr = contractAddr;
    }

    public String getOwnerAddr() {
        return ownerAddr;
    }

    public void setOwnerAddr(String ownerAddr) {
        this.ownerAddr = ownerAddr;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getSolidity() {
        return solidity;
    }

    public void setSolidity(String solidity) {
        this.solidity = solidity;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override public String toString() {
        return "Bet{" +
                "contractAddr='" + contractAddr + '\'' +
                ", ownerAddr='" + ownerAddr + '\'' +
                ", gameName='" + gameName + '\'' +
                ", solidity='" + solidity + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
