package hadiatma.ramadhan.ramadhanhadiatama_1202144104_modul3;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int LEVEL_1BATT = 0;
    private static final int LEVEL_2BATT = 1;
    private static final int LEVEL_3BATT = 2;
    private static final int LEVEL_4BATT = 3;
    private static final int LEVEL_5BATT = 4;
    private static final int LEVEL_6BATT = 5;
    private static final int LEVEL_7BATT = 6;
    private int count=0;
    private ImageView mImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initView();

        //Mendefinisikan view
        TextView sportsTitle = (TextView)findViewById(R.id.titleTextDetail);
        ImageView sportsImage = (ImageView)findViewById(R.id.waterImageDetail);

        //Mendapatkan Drawable
        Drawable drawable = ContextCompat.getDrawable
                (this,getIntent().getIntExtra(Water.IMAGE_KEY, 0));

        //Membuat placeholder
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.GRAY);

        //Membuat ukuran yang sama dengan size gambar
        if(drawable!=null) {
            gradientDrawable.setSize(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }

        //Set text
        sportsTitle.setText(getIntent().getStringExtra(Water.TITLE_KEY));

        //Load gambar
        Glide.with(this).load(getIntent().getIntExtra(Water.IMAGE_KEY,0))
                .placeholder(gradientDrawable).into(sportsImage);
    }

    private void initView() {
        mImage = (ImageView)findViewById(R.id.botol1);
        mImage.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.botol1:
                mImage.setImageLevel(count);
                count++;
                if(count>=7){
                    count=0;
                }
                break;
            default:
                break;
        }
    }
}
