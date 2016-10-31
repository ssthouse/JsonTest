package com.ssthouse.jsontest.jsonparse;

import com.ssthouse.jsontest.Person;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ssthouse on 31/10/2016.
 */

public class BaseParser implements IPersonParser {

    @Override
    public Person getPerson(String personJsonStr) {
        Person person = new Person();
        try {
            JSONObject jsonObject = new JSONObject(personJsonStr);
            person.name = jsonObject.getString("name");
            person.age = jsonObject.getInt("age");
            person.school = jsonObject.getString("school");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public List<Person> getPersonList(String personJsonArrayStr) {
        List<Person> personList = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(personJsonArrayStr);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Person person = new Person();
                person.name = jsonObject.getString("name");
                person.age = jsonObject.getInt("age");
                person.school = jsonObject.getString("school");
                personList.add(person);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return personList;
    }
}
