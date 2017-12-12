package com.example.pike.payment001;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.pike.payment001.model.Payment;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class IdentifyActivity extends AppCompatActivity implements View.OnClickListener {
    String phoneNum; // 넘겨받은 값 저장
    String message = "";
    Payment payment;    // DTO
    TextView textView3, textView5, textView7;
    EditText editText1, editText2;
    Button button1, button2, button3;
    SmsManager sms;  // 문자메시지 관리객체
    Random random = new Random();
    public String No = null;
    long mNow;
    Date mDate;
    String menu;
    String piece1;
    String total;

    SimpleDateFormat mFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identify);

        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        textView3 = (TextView)findViewById(R.id.textView3);
        textView5 = (TextView)findViewById(R.id.textView5);
        textView7 = (TextView)findViewById(R.id.textView7);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);

        sms = SmsManager.getDefault();

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);

        Intent fromIntent = getIntent();        // 인텐트로 메인에서 입력한 휴대폰번호 전달받기
        payment = (Payment) fromIntent.getSerializableExtra("payment");
        menu = fromIntent.getStringExtra("menu");
        piece1 = fromIntent.getStringExtra("piece1");
        total = fromIntent.getStringExtra("total");
        phoneNum = fromIntent.getStringExtra("phoneNum");

        Toast.makeText(this, piece1, Toast.LENGTH_SHORT).show();

        textView3.setText(getTime());
        textView5.setText(menu+" x "+ piece1);
        textView7.setText(total+"원");

        editText1.setText(phoneNum);

        permissionCheck();
    }

    private String getTime(){       // 결제일시 설정
        mNow = System.currentTimeMillis();
        mDate = new Date(mNow);
        return mFormat.format(mDate);
    }

    private void permissionCheck() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.SEND_SMS)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.SEND_SMS}, 100);
            }
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                phoneNum = editText1.getText().toString().trim();
                makeRandomNo();
                message = "본인 인증번호는 "+ No +"입니다."+"\r\n"+"정확히 입력해주세요";

                sms.sendTextMessage(phoneNum, null, message, null, null);

                editText2.requestFocus();

                Timer timer = new Timer();
                timer.schedule(new TimerTask(){
                    @Override
                    public void run() {
                        showKeyBoard();
                    }
                },6000);        // 인증받기 버튼 누른후 3초 뒤에 키패드 올라오게 했음

                Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
                break;

            case R.id.button2:
                disAppearKeyBoard();

                if (String.valueOf(editText2.getText()).equals(No)){
                    showAlertDialog(); // 다이얼로그 생성객체
                    button2.setText("인증완료");
                }else{
                    Toast.makeText(this, "인증번호가 맞지 않습니다", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.button3:
                if(String.valueOf(editText2.getText()).equals(No)){
                    button3.setText("결제완료");
                    Intent intent = new Intent(this, ResultActivity.class);
                    intent.putExtra("No", No);
                    intent.putExtra("menu", menu);
                    intent.putExtra("total", total);
                    intent.putExtra("piece1", piece1);
                    startActivity(intent);
                    Toast.makeText(getApplication(), "결제가 완료되었습니다.", Toast.LENGTH_LONG).show();

                    message = total+"원 결제가 완료되었습니다.";

                    sms.sendTextMessage(phoneNum, null, message, null, null);

                }else{
                    showAlertDialog1();
                }

                break;
        }
    }

    private void makeRandomNo() {     //난수함수

        String result="";

        result = String .valueOf(random.nextInt(9999-1000)+1000);
        No = result;
    }


    private void showAlertDialog() { // 다이얼로그 생성객체
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("알림");
        builder.setMessage("인증확인 되었습니다.");
        builder.setIcon(R.mipmap.ic_launcher);  //백키 눌렀을때 창이 안닫히도록함
        builder.setCancelable(false);

        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() { //확인버튼추가
            @Override
            public void onClick(DialogInterface dialog, int which) {//이벤트 정의
                Toast.makeText(getApplication(), "결제버튼을 누르시면 완료됩니다.",
                        Toast.LENGTH_LONG).show();
            }
        });
        builder.create();  // 설정한 정보로 창을 생성
        builder.show();   // 창을 화면에 구현
    }
    private void showAlertDialog1() { // 다이얼로그 생성객체
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("알림");
        builder.setMessage("인증번호를 입력하세요.");
        builder.setIcon(R.mipmap.ic_launcher);  //백키 눌렀을때 창이 안닫히도록함
        builder.setCancelable(false);

        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() { //확인버튼추가
            @Override
            public void onClick(DialogInterface dialog, int which) {//이벤트 정의
            }
        });
        builder.create();  // 설정한 정보로 창을 생성
        builder.show();   // 창을 화면에 구현
    }
    public void showKeyBoard() {     // 키보드 보이기
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(editText2, 0);
    }

    public void disAppearKeyBoard(){    // 키보드 숨기기
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editText2.getWindowToken(), 0);
    }
}
