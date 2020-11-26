package oldnrich.championships.championshipInfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import oldnrich.championships.R;

public class championship_info extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_championship_info);

        TextView tx1 = (TextView)findViewById(R.id.text_view);
        TextView tx2 = (TextView)findViewById(R.id.text_view2);

        Intent intent = getIntent(); //데이터 수신

        String title = intent.getExtras().getString("title");
        String type = intent.getExtras().getString("type");
        tx1.setText(title);
        tx2.setText(type);
    }
}