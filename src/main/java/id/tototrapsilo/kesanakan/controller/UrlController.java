package id.tototrapsilo.kesanakan.controller;

import id.tototrapsilo.kesanakan.model.Url;
import id.tototrapsilo.kesanakan.service.UrlService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/url")
@Slf4j
public class UrlController {
    @Autowired
    private UrlService urlService;

    @RequestMapping(value = "/{key}", method=RequestMethod.GET)
    public void redirectUrl(@PathVariable String key, HttpServletRequest request, HttpServletResponse response) throws IOException, URISyntaxException, Exception {
        String redirectUrlString = urlService.getUrlByKey(key);
        log.info("target URL: "+redirectUrlString);
        if (redirectUrlString == null) {
            redirectUrlString = "https://www.tototrapsilo.id";
        }
        response.sendRedirect(redirectUrlString);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Url> shortenUrl(@RequestBody String targetUrl){
        Url url = urlService.shortenUrl(targetUrl);

        return ResponseEntity.ok(url);
    }
}
