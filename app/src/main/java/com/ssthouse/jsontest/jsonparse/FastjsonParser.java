package com.ssthouse.jsontest.jsonparse;

import com.alibaba.fastjson.JSON;
import com.ssthouse.jsontest.Person;

import java.util.List;

/**
 * Created by ssthouse on 31/10/2016.
 */

public class FastjsonParser implements IPersonParser {
    @Override
    public Person getPerson(String personJsonStr) {
        return JSON.parseObject(personJsonStr, Person.class);
    }

    @Override
    public List<Person> getPersonList(String personJsonArrayStr) {
        return JSON.parseArray(personJsonArrayStr, Person.class);
    }
}
