package com.ssthouse.jsontest.jsonparse;

import com.ssthouse.jsontest.Person;

import java.util.List;

/**
 * Created by ssthouse on 31/10/2016.
 */

public class GsonApi implements IPersonParser {
    @Override
    public Person getPerson(String personJsonStr) {
        return null;
    }

    @Override
    public List<Person> getPersonList(String personJsonArrayStr) {
        return null;
    }
}
