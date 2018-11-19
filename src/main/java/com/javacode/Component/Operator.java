package com.javacode.Component;

import com.javacode.Entity.ItemEnt;
import com.javacode.Repository.ItemRepository;
import com.javacode.bean.Item;
import com.javacode.bean.Rss;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;

@Component
public class Operator {

    private final String uri = "http://feeds.nos.nl/nosjournaal?format=xml";

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE, d MMM yyyy HH:mm:ss Z", Locale.ENGLISH);
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");

    @Autowired
    private ItemRepository repository;

    @Scheduled(fixedRate = 300000)//60.000 ms * 5
    public void doRequest () {

        RestTemplate restTemplate = new RestTemplate();
        Rss T = restTemplate.getForObject (uri, Rss.class );  //reaching webservice
        Item[]  it = T.getChannel ().getItem ();

        System.out.println ("********Running at --> "+dateFormat.format(Calendar.getInstance ().getTime()) );

         for( Item i : it ) {
             if (!repository.exists (i.getTitle ())){  //if the item exists dont do anything

                  ItemEnt newItem = new ItemEnt (
                          i.getTitle (),
                          i.getDescription (),
                          Date.valueOf (LocalDate.parse(i.getPubDate ( ), formatter)),
                          i.getEnclosure ().getType (),
                          i.getEnclosure ().getUrl ()  );

                  repository.save (newItem); // inserting new record on database

             }
         }
    }

}