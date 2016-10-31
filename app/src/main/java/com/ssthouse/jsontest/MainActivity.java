package com.ssthouse.jsontest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static final String STR_JSON_OBJ = "{name:\"ssthouse\",age:21,school:\"HuaKe\"}";
    private static final String STR_JSON_ARRAY = "{array:[{name:\"name1\",age:1,school:\"school1\"},{name:\"" +
            "name2\",age:2,school:\"school2\"},{name:\"name3\",age:3,school:\"school3\"}]}";

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
    void parseJsonObj(){
        etJsonStr.setText(STR_JSON_OBJ);
        Person person = new Person();
        try {
            JSONObject jsonObject = new JSONObject(STR_JSON_OBJ);
            person.name = jsonObject.getString("name");
            person.age = jsonObject.getInt("age");
            person.school = jsonObject.getString("school");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        toastPersonObj(person);
    }

    @OnClick(R.id.id_btn_extract_json_array)
    void parseJsonArray(){

    }

    private void toastPersonObj(Person person) {
        Toast.makeText(this, person.toString(), Toast.LENGTH_LONG).show();
    }

    private void tostPersonArray(List<Person> personList) {

    }
}
