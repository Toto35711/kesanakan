package id.tototrapsilo.kesanakan.service;

import id.tototrapsilo.kesanakan.model.Url;

public interface UrlService {
    public String getUrlByKey(Integer key);
    public Url shortenUrl(String targetUrl);
}
