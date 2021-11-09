package com.example.makharij_al_huroof.Layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.makharij_al_huroof.Models.Quiz;
import com.example.makharij_al_huroof.R;

public class Quiz_page extends AppCompatActivity {

    String[] question={"There are 3 diacritics are present in the word رَحْمٰن?",
    "?خ,ه letters originate from throat",
    "?فَتْحَة is a small diagonal line placed above a letter",
    "There are 17 Makhārij (مخارج Emission) points are require to correctly read Quran?",
    "?ق ك letters sound similar"};
    Quiz[] data=new Quiz[question.length];
    int score=0,i=0;
    TextView que,total;
    Button ok,no,share;

    Boolean[] answers={true,true,true,true,false};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_page);
        for(int j=0;j<answers.length;j++){
            data[j]=new Quiz(question[j],answers[j]);
        }
        que=findViewById(R.id.question);
        que.setText(data[0].question);
        ok=findViewById(R.id.ok);
        no=findViewById(R.id.no);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i<data.length){
                    que.setText(data[i].question);
                    if(data[i].answer){
                        score++;
                    }
                    i++;
                }
                if(i==data.length){
                    total=findViewById(R.id.score);
                    total.setText("Your Total Score is : "+score);
                }
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i<data.length){
                    que.setText(data[i].question);
                    if(!data[i].answer){
                        score++;
                    }
                    i++;
                }
                if(i==data.length){
                    total=findViewById(R.id.score);
                    total.setText("Your Total Score is : "+score);
                }
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i==data.length){
                    Intent i=new Intent(Intent.ACTION_SEND);
                    startActivity(i);
                }else{
                    Toast.makeText(Quiz_page.this, "Complete Quiz to Share Score", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}