package com.example.pike.payment001;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.pike.payment001.helper.RegexHelper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CreditActivity extends AppCompatActivity implements View.OnClickListener, TextView.OnEditorActionListener {
    String card=null;
    TextView textView, textView2, textView6;
    Button button1, button2;
    EditText editText1, editText2, editText3, editText4, editText5,
            editText6, editText7, editText8, editText9, editText10;
    int maxLength1 = 3; //글자수 제한
    int maxLength2 = 2;
    String total, menu, piece1;
    long mNow;
    Date mDate;
    SimpleDateFormat mFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView6 = (TextView) findViewById(R.id.textView6);
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
        editText5 = (EditText) findViewById(R.id.editText5);
        editText6 = (EditText) findViewById(R.id.editText6);
        editText7 = (EditText) findViewById(R.id.editText7);
        editText8 = (EditText) findViewById(R.id.editText8);
        editText9 = (EditText) findViewById(R.id.editText9);
        editText10 = (EditText) findViewById(R.id.editText10);

        editText1.setOnEditorActionListener(this);
        editText2.setOnEditorActionListener(this);
        editText3.setOnEditorActionListener(this);
        editText4.setOnEditorActionListener(this);


        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

        Intent fromIntent = getIntent();
        total = fromIntent.getStringExtra("total");
        menu = fromIntent.getStringExtra("menu");
        card = fromIntent.getStringExtra("card");
        piece1 = fromIntent.getStringExtra("piece1");

        Toast.makeText(this, piece1, Toast.LENGTH_SHORT).show();

        textView.setText(card + "카드");
        textView2.setText(total + "원");
        textView6.setText(getTime());   // 현재시간 집어넣기

        InputFilter[] fArray = new InputFilter[1];
        InputFilter[] fArray1 = new InputFilter[1];

        fArray[0] = new InputFilter.LengthFilter(maxLength1);//글자수 제한(CVC,PW)
        fArray1[0] = new InputFilter.LengthFilter(maxLength2);
        editText9.setFilters(fArray);
        editText10.setFilters(fArray1);

        editText1.addTextChangedListener(new TextWatcher() {        // 포커스 자동화기능(글자수 제한을 이용) : 다음 버튼을 누르지 않아도 자동으로 넘어간다
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(editText1.length()==4){
                    editText2.requestFocus();
                }
            }
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void afterTextChanged(Editable editable) {}
        });
        editText2.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(editText2.length()==4){
                    editText3.requestFocus();
                }
            }
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void afterTextChanged(Editable editable) {}
        });
        editText3.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(editText3.length()==4){
                    editText4.requestFocus();
                }
            }
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void afterTextChanged(Editable editable) {}
        });
        editText4.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(editText4.length()==4){
                    editText5.requestFocus();
                }
            }
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void afterTextChanged(Editable editable) {}
        });
        editText5.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(editText5.length()==4){
                    editText6.requestFocus();
                }
            }
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void afterTextChanged(Editable editable) {}
        });
        editText6.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(editText6.length()==2){
                    editText7.requestFocus();
                }
            }
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void afterTextChanged(Editable editable) {}
        });
        editText7.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(editText7.length()==6){
                    editText8.requestFocus();
                }
            }
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void afterTextChanged(Editable editable) {}
        });
        editText8.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(editText8.length()==7){
                    editText9.requestFocus();
                }
            }
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void afterTextChanged(Editable editable) {}
        });
        editText9.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(editText9.length()==3){
                    editText10.requestFocus();
                }
            }
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void afterTextChanged(Editable editable) {}
        });

        editText10.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (editText10.getText().length()>1){
                    disAppearKeyBoard();
                }
            }
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void afterTextChanged(Editable editable) {}
        });
    }


    public void showKeyBoard(){     // 키보드 보이기
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(editText1, 0);
        imm.showSoftInput(editText2, 0);
        imm.showSoftInput(editText3, 0);
        imm.showSoftInput(editText4, 0);
        imm.showSoftInput(editText5, 0);
        imm.showSoftInput(editText6, 0);
        imm.showSoftInput(editText7, 0);
        imm.showSoftInput(editText8, 0);
        imm.showSoftInput(editText9, 0);
        imm.showSoftInput(editText10, 0);

    }
    public void disAppearKeyBoard(){    // 키보드 숨기기
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editText1.getWindowToken(), 0);
    }


    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent keyEvent) {        // 키보드 다음버튼 눌렀을때 이벤트기능 부여하기
                if (editText1.getText().length() < 4) {
                    Toast.makeText(this, "4자리를 입력하세요", Toast.LENGTH_SHORT).show();
                    editText1.requestFocus();
                }
                if (editText2.getText().length() < 4) {
                    Toast.makeText(this, "4자리를 입력하세요", Toast.LENGTH_SHORT).show();
                    editText2.requestFocus();
                }
                if (editText3.getText().length() < 4) {
                    Toast.makeText(this, "4자리를 입력하세요", Toast.LENGTH_SHORT).show();
                    editText3.requestFocus();
                }
                if (editText4.getText().length() < 4) {
                    Toast.makeText(this, "4자리를 입력하세요", Toast.LENGTH_SHORT).show();
                    editText4.requestFocus();
                }
        return false;
    }

    private String getTime(){       // 결제일시 설정
        mNow = System.currentTimeMillis();
        mDate = new Date(mNow);
        return mFormat.format(mDate);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                showKeyBoard();
                String cn1 = editText1.getText().toString().trim();
                String cn2 = editText2.getText().toString().trim();
                String cn3 = editText3.getText().toString().trim();
                String cn4 = editText4.getText().toString().trim();
                String cy = editText5.getText().toString().trim();
                String cm = editText6.getText().toString().trim();
                String cp1 = editText7.getText().toString().trim();
                String cp2 = editText8.getText().toString().trim();
                String cvc = editText9.getText().toString().trim();
                String pw = editText10.getText().toString().trim();


                RegexHelper helper = RegexHelper.getInstance();
                String msg = null;

                if (msg == null && !helper.isValue(cn1)) {
                    editText1.requestFocus();   // 빈칸일 경우 해당 위치로 커서 포커스 이동, 키보드올림
                    Toast.makeText(this, "카드번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
                    showKeyBoard();
                }
                if (msg == null && !helper.isCardNo(cn1)) {
                    editText1.requestFocus();   // 글자수 미달인경우에도 해당위치로 포커스 이동, 키보드올림
                    msg = "올바른 카드번호를 입력해주세요.";
                    showKeyBoard();
                }
                if (msg == null && !helper.isValue(cn2)) {
                    editText2.requestFocus();
                    msg = "카드번호를 입력해주세요.";
                    showKeyBoard();
                }
                if (msg == null && !helper.isCardNo(cn2)) {
                    editText2.requestFocus();
                    msg = "올바른 카드번호를 입력해주세요.";
                    showKeyBoard();
                }
                if (msg == null && !helper.isValue(cn3)) {
                    msg = "카드번호를 입력해주세요.";
                    editText3.requestFocus();
                    showKeyBoard();
                }
                if (msg == null && !helper.isCardNo(cn3)) {
                    msg = "올바른 카드번호를 입력해주세요.";
                    editText3.requestFocus();
                    showKeyBoard();
                }
                if (msg == null && !helper.isValue(cn4)) {
                    msg = "카드번호를 입력해주세요.";
                    editText4.requestFocus();
                    showKeyBoard();
                }
                if (msg == null && !helper.isCardNo(cn4)) {
                    msg = "올바른 카드번호를 입력해주세요.";
                    editText4.requestFocus();
                    showKeyBoard();
                }
                if (msg == null && !helper.isValue(cy)) {
                    msg = "카드 유효기간을 입력해주세요.";
                    editText5.requestFocus();
                    showKeyBoard();
                }
                if (msg == null && !helper.isVaidyear(cy)) {
                    msg = "올바른 유효기간을 입력해주세요.";
                    editText5.requestFocus();
                    showKeyBoard();
                }
                if (msg == null && !helper.isValue(cm)) {
                    msg = "카드 유효기간을 입력해주세요.";
                    editText6.requestFocus();
                }
                if (msg == null && !helper.isVaidmonth(cm)) {
                    msg = "올바른 유효기간을 입력해주세요.";
                    editText6.requestFocus();
                    showKeyBoard();
                }
                if (msg == null && !helper.isValue(cp1)) {
                    msg = "주민번호를 입력해주세요.";
                    editText7.requestFocus();
                    showKeyBoard();
                }
                if (msg == null && !helper.isJumin1(cp1)) {
                    msg = "올바른 주민번호를 입력해주세요.";
                    editText7.requestFocus();
                    showKeyBoard();
                }
                if (msg == null && !helper.isValue(cp2)) {
                    msg = "주민번호를 입력해주세요.";
                    editText8.requestFocus();
                    showKeyBoard();
                }
                if (msg == null && !helper.isJumin2(cp2)) {
                    msg = "올바른 주민번호를 입력해주세요.";
                    editText8.requestFocus();
                    showKeyBoard();
                }
                if (msg == null && !helper.isValue(cvc)) {
                    msg = "카드뒷면 CVC번호를 입력해주세요.";
                    editText9.requestFocus();
                    showKeyBoard();
                }
                if (msg == null && !helper.isCvc(cvc)) {
                    msg = "올바른 cvc번호를 입력하세요.";
                    editText9.requestFocus();
                    showKeyBoard();
                }
                if (msg == null && !helper.isValue(pw)) {
                    msg = "비밀번호를 입력해주세요.";
                    editText10.requestFocus();
                    showKeyBoard();
                }
                if (msg == null && !helper.isPw(pw)) {
                    msg = "올바른 비밀번호를 입력하세요.";
                    editText10.requestFocus();
                    showKeyBoard();
                }
                if (msg != null){
                    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent(this, ResultActivity.class);
                intent.putExtra("card", card);
                intent.putExtra("total", total);
                intent.putExtra("menu", menu);
                intent.putExtra("piece1", piece1);
                startActivity(intent);
                break;

            case R.id.button2:
                finish();
                break;
        }
    }
}
