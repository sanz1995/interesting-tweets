package interesting_tweets.controller;

import interesting_tweets.Keyword;
import interesting_tweets.KeywordRepository;
import interesting_tweets.Tweet;
import interesting_tweets.TweetRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.google.common.collect.Lists;

import java.util.List;


@RestController
public class SearchController {

    @Autowired
    private TweetRepository tr;

    @Autowired
    private KeywordRepository kr;


    /**
     * Servicio REST que devuelve todas las incidencias de la base de datos
     */
    @PostMapping(value = "/words",produces = "application/json")
    public @ResponseBody String setWords(@RequestBody String message) {

        JSONObject JSONMessage = new JSONObject(message);

        JSONArray words = JSONMessage.getJSONArray("words");

        kr.deleteAll();

        for (int i =0; i< words.length();i++){
            kr.save(new Keyword((String)words.get(i)));
        }
        return "{ \"message\" : \"OK\"}";
    }



    /**
     * Servicio REST que devuelve todas las incidencias de la base de datos
     */
    @GetMapping(value = "/tweets",produces = "application/json")
    public @ResponseBody List<Tweet> getTweets() {

        return Lists.newArrayList(tr.findAll());
    }





}