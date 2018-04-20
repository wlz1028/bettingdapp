package org.bettingdapp.service;

import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.bettingdapp.common.Util;
import org.bettingdapp.dao.DynamoDbDao;
import org.bettingdapp.model.Bet;
import org.bettingdapp.model.Datasource;

public class DappServiceImp implements DappServiceI {
    DynamoDbDao dao = new DynamoDbDao();

    @Override public void getDatasources(HttpServletResponse response) {
        List<Datasource> datasources = dao.getDatasources();
        String dssJson = Util.toJson(datasources);
        try {
            OutputStream os = response.getOutputStream();
            os.write(dssJson.getBytes());
            os.flush();
            os.close();
        } catch (Exception e) {
            response.setStatus(400);
        }
    }

    @Override public void getBets(HttpServletResponse response) {
        List<Bet> bets = dao.getBets();
        String betsJson = Util.toJson(bets);
        try {
            OutputStream os = response.getOutputStream();
            os.write(betsJson.getBytes());
            os.flush();
            os.close();
        } catch (Exception e) {
            response.setStatus(400);
        }
    }

    @Override public void addBet(Bet bet) {
        dao.addBet(bet);
    }
}
