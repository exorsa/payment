package com.example.pike.payment001;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.pike.payment001.helper.RegexHelper;

public class PaymentActivity extends AppCompatActivity implements View.OnClickListener, TextView.OnEditorActionListener{
    Button button1, button2, button3, button4, button5, button6, button7,
            button8, button9, button10, button11, button12, button14, button15;
    TextView textView2 = null;
    EditText editText = null;
    String total, piece1, menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        button10 = (Button) findViewById(R.id.button10);
        button11 = (Button) findViewById(R.id.button11);
        button12 = (Button) findViewById(R.id.button12);

        button14 = (Button) findViewById(R.id.button14);
        button15 = (Button) findViewById(R.id.button15);

        textView2 = (TextView) findViewById(R.id.textView2);
        editText = (EditText) findViewById(R.id.editText);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button10.setOnClickListener(this);
        button11.setOnClickListener(this);
        button12.setOnClickListener(this);

        button14.setOnClickListener(this);
        button15.setOnClickListener(this);
        textView2.setOnClickListener(this);
        editText.setOnClickListener(this);
        editText.setOnEditorActionListener(this);

        Intent fromIntent = getIntent();
        total=fromIntent.getStringExtra("total");
        menu=fromIntent.getStringExtra("menu");
        piece1=fromIntent.getStringExtra("piece1");
        Toast.makeText(this, piece1, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                textView2.setText("신한");
                editText.requestFocus();
                editText.setCursorVisible(true);
                showKeyBoard();
                break;
            case R.id.button2:
                textView2.setText("IBK기업");
                editText.requestFocus();
                editText.setCursorVisible(true);
                showKeyBoard();
                break;
            case R.id.button3:
                textView2.setText("하나");
                editText.requestFocus();
                editText.setCursorVisible(true);
                showKeyBoard();
                break;
            case R.id.button4:
                textView2.setText("비씨");
                editText.requestFocus();
                editText.setCursorVisible(true);
                showKeyBoard();
                break;
            case R.id.button5:
                textView2.setText("KB국민");
                editText.requestFocus();
                editText.setCursorVisible(true);
                showKeyBoard();
                break;
            case R.id.button6:
                textView2.setText("롯데");
                editText.requestFocus();
                editText.setCursorVisible(true);
                showKeyBoard();
                break;
            case R.id.button7:
                textView2.setText("하나(외환)");
                editText.requestFocus();
                editText.setCursorVisible(true);
                showKeyBoard();
                break;
            case R.id.button8:
                textView2.setText("씨티");
                editText.requestFocus();
                editText.setCursorVisible(true);
                showKeyBoard();
                break;
            case R.id.button9:
                textView2.setText("삼성");
                editText.requestFocus();
                editText.setCursorVisible(true);
                showKeyBoard();
                break;
            case R.id.button10:
                textView2.setText("NH농협");
                editText.requestFocus();
                editText.setCursorVisible(true);
                showKeyBoard();
                break;
            case R.id.button11:
                textView2.setText("우리BC");
                editText.requestFocus();
                editText.setCursorVisible(true);
                showKeyBoard();
                break;
            case R.id.button12:
                break;
            case R.id.button14:
                finish();
                break;
            case R.id.button15:

                String email = editText.getText().toString().trim();
                String card = textView2.getText().toString().trim();

                RegexHelper helper = RegexHelper.getInstance();
                String msg = null;

                if (msg == null && !helper.isValue(card)) {
                    Toast.makeText(this, "카드사를 선택해주세요.", Toast.LENGTH_SHORT).show();
                }
                if (msg == null && !helper.isValue(email)) {
                    msg = "이메일을 입력해주세요.";
                }
                if (msg == null && !helper.isEmail(email)) {
                    msg = "올바른 이메일주소를 입력하세요.";
                }
                if (msg != null){
                    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(this, CreditActivity.class);
                intent.putExtra("email", email);
                intent.putExtra("card", card);
                intent.putExtra("total", total);
                intent.putExtra("menu", menu);
                intent.putExtra("piece1", piece1);
                startActivity(intent);

                break;
        }
    }

    public void showKeyBoard(){     // 키보드 보이기
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(editText, 0);
    }

    public void disAppearKeyBoard(){    // 키보드 숨기기
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent keyEvent) {        // 키보드 완료버튼 눌렀을때 이벤트기능 부여하기
        if(v.getId()==R.id.editText && actionId == EditorInfo.IME_ACTION_DONE){
            String email = editText.getText().toString().trim();

            RegexHelper helper = RegexHelper.getInstance();
            String msg = null;

            if (msg == null && !helper.isValue(email)) {
                msg = "이메일을 입력해주세요.";
            }
            if (msg == null && !helper.isEmail(email)) {
                msg = "올바른 이메일주소를 입력하세요.";
            }
            if (msg != null){
                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
            }
        }
        return false;
    }
}
