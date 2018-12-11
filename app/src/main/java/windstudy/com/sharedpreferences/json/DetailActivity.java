package windstudy.com.sharedpreferences.json;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import windstudy.com.sharedpreferences.R;

import static windstudy.com.sharedpreferences.json.JsonDameActivity.EXTRA_BASE;
import static windstudy.com.sharedpreferences.json.JsonDameActivity.EXTRA_CATEGORY;
import static windstudy.com.sharedpreferences.json.JsonDameActivity.EXTRA_URL;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String imageUrl = intent.getStringExtra(EXTRA_URL);
        String categoryName = intent.getStringExtra(EXTRA_CATEGORY);
        int baseCount = intent.getIntExtra(EXTRA_BASE,0);
        ImageView imageView = findViewById(R.id.img_product);
        TextView tvCategoryName = findViewById(R.id.txt_product_name);
        TextView tvBaseCount = findViewById(R.id.txt_product_price);
//        Picasso.get().load(product.getImage()).into(holder.imgProduct);
        Picasso.get().load(imageUrl).into(imageView);
//        Picasso.get().load(imageUrl).fit().centerInside().into(imageView);

        tvCategoryName.setText(categoryName);
        tvBaseCount.setText(""+baseCount);
    }
}
