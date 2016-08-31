package com.chenhang.timepickerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.chenhang.myapplication.pickerview.TimePickerDialog;
import com.chenhang.myapplication.pickerview.data.Type;
import com.chenhang.myapplication.pickerview.listener.OnDateSetListener;
import com.chenhang.myapplication.pickerview.utils.Utils;

public class MainActivity extends AppCompatActivity implements OnDateSetListener{

    private Button button;
    private TextView time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        button = (Button) findViewById(R.id.button);
        time = (TextView) findViewById(R.id.time);

        final TimePickerDialog timePickerDialog = new TimePickerDialog.Builder()
                .setType(Type.ALL)
                .setCallBack(this)
                .build();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePickerDialog.show(getSupportFragmentManager(),"time picker");
            }
        });
    }

    @Override
    public void onDateSet(TimePickerDialog timePickerView, long millseconds) {
        time.setText(Utils.getDateToString(millseconds));
    }
}
