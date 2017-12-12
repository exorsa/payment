package com.example.pike.payment001;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.example.pike.payment001.model.Payment;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener{
    Payment payment;
    TextView textView6, textView8, textView10, textView12,textView13,
            textView15, textView17, textView21, textView22, textView24;
    Button button1;
    String menu, total, card, No, piece1, name, phoneNum, addr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        button1 = (Button)findViewById(R.id.button1);
        textView12 = (TextView)findViewById(R.id.textView12);
        textView15 = (TextView)findViewById(R.id.textView15);
        textView13 = (TextView)findViewById(R.id.textView13) ;
        textView8 = (TextView)findViewById(R.id.textView8);
        textView17 = (TextView)findViewById(R.id.textView17);
        textView21 = (TextView)findViewById(R.id.textView21);
        textView22 = (TextView)findViewById(R.id.textView22);
        textView24 = (TextView)findViewById(R.id.textView24);

        button1.setOnClickListener(this);
        //Toast.makeText(this, No, Toast.LENGTH_SHORT).show();


        Intent fromIntent = getIntent();
        payment = (Payment) fromIntent.getSerializableExtra("payment");
        card = fromIntent.getStringExtra("card");
        No = fromIntent.getStringExtra("No");
        piece1 = fromIntent.getStringExtra("piece1");
        menu = fromIntent.getStringExtra("menu");
        total = fromIntent.getStringExtra("total");

        Toast.makeText(this, total+"원", Toast.LENGTH_SHORT).show();
        textView12.setText(menu+" "+ piece1+"개");
        textView13.setText(total+"원");
        textView15.setText(total+"원");
        textView17.setText(total+"원");
        textView21.setText(name);
        textView22.setText(phoneNum);
        textView24.setText(addr);

        if (card != null){    // 결제완료창 - '결제방식' 설정
            textView8.setText("신용카드 결제");
        }else if(No != null){
            textView8.setText("핸드폰 결제");
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.button1:
                Intent intent = new Intent(this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                break;
        }

    }
}
