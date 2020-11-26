package oldnrich.championships.login_register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import oldnrich.championships.MainActivity;
import oldnrich.championships.R;

public class LoginActivity extends AppCompatActivity {

    EditText et_id, et_pass;
    Button btn_login, btn_register;
    final static private String URL = "http://1.230.221.210:8080/user";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_id = findViewById(R.id.et_id);
        et_pass = findViewById(R.id.et_pass);
        btn_login = findViewById(R.id.btn_login);
        btn_register = findViewById(R.id.btn_register);
        RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);

        // 회원가입 버튼을 클릭시 수행
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //EditText에 현재 입력되어있는 값을 get해온다
                String userID = et_id.getText().toString();
                String userPass = et_pass.getText().toString();

                StringRequest stringRequest = new StringRequest(Request.Method.GET, URL + "?" + "userID=" + userID + "&" + "userPassword=" + userPass,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                try {
                                    JSONObject jsonObject = new JSONObject(response);
                                    JSONObject dataObject = jsonObject.getJSONObject("data");

                                    int userSeq = Integer.parseInt(dataObject.getString("userSeq"));

                                    if (userSeq > 0) {
                                        String userID = dataObject.getString("userID");
                                        String userPass = dataObject.getString("userPassword");

                                        Toast.makeText(getApplicationContext(), "로그인이 완료 됐습니다.", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                        intent.putExtra("userID", userID);
                                        intent.putExtra("userPass", userPass);
                                        startActivity(intent);
                                    } else { //로그인에 실패한 경우
                                        Toast.makeText(getApplicationContext(), "로그인에 실패했습니다.", Toast.LENGTH_SHORT).show();
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "로그인에 실패했습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
                queue.add(stringRequest);
                }
            });
        }
    }
