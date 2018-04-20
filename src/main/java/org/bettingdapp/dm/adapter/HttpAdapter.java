package org.bettingdapp.dm.adapter;

import java.util.Map;

public class HttpAdapter implements DatasourceAdapterI {
    private String url;

    private String result;

    private Status status;

    public enum Status {
        NOT_PROC, PROC, FAILED, DONE
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override public void init(Map<String, Object> config) {
        url = (String) config.get("result");
        result = (String) config.get("result");
    }

    @Override public boolean isFinished() {
        if (status == Status.DONE)
            return true;
        else
            return false;
    }

    //TODO: return result from config for simulation purpose
    @Override public String getResult() {
        status = Status.DONE;
        return result;
    }
}
