package sample.dao;

import org.slim3.datastore.Datastore;

import sample.meta.TweetMeta;
import sample.model.Tweet;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class TestDao {


    public Tweet getContent() {
        TweetMeta t = new TweetMeta();
        Key parentKey = KeyFactory.createKey("Account", "Default");
         Tweet tweet = Datastore.query(t ,parentKey).asSingle();
         return tweet;
    }


}
