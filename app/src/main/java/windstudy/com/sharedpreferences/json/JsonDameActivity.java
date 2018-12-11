package windstudy.com.sharedpreferences.json;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import windstudy.com.sharedpreferences.R;

public class JsonDameActivity extends AppCompatActivity implements ProductAdapter.OnItemClickListener {
    public static final String EXTRA_URL = "image";
    public static final String EXTRA_CATEGORY = "categoryName";
    public static final String EXTRA_BASE = "basePrice";


    ArrayList<Product> arrayData = new ArrayList<>();
    RecyclerView rvProduct;
    ProductAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_dame);
        init();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2,LinearLayoutManager.VERTICAL,false);
        rvProduct.setLayoutManager(gridLayoutManager);
        adapter = new ProductAdapter();
        adapter.arrData = arrayData;
        adapter.context = this;
        rvProduct.setAdapter(adapter);
        adapter.setOnItemClickListener(JsonDameActivity.this);


        String strListProduct = getStringFromAsset("list_product.json");
        Log.d("JSON","onCreate:" + strListProduct);
        // tao ra json tu string
        try {
            JSONObject jsonListProduct = new JSONObject(strListProduct);
            // Lam viec voi json

            // Lay status ra
            int status = jsonListProduct.getInt("status");
            String message = jsonListProduct.getString("message");
            JSONArray jsonArrData = jsonListProduct.getJSONArray("data");
            Log.d("JSON","onCreate:" + status);
            for (int i = 0; i < jsonArrData.length() ; i++) {
                JSONObject jsonObject = jsonArrData.getJSONObject(i);
                Product product = new Product();
                product.code = jsonObject.getInt("code");
                product.weight = jsonObject.getInt("weight");
                product.basePrice = jsonObject.getInt("basePrice");
                product.conversionValue = jsonObject.getInt("conversionValue");
                product.id = jsonObject.getInt("id");
                product.categoryName = jsonObject.getString("categoryName");
                product.image = jsonObject.getString("image");
                product.createdDate = jsonObject.getString("createdDate");
                product.name = jsonObject.getString("name");
                arrayData.add(product);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    void init(){
        rvProduct = findViewById(R.id.rv_product);
    }


    //Lay file tu asset ra(nang ve java thao tac voi file)
    private String getStringFromAsset(String fileName){
        String text = "";
        try{
            InputStream inputStream = getAssets().open(fileName);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            text = new String(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(JsonDameActivity.this, DetailActivity.class);
        Product clickItem = arrayData.get(position);
        intent.putExtra(EXTRA_URL, clickItem.getImage());
        intent.putExtra(EXTRA_CATEGORY, clickItem.getCategoryName());
        intent.putExtra(EXTRA_BASE, clickItem.getBasePrice());
        startActivity(intent);
    }


    // Convert ve kieu json


    //Thao ta voi json
}
