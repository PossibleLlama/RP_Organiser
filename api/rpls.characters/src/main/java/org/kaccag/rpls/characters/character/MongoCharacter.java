package org.kaccag.rpls.characters.character;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import org.kaccag.rpls.characters.save.Saveable;

public class MongoCharacter extends Saveable<Character> {
    private final MongoCollection<Document> collection;

    public MongoCharacter() {
        String hostname = System.getenv("RPLS_DB_HOST");
        String port = System.getenv("RPLS_DB_PORT");

        String replicaSet = System.getenv("RPLS_DB_REP");
        String databaseName = System.getenv("RPLS_DB_DB");
        String collectionName = System.getenv("RPLS_DB_COLLECTION");

        String username = System.getenv("RPLS_DB_USER");
        String password = System.getenv("RPLS_DB_PASS");
        String usernamePassword = username == null || password == null ? "" : username + ":" + password + "@";

        String uri = "mongodb://" + usernamePassword + hostname + ":" + port + "/" + replicaSet;

        MongoClient mongoClient = new MongoClient(new MongoClientURI(uri));
        MongoDatabase db = mongoClient.getDatabase(databaseName);
        collection = db.getCollection(collectionName);
    }

    @Override
    public void addOne(Character obj) {
        Document document = new Document("_id", obj.getId());
        document.append("playername", obj.getPlayerName());
        document.append("charactername", obj.getCharacterName());

        collection.insertOne(document);
    }
}
