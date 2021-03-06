package com.ssthouse.jsontest.jsonparse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ssthouse.jsontest.Person;

import java.util.List;

/**
 * Created by ssthouse on 31/10/2016.
 */

public class GsonParser implements IPersonParser {

    @Override
    public Person getPerson(String personJsonStr) {
        Gson gson = new Gson();
        return gson.fromJson(personJsonStr, Person.class);
    }

    @Override
    public List<Person> getPersonList(String personJsonArrayStr) {
        Gson gson = new Gson();
        TypeToken typeToken = new TypeToken<List<Person>>() {
        };
        return gson.fromJson(personJsonArrayStr, typeToken.getType());
    }
}
