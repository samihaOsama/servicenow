package com.servicenow.datareader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 * Json class for reading a json file and sending properties to my test
 * @author samihaosama
 *
 */
public class JsonClass {

    File file;

    FileReader fileReader;

    JSONObject jsonObj;

    Object obj;

    JSONParser parser;

    HashMap<String, String> objectData;

    HashMap<String, String> loginData;

    Iterator<String> itr;

    public JsonClass() {
        try {
            parser = new JSONParser();
            jsonObj = (JSONObject) parser.parse(new FileReader(System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
                    + File.separator + "resources" + File.separator + "Data.json"));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public HashMap<String, String> getData(String object) {
        objectData = new HashMap<String, String>();
        objectData = ((HashMap<String, String>) jsonObj.get(object));
        return objectData;
    }

}
