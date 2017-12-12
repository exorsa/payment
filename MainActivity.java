package com.example.pike.payment001;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.pike.payment001.helper.RegexHelper;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    String menu = "허니후라이드";
    int price = 12000;
    int piece = 5;
    String piece1 = String.valueOf(piece);
    String  total = String.valueOf(price*piece);
    TextView textview;
    TextView textView2, textView3, textView7, textView21, textView22, textView24;
    Button button1, button2;
    EditText editText1, editText2, editText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText)findViewById(R.id.editText1);
        editText2= (EditText)findViewById(R.id.editText2);
        editText3 = (EditText)findViewById(R.id.editText3);
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        textView2 = (TextView)findViewById(R.id.textView2);
        textview = (TextView)findViewById(R.id.textview);
        textView3 = (TextView)findViewById(R.id.textView3);
        textView7 = (TextView)findViewById(R.id.textView7);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

        textView2.setText(menu);
        textview.setText(Integer.toString(price) + "원");
        textView3.setText(piece1 + "개");
        textView7.setText(total + "원");

        editText1.requestFocus();

        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(editText1, 0);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:

                String address = editText1.getText().toString().trim();
                String phoneNum = editText2.getText().toString().trim();
                String memo = editText3.getText().toString().trim();

                RegexHelper helper = RegexHelper.getInstance();
                String msg = null;

                if (msg == null && !helper.isValue(address)){
                    msg = "주소를 입력해 주세요.";
                }
                if (msg == null && !helper.isValue(phoneNum)) {
                    msg = "휴대폰 번호를 입력해 주세요.";
                }
                if (msg == null && !helper.isCellPhone(phoneNum)) {
                    msg = "휴대폰 번호가 맞지 않습니다.";
                }
                if (msg != null){
                    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent(this, IdentifyActivity.class);   // 데이타 담아서 핸드폰 결제창으로 넘기기
                intent.putExtra("phoneNum", phoneNum);
                intent.putExtra("menu", menu);
                intent.putExtra("total", total);
                intent.putExtra("piece1", piece1);
                startActivity(intent);
                break;

            case R.id.button2:

                Intent intent1 = new Intent(this, PaymentActivity.class);
                intent1.putExtra("menu", menu);
                intent1.putExtra("total", total);
                intent1.putExtra("price", price);
                intent1.putExtra("piece1", piece1);
                startActivity(intent1);
                break;


        }

    }
}

