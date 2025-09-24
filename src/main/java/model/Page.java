package model;

import java.util.List;

public class Page {

    private String hash;
    private String baseUrl;
    private List<String> dataList;
    private List<String> dataServerList;

    public Page() {
    }

    public Page(List<String> dataServerList, List<String> dataList, String baseUrl, String hash) {
        this.dataServerList = dataServerList;
        this.dataList = dataList;
        this.baseUrl = baseUrl;
        this.hash = hash;
    }

    public List<String> getDataServerList() {
        return dataServerList;
    }

    public void setDataServerList(List<String> dataServerList) {
        this.dataServerList = dataServerList;
    }

    public List<String> getDataList() {
        return dataList;
    }

    public void setDataList(List<String> dataList) {
        this.dataList = dataList;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
