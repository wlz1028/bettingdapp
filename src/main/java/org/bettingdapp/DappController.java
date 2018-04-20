package org.bettingdapp;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import io.swagger.annotations.Api;
import javax.ws.rs.core.MediaType;

import io.swagger.annotations.ApiOperation;
import org.bettingdapp.model.Bet;
import org.bettingdapp.model.Datasource;
import org.bettingdapp.service.DappServiceI;
import org.bettingdapp.service.DappServiceImp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@Api(value = "BettingDapp")
public class DappController {

    DappServiceI service = new DappServiceImp();

    @GetMapping(value = "/health", produces = MediaType.TEXT_PLAIN)
    public String getHealth(@ApiIgnore @RequestHeader(required = false) Map<String, String> headers, HttpServletResponse response) {
        response.setStatus(200);
        return "I am healthy!";
    }

    @ApiOperation(value = "Returns all data sources",
            notes = "Returns all data sources",
            response = Datasource.class,
            responseContainer = "List")
    @GetMapping(value = "/datasources", produces = {MediaType.APPLICATION_JSON})
    public void getDatasources(@ApiIgnore @RequestHeader(required = false) Map<String, String> header, HttpServletResponse response){
        service.getDatasources(response);
    }

    @ApiOperation(value = "Returns all bets",
            notes = "Returns all bets",
            response = Bet.class,
            responseContainer = "List")
    @GetMapping(value = "/bets", produces = {MediaType.APPLICATION_JSON})
    public void getBets(@ApiIgnore @RequestHeader(required = false) Map<String, String> header, HttpServletResponse response){
        service.getBets(response);
    }

    @ApiOperation(value = "Create a new bet",
            notes = "Create a new bet")
    @PostMapping(value = "/bet")
    public void postQuery(@ApiIgnore @RequestHeader(required = false) Map<String, String> header,
            HttpServletResponse response,
            @RequestBody Bet bet){
        service.addBet(bet);

    }

}
