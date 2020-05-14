package sg.edu.rp.c346.id19002765.reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText name, number, size;
    CheckBox smoking;
    DatePicker dp;
    TimePicker tp;
    Button submit, reset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        name = findViewById(R.id.EditName);
        submit = findViewById(R.id.confirm);
        reset = findViewById(R.id.reset);
        number = findViewById(R.id.EditNumber);
        size = findViewById(R.id.EditSize);
        smoking = findViewById(R.id.smoke);




        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if(name.getText().toString().trim().length() != 0 && number.getText().toString().trim().length() != 0 && size.getText().toString().trim().length() != 0) {

                    String Fullname = name.getText().toString().trim();
                    String num = number.getText().toString().trim();
                    String groupSize = size.getText().toString().trim();
                    int year = dp.getYear();
                    int month = dp.getMonth();
                    int day = dp.getDayOfMonth();
                    int hour = tp.getCurrentHour();
                    int min = tp.getCurrentMinute();


                    String smoke = "";
                    if (smoking.isChecked()) {
                        smoke = "yes";
                    } else {
                        smoke = "no";
                    }

                    String AftSub = String.format("Name: %s \nPhone Number: %d \nGroup Size: %d \nYear: %d \nMonth: %d \nDay: %d \nHour: $d \nMinute: %d", Fullname, num, groupSize
                            , year, month, day, hour, min);
                    Toast.makeText(MainActivity.this, AftSub, Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Please fill out all", Toast.LENGTH_LONG).show();
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");

                dp.updateDate(2020,5, 1 );
                tp.setCurrentMinute(30);
                tp.setCurrentHour(19);
                smoking.setChecked(false);

            }
        });




    }
}
