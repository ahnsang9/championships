package oldnrich.championships;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    private Spinner spinner_year;
    private TextView years;
    private EditText rg_id, rg_pw, rg_name, rg_age;
    private Button btn_register_confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //spinner_year = (Spinner)findViewById(R.id.spinner_year);
        //years = (TextView)findViewById(R.id.years);
        rg_id = findViewById(R.id.rg_id);
        rg_pw = findViewById(R.id.rg_pw);
        rg_name = findViewById(R.id.rg_name);
        rg_age = findViewById(R.id.rg_age);
        btn_register_confirm = findViewById(R.id.btn_register_confirm);

        /*spinner_year.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                years.setText(parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });*/

        // 회원가입 버튼 클릭 시 수행
        btn_register_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //EditText에 현재 입력되어있는 값을 get해온다
                String userID = rg_id.getText().toString();
                String userPass = rg_pw.getText().toString();
                String userName = rg_name.getText().toString();
                //String userAge = years.getText().toString();
                int userAge = Integer.parseInt(rg_age.getText().toString());

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if (success) {//회원등록에 성공한 경우
                                Toast.makeText(getApplicationContext(),"회원가입이 완료 됐습니다.",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                startActivity(intent);
                            }
                            else { //회원등록에 실패한 경우
                                Toast.makeText(getApplicationContext(),"회원가입이 실패했습니다.",Toast.LENGTH_SHORT).show();
                                return;
                            }
                        }
                        catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                RegisterRequest registerRequest = new RegisterRequest(userID,userPass,userName,userAge,responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerRequest);
            }
        });


    }



}