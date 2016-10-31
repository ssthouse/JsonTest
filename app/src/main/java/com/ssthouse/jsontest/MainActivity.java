package com.ssthouse.jsontest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.ssthouse.jsontest.jsonparse.BaseParser;
import com.ssthouse.jsontest.jsonparse.FastjsonParser;
import com.ssthouse.jsontest.jsonparse.GsonParser;
import com.ssthouse.jsontest.jsonparse.IPersonParser;

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

    @BindView(R.id.id_rb_base_parse)
    RadioButton rbBaseParse;
    @BindView(R.id.rg_parse_potions)
    RadioGroup rgParseOptions;

    //初始化默认为BaseApi解析
    private IPersonParser mPersonParser = new BaseParser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        rbBaseParse.setChecked(true);
        rgParseOptions.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.id_rb_base_parse:
                        mPersonParser = new BaseParser();
                        break;
                    case R.id.id_rb_gson_parse:
                        mPersonParser = new GsonParser();
                        break;
                    case R.id.id_rb_fast_parse:
                        mPersonParser = new FastjsonParser();
                        break;
                }
            }
        });
    }

    @OnClick(R.id.id_btn_extract_json_obj)
    void parseJsonObj() {
        String personJsonStr = Person.generateJsonStr();
        etJsonStr.setText(personJsonStr);
        toastPersonObj(mPersonParser.getPerson(personJsonStr));
    }

    @OnClick(R.id.id_btn_extract_json_array)
    void parseJsonArray() {
        String personJsonArrayStr = Person.generateJsonArrayStr();
        etJsonStr.setText(personJsonArrayStr);
        toastPersonArray(mPersonParser.getPersonList(personJsonArrayStr));
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

}
