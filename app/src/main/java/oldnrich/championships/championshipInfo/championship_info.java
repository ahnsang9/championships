package oldnrich.championships.championshipInfo;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import oldnrich.championships.R;

public class championship_info extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_championship_info);

        Intent intent = getIntent(); //데이터 수신
        Data data = (Data)intent.getSerializableExtra("data");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar) ;
        toolbar.setTitle(data.getName());
        setSupportActionBar(toolbar) ;

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView tx1 = (TextView)findViewById(R.id.text_view);
        TextView tx2 = (TextView)findViewById(R.id.text_view2);
        ImageView info_image = (ImageView)findViewById(R.id.info_image);

        tx1.setText(data.getExplaination());
        tx2.setText(data.getType());
        info_image.setImageResource(R.mipmap.info_temp_image);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{ //toolbar의 back키 눌렀을 때 동작
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
