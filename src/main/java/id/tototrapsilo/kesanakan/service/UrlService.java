package id.tototrapsilo.kesanakan.service;

import id.tototrapsilo.kesanakan.model.Url;

public interface UrlService {
    public String getUrlByKey(String key);
    public Url shortenUrl(String targetUrl);
}
