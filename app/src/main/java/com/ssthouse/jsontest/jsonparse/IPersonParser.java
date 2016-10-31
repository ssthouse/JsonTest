package com.ssthouse.jsontest.jsonparse;

import com.ssthouse.jsontest.Person;

import java.util.List;

/**
 * Created by ssthouse on 31/10/2016.
 */

public interface IPersonParser {

    Person getPerson(String personJsonStr);

    List<Person> getPersonList(String personJsonArrayStr);
}
