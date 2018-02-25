package hadiatma.ramadhan.ramadhanhadiatama_1202144104_modul3;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class SplashActivity extends AppCompatActivity {
    //lama waktu splashscreen
    private static int splashInterval = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable(){

            public void run(){
                Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(i); //menghubungkan splashscreen ke layout berikutnya

                //jeda selesai splashscreen
                this.finish();
            }
            private void finish(){

            }
        },splashInterval);
    };
}
