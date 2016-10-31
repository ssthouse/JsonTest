package com.ssthouse.jsontest;

import org.json.JSONException;
import org.json.JSONStringer;

/**
 * Created by ssthouse on 31/10/2016.
 */

public class Person {

    public String name;
    public int age;
    public String school;

    @Override
    public String toString() {
        return "name:" + name + "  age:" + age + " school:" + school;
    }

    //构建Json对象字符串
    public static String generateJsonStr() {
        JSONStringer jsonStr = new JSONStringer();
        try {
            jsonStr.object()
                    .key("name")
                    .value("ssthouse")
                    .key("age")
                    .value(21)
                    .key("school")
                    .value("HuaKe")
                    .endObject();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonStr.toString();
    }

    //构造JsonArray字符串
    public static String generateJsonArrayStr() {
        JSONStringer jsonStringer = new JSONStringer();
        try {
            jsonStringer.array()
                    .object()
                    .key("name")
                    .value("name1")
                    .key("age")
                    .value(1)
                    .key("school")
                    .value("school1")
                    .endObject()

                    .object()
                    .key("name")
                    .value("name2")
                    .key("age")
                    .value(2)
                    .key("school")
                    .value("school2")
                    .endObject()

                    .object()
                    .key("name")
                    .value("name3")
                    .key("age")
                    .value(3)
                    .key("school")
                    .value("school3")
                    .endObject()

                    .endArray();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonStringer.toString();
    }
}
