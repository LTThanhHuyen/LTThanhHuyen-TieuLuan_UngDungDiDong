package com.example.tieuluan_uddd_cuahangmaytinh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tieuluan_uddd_cuahangmaytinh.adapter.CategoryAdapter;
import com.example.tieuluan_uddd_cuahangmaytinh.adapter.DiscountedProductAdapter;
import com.example.tieuluan_uddd_cuahangmaytinh.adapter.RecentlyViewedAdapter;
import com.example.tieuluan_uddd_cuahangmaytinh.model.Category;
import com.example.tieuluan_uddd_cuahangmaytinh.model.DiscountedProducts;
import com.example.tieuluan_uddd_cuahangmaytinh.model.RecentlyViewed;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import static com.example.tieuluan_uddd_cuahangmaytinh.R.drawable.*;

public class MainActivity extends AppCompatActivity {

    RecyclerView discountRecyclerView, categoryRecyclerView, recentlyViewedRecycler;
    DiscountedProductAdapter discountedProductAdapter;
    List<DiscountedProducts> discountedProductsList;

    CategoryAdapter categoryAdapter;
    List<Category> categoryList;

    RecentlyViewedAdapter recentlyViewedAdapter;
    List<RecentlyViewed> recentlyViewedList;

    TextView allCategory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        discountRecyclerView = findViewById(R.id.discountedRecycler);
        categoryRecyclerView = findViewById(R.id.categoryRecycler);
        allCategory = findViewById(R.id.allCategoryImage);
        recentlyViewedRecycler = findViewById(R.id.recently_item);


        allCategory.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, AllCategory.class);
            startActivity(i);
        });

        // adding data to model
        discountedProductsList = new ArrayList<>();
        discountedProductsList.add(new DiscountedProducts(1, discountberry));
        discountedProductsList.add(new DiscountedProducts(2, discount2));
        discountedProductsList.add(new DiscountedProducts(3, discount3));
        discountedProductsList.add(new DiscountedProducts(4, discount4));
        discountedProductsList.add(new DiscountedProducts(5, discountberry));
        discountedProductsList.add(new DiscountedProducts(6, discount2));

        // adding data to model
        categoryList = new ArrayList<>();
        categoryList.add(new Category(1, ic_home_fruits));
        categoryList.add(new Category(2, ic_home_fish));
        categoryList.add(new Category(3, ic_home_meats));
        categoryList.add(new Category(4, ic_home_veggies));
        categoryList.add(new Category(5, ic_home_fruits));
        categoryList.add(new Category(6, ic_home_fish));
        categoryList.add(new Category(7, ic_home_meats));
        categoryList.add(new Category(8, ic_home_veggies));

        // adding data to model
        recentlyViewedList = new ArrayList<>();
        recentlyViewedList.add(new RecentlyViewed("Asus", "Laptop ASUS mang đến khả năng di động tuyệt vời với thiết kế gọn nhẹ, bền bỉ và có hiệu suất tối ưu", "19999000", "1", "PC", card4, b4));
        recentlyViewedList.add(new RecentlyViewed("Dell", "Dell là dòng sản phẩm laptop mỏng nhẹ ấn tượng, không chỉ bền bỉ mà còn có thời lượng pin siêu lâu", "17999000", "1", "PC", card3, b3));
        recentlyViewedList.add(new RecentlyViewed("LG Gram", "LG gram là dòng sản phẩm laptop mỏng nhẹ ấn tượng, không chỉ bền bỉ mà còn có thời lượng pin siêu lâu", "15999000", "1", "PC", card2, b1));
        recentlyViewedList.add(new RecentlyViewed("Macbook", "Macbook là dòng sản phẩm laptop mỏng nhẹ ấn tượng, không chỉ bền bỉ mà còn có thời lượng pin siêu lâu", "₹ 39999000", "1", "PC", card1, b2));

        setDiscountedRecycler(discountedProductsList);
        setCategoryRecycler(categoryList);
        setRecentlyViewedRecycler(recentlyViewedList);

    }

    private void setDiscountedRecycler(List<DiscountedProducts> dataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        discountRecyclerView.setLayoutManager(layoutManager);
        discountedProductAdapter = new DiscountedProductAdapter(this,dataList);
        discountRecyclerView.setAdapter(discountedProductAdapter);
    }


    private void setCategoryRecycler(List<Category> categoryDataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        categoryRecyclerView.setLayoutManager(layoutManager);
        categoryAdapter = new CategoryAdapter(this,categoryDataList);
        categoryRecyclerView.setAdapter(categoryAdapter);
    }

    private void setRecentlyViewedRecycler(List<RecentlyViewed> recentlyViewedDataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recentlyViewedRecycler.setLayoutManager(layoutManager);
        recentlyViewedAdapter = new RecentlyViewedAdapter(this,recentlyViewedDataList);
        recentlyViewedRecycler.setAdapter(recentlyViewedAdapter);
    }
}