package hadiatma.ramadhan.ramadhanhadiatama_1202144104_modul3;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.DrawableRes;

/**
 * Created by Adi Ramadhan on 25/02/2018.
 */

public class Water {
    //variabel yang mendefiniskan judul gambar dan hal lainnya
    private final String title;
    private final String info;
    private final int imageResource;

    static final String TITLE_KEY = "Title";
    static final String IMAGE_KEY = "Image Resource";

    Water(String title,String info, int imageResource){
        this.title=title;
        this.info=info;
        this.imageResource=imageResource;
    }

    String getTitle(){
        return title;
    }

    String getInfo(){
        return info;
    }

    int getImageResource(){
        return imageResource;
    }

    static Intent starter(Context context, String title, @DrawableRes int imageResId){
        Intent detailIntent = new Intent(context,DetailActivity.class);
        detailIntent.putExtra(TITLE_KEY, title);
        detailIntent.putExtra(IMAGE_KEY, imageResId);
        return detailIntent;
    }
}
