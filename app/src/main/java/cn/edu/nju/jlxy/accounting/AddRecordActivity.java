package cn.edu.nju.jlxy.accounting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

public class AddRecordActivity extends AppCompatActivity implements View.OnClickListener {

    private String userInput=" ";
    private TextView amountText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);

        findViewById(R.id.key_1).setOnClickListener(this);
        findViewById(R.id.key_2).setOnClickListener(this);
        findViewById(R.id.key_3).setOnClickListener(this);
        findViewById(R.id.key_4).setOnClickListener(this);
        findViewById(R.id.key_5).setOnClickListener(this);
        findViewById(R.id.key_6).setOnClickListener(this);
        findViewById(R.id.key_7).setOnClickListener(this);
        findViewById(R.id.key_8).setOnClickListener(this);
        findViewById(R.id.key_9).setOnClickListener(this);
        findViewById(R.id.key_0).setOnClickListener(this);

        amountText=(TextView) findViewById(R.id.textViewDisplay);

        handleDot();
        handleBack();
        handleTypeChange();
        handleDone();

    }

    private void handleDot(){
        findViewById(R.id.key_dot).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("dot =","clicked");
                if (!userInput.contains(".")){
                    userInput+=".";
                }
            }
        });
    }

    private void handleTypeChange(){
        findViewById(R.id.key_category).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("cate =","changed");
            }
        });
    }

    private void handleBack(){
        findViewById(R.id.key_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userInput.length()>0){
                    userInput=userInput.substring(0,userInput.length()-1);
                }
                if (userInput.length()>0 && userInput.charAt(userInput.length()-1)=='.'){
                    userInput=userInput.substring(0,userInput.length()-1);
                }
                updateAmountText();
            }
        });
    }

    private void handleDone(){
        findViewById(R.id.key_done).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!userInput.equals("")){
                    double amount=Double.valueOf(userInput);
                }else {

                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        Button button=(Button)v;
        String string=((Button) v).getText().toString();
        Log.v("Number=",string);

        if (userInput.contains(".")){
            if (userInput.split("\\.").length==1||userInput.split("\\.")[1].length()<2){
                userInput+=string;
            }
        }else {
            userInput+=string;
        }

        updateAmountText();
       // Log.v("input",userInput);
    }

    private void updateAmountText(){
        if (userInput.contains(".")){
            if (userInput.split("\\.").length==1){
                amountText.setText(userInput+"00");
            }else if (userInput.split("\\.")[1].length()==1){
                amountText.setText(userInput+"0");
            }else if(userInput.split("\\.")[1].length()==2){
                amountText.setText(userInput);
            }
        }else {
            if (userInput.equals("")){
                amountText.setText("0.00");
            }else {
                amountText.setText(userInput+".00");
            }
        }
    }
}
