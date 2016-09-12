# JSON Reader Singleton
This is a JSON file loader singleton for use in Android apps.  
  
# 2 core methods:
- getJSONObjFromFile(String filename): 
    -  Returns a JSONObject from internal storage.
    -  File location can be changed.
- getJSONArrayFromFile(String filename, String neededArray): 
    - Finds a JSONObject in memory location and returns the specified JSONArray held within it.
    - File location can be changed.
