package id.tototrapsilo.kesanakan.service.impl;

import com.google.common.hash.Hashing;
import id.tototrapsilo.kesanakan.model.Url;
import id.tototrapsilo.kesanakan.repository.UrlRepository;
import id.tototrapsilo.kesanakan.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.time.LocalDateTime;
@Service
public class UrlServiceImpl implements UrlService {
    @Autowired
    private UrlRepository urlRepository;
    @Override
    public String getUrlByKey(String key) {
        Url url = urlRepository.findById(key).orElse(null);
        return url != null ? url.getTargetUrl().replaceAll("^\"|\"$", "") : null;
    }

    @Override
    public Url shortenUrl(String targetUrl) {
        LocalDateTime localDateTime = LocalDateTime.now();
        String key = Hashing.murmur3_32_fixed().hashString(targetUrl, Charset.defaultCharset()).toString();
        Url newUrl = Url.builder()
                .key(key)
                .targetUrl(targetUrl)
                .createdAt(localDateTime)
                .build();

        return urlRepository.save(newUrl);
    }
}
