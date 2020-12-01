package dk.dd.user.rating;

import com.google.gson.Gson;
import com.mongodb.*;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.internal.MongoDatabaseImpl;
import com.mongodb.client.model.Filters;

import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.result.*;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.json.JsonWriterSettings;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;

public class MongoDB {
    private static MongoDB mongoDB = null;
    private MongoCollection<User> users;

    private MongoDB() {
        ConnectionString connectionString = new ConnectionString("mongodb+srv://userRating:2pkRVpyeXe5N7Se6@userratingmicroservicec.8iri5.mongodb.net/users_database?retryWrites=true&w=majority");
        CodecRegistry pojoCodecRegistry = CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = CodecRegistries.fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
        MongoClientSettings clientSettings = MongoClientSettings.builder().applyConnectionString(connectionString).codecRegistry(codecRegistry).build();
        MongoClient mongoClient = MongoClients.create(clientSettings);
        users = mongoClient.getDatabase("users_database").getCollection("users", User.class);
    }

    public static MongoDB getInstance() {
        if (mongoDB == null) {
            mongoDB = new MongoDB();
        }
        return mongoDB;
    }

    public User mongoDBGetUser(String name) {
        var result = users.find(eq("name", name)).first();
        return result;
    }
    public User createMongoDBUser(User user){
        var result = users.insertOne(user);
        if(result.getInsertedId() == null){
            return null;
        }
        return user;
    }


}
