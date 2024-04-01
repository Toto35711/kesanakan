package id.tototrapsilo.kesanakan.controller;

import id.tototrapsilo.kesanakan.model.Url;
import id.tototrapsilo.kesanakan.service.UrlService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Logger;

@RestController
@RequestMapping("/url")
@Slf4j
public class UrlController {
    @Autowired
    private UrlService urlService;

    @RequestMapping(value = "/{key}", method=RequestMethod.GET)
    public RedirectView redirectUrl(@PathVariable String key, HttpServletRequest request, HttpServletResponse response) throws IOException, URISyntaxException, Exception {
        String redirectUrlString = urlService.getUrlByKey(key);
        if (redirectUrlString == null){
            redirectUrlString = "https://www.tototrapsilo.id/404";
        }
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(redirectUrlString);
        return redirectView;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Url> shortenUrl(@RequestBody String targetUrl){
        Url url = urlService.shortenUrl(targetUrl);

        return ResponseEntity.ok(url);
    }
}
