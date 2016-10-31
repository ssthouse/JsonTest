package com.ssthouse.jsontest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.et_json_str)
    EditText etJsonStr;
    @BindView(R.id.id_btn_extract_json_obj)
    Button idBtnExtractJsonObj;
    @BindView(R.id.id_btn_extract_json_array)
    Button idBtnExtractJsonArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.id_btn_extract_json_obj)
    void parseJsonObj() {
        etJsonStr.setText(generateJsonStr());
        Person person = new Person();
        try {
            JSONObject jsonObject = new JSONObject(generateJsonStr());
            person.name = jsonObject.getString("name");
            person.age = jsonObject.getInt("age");
            person.school = jsonObject.getString("school");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        toastPersonObj(person);
    }

    @OnClick(R.id.id_btn_extract_json_array)
    void parseJsonArray() {
        etJsonStr.setText(generateJsonArrayStr());
        List<Person> personList = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(generateJsonArrayStr());
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
        toastPersonArray(personList);
    }

    private void toastPersonObj(Person person) {
        Toast.makeText(this, person.toString(), Toast.LENGTH_LONG).show();
    }

    private void toastPersonArray(List<Person> personList) {
        StringBuilder sb = new StringBuilder();
        for (Person person : personList) {
            sb.append(person);
            sb.append("\n");
        }
        Toast.makeText(this, sb.toString(), Toast.LENGTH_LONG).show();
    }

    //构建Json对象字符串
    private String generateJsonStr() {
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
    private String generateJsonArrayStr() {
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
