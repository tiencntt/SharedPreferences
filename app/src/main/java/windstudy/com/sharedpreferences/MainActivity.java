package windstudy.com.sharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtUserName, edtPassword;
    CheckBox cbRemenber;
    Button btnSave;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        sharedPreferences = getSharedPreferences("dataLogin",MODE_PRIVATE);
        //lay gia trị sharedpreferences
        edtUserName.setText(sharedPreferences.getString("taikhoan",""));
        edtPassword.setText(sharedPreferences.getString("matkhau",""));
        cbRemenber.setChecked(sharedPreferences.getBoolean("cheked",false));



    }
    public void init(){
        edtUserName = findViewById(R.id.edt_user_name);
        edtPassword = findViewById(R.id.edt_password);
        cbRemenber = findViewById(R.id.cb_remember);
        btnSave = findViewById(R.id.btn_save);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtUserName.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();
                if (username.equals("tientran") && password.equals("12345")) {
                    Toast.makeText(MainActivity.this, "Đăng Nhâp thành công", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                    if (cbRemenber.isChecked()) {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("taikhoan", username);
                        editor.putString("matkhau", password);
                        editor.putBoolean("cheked", true);
                        editor.commit();
                    } else {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove("taikhoan");
                        editor.remove("matkhau");
                        editor.remove("cheked");
                        editor.commit();
                    }

                } else {
                    Toast.makeText(MainActivity.this, "Lỗi đăng nhập", Toast.LENGTH_SHORT).show();

                }
            };
    });
}
}