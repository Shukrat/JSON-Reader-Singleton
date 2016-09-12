// TO DO: Your package here.

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Shukrat on 8/28/2016.
 */
public class Helper_JSONReader_Singleton {
    private static final Helper_JSONReader_Singleton readerInstance = new Helper_JSONReader_Singleton();

    public static Helper_JSONReader_Singleton getInstance() {
        return readerInstance;
    }

    private Context mContext;

    private Helper_JSONReader_Singleton() {
    }

    // Since this is a single instance, passing in the context
    // of the activity that's using it makes it easier to get
    // file directories, etc.
    public void setContext(Context context){
        mContext = context;
    }

    // Gets a JSON file in memory
    public JSONObject getJSONObjFromFile(String filename){
        JSONObject jsonObj = new JSONObject();

        // Get internal storage path
        // Change this String (path) if you want to specify a different location for your files
        String path = mContext.getFilesDir().getAbsolutePath()+"/"+filename;
        FileInputStream fis;
        String content = "";
        try {
            // Directs inputstream to internal file storage
            // Can be replaced with a directory to raw.res if you have files stored in app that won't change
            fis = new FileInputStream(path);
            byte[] input = new byte[fis.available()];
            while (fis.read(input) != -1) {
                content += new String(input);
            }
            jsonObj = new JSONObject(content);
            fis.close();
        }
        catch (IOException|JSONException e) {
            e.printStackTrace();
        }

        return jsonObj;
    }

    // Gets a specific JSONArray from a JSON file in memory
    public JSONArray getJSONArrayFromFile(String filename, String neededArray){
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObj;

        // Get internal storage path
        // Change this String (path) if you want to specify a different location for your files
        String path = mContext.getFilesDir().getAbsolutePath()+"/"+filename;
        FileInputStream fis;
        String content = "";
        try {
            // Directs inputstream to internal file storage
            // Can be replaced with a directory to raw.res if you have files stored in app that won't change
            fis = new FileInputStream(path);
            byte[] input = new byte[fis.available()];
            while (fis.read(input) != -1) {
                content += new String(input);
            }
            jsonObj = new JSONObject(content);
            jsonArray = jsonObj.getJSONArray(neededArray);
            fis.close();
        }
        catch (IOException|JSONException e) {
            e.printStackTrace();
        }

        return jsonArray;
    }

    // JSONObjects in android already have a call to get an array from
    // an object. This method lets you pull the arrays a bit more dynamically.
    public JSONArray getJSONArrayFromJSONObject(JSONObject incomingJSON, String neededArray){
        JSONArray returnJSON = new JSONArray();

        try{
            returnJSON = incomingJSON.getJSONArray(neededArray);
        } catch (JSONException e){
            e.printStackTrace();
        }

        return returnJSON;
    }
}
