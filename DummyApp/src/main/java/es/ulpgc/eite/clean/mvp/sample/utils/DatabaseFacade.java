package es.ulpgc.eite.clean.mvp.sample.utils;


import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.ulpgc.eite.clean.mvp.sample.data.ModelItem;
import io.realm.Realm;

public class DatabaseFacade {
    private static Realm realmDatabase;

    public static Realm getDatabase() {
        if (realmDatabase == null) {
            realmDatabase = Realm.getDefaultInstance();
        }
        return realmDatabase;
    }

    public static JSONObject createJsonObject(int id){
        Map<String, String> item = new HashMap();
        item.put("id", String.valueOf(id));
        item.put("content", "Item " + id);
        item.put("details", makeDetails(id));
        final JSONObject json = new JSONObject(item);
        return json;
    }

    public static void deleteAllDatabaseItems(){
        for(ModelItem item: getItemsFromDatabase()){
            DatabaseFacade.deleteDatabaseItem(item);
        }
    }

    public static void deleteDatabaseItem(ModelItem item) {
        final String id = item.getId();
        getDatabase().executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.where(ModelItem.class).equalTo("id", id)
                        .findAll()
                        .deleteAllFromRealm();
            }
        });
    }

    public static List<ModelItem> getItemsFromDatabase(){
        return getDatabase().where(ModelItem.class).findAll();
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position).append("\n");
        for (int count = 0; count < position; count++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    public static void saveFromJsonObject(final JSONObject json) {
        getDatabase().executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.createObjectFromJson(ModelItem.class, json);
            }
        });
    }

    // -------------------------------------------------------------------------------
    // Fill dummy contents of the database

    private static final int ITEM_COUNT = 9;

    public static void setItemsFromJsonObjectArray(){
        // Add some sample items
        for (int count = 1; count <= ITEM_COUNT; count++) {
            DatabaseFacade.saveFromJsonObject(DatabaseFacade.createJsonObject(count));
        }
    }

    // -------------------------------------------------------------------------------
    //  Fill the database with the contents of a JSON file. Use streams if you are worried about
    //  the size of the JSON whether it was persisted on disk or received from the network.

    //  Example of use:
    //    Context context = getPresenter().getManagedContext();
    //    InputStream stream = context.getAssets().open(filename);
    //    setItemsFromJsonStream (stream);

    public static void setItemsFromJsonStream(InputStream stream)  {
        try {
            // Open a transaction to store items into the realmDatabase
            getDatabase().beginTransaction();
            try {
                getDatabase().createAllFromJson(ModelItem.class, stream);
                getDatabase().commitTransaction();
            } catch (IOException e) {
                // Remember to cancel the transaction if anything goes wrong.
                getDatabase().cancelTransaction();
            } finally {
                if (stream != null) {
                    stream.close();
                }
            }

        } catch (IOException ex) {

        }
    }

}