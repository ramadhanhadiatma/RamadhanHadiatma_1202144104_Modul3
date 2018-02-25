package hadiatma.ramadhan.ramadhanhadiatama_1202144104_modul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText mUsername, mPassword; //deklarasi untuk EditText
    String username, password; //deklarasi objek string

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void loginMasuk(View view) {
        //method onclick pada button

        mUsername = (EditText)findViewById(R.id.username);
        mPassword = (EditText)findViewById(R.id.password);
        username = mUsername.getText().toString();
        password = mPassword.getText().toString();

        //kondisi jika username & password benar maka akan menampilkan toast dan masuk ke activity selanjutnya
        if ((username.contains("EAD"))&&(password.contains("MOBILE"))){
            Toast.makeText(this,"Login Sukses", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }else{
            //jika username dan password salah
            Toast.makeText(this, "Username Atau Password Salah", Toast.LENGTH_SHORT).show();
        }
    }
}
