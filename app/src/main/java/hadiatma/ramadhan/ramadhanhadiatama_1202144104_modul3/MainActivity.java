package hadiatma.ramadhan.ramadhanhadiatama_1202144104_modul3;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //variabel yang akan didefinisikan
    private RecyclerView mRecyclerView;
    private ArrayList<Water> mWaterData;
    private WaterAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mendefinisikan recyclerview
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);

        //set layout
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,gridColumnCount));

        //mendefinisikan arraylist
        mWaterData = new ArrayList<>();

        //mendefinisikan adapter pada recuclerview
        mAdapter = new WaterAdapter(this, mWaterData);
        mRecyclerView.setAdapter(mAdapter);

        //mendapatkan data
        initializeData();
    }
    private void initializeData(){
        //mendapatkan data dari xml
        String[] waterList = getResources().getStringArray(R.array.water_titles);
        String[] waterInfo = getResources().getStringArray(R.array.water_info);
        TypedArray waterImageResources = getResources().obtainTypedArray(R.array.water_images);

        mWaterData.clear();

        //membuat arraylist
        for(int i=0;i<waterList.length;i++){
            mWaterData.add(new Water(waterList[i],waterInfo[i],waterImageResources.getResourceId(i,0)));
        }
        waterImageResources.recycle();
        mAdapter.notifyDataSetChanged();
    }
}
