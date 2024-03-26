package id.tototrapsilo.kesanakan.controller;

import id.tototrapsilo.kesanakan.model.Url;
import id.tototrapsilo.kesanakan.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController(value="/url")
public class UrlController {
    @Autowired
    UrlService urlService;
    @RequestMapping(value = "/{key}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> getUrlByKey(@PathVariable String key){
        String url = urlService.getUrlByKey(key);
        return ResponseEntity.ok(url);
    }
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Url> shortenUrl(@RequestBody String targetUrl){
        Url url = urlService.shortenUrl(targetUrl);

        return ResponseEntity.ok(url);
    }
}
