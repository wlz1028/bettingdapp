package org.bettingdapp.service;

import javax.servlet.http.HttpServletResponse;

import org.bettingdapp.model.Bet;

public interface DappServiceI {
    /**
     * @param response
     * @return
     */
    void getDatasources(HttpServletResponse response);

    /**
     * @param response
     * @return
     */
    void getBets(HttpServletResponse response);

    /**
     * @param bet
     */
    void addBet(Bet bet);
}
