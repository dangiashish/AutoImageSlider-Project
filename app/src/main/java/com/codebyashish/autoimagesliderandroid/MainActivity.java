package com.codebyashish.autoimagesliderandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.codebyashish.autoimageslider.AutoImageSlider;
import com.codebyashish.autoimageslider.Enums.ImageActionTypes;
import com.codebyashish.autoimageslider.Enums.ImageAnimationTypes;
import com.codebyashish.autoimageslider.Enums.ImageScaleType;
import com.codebyashish.autoimageslider.ExceptionsClass;
import com.codebyashish.autoimageslider.Interfaces.ItemsListener;
import com.codebyashish.autoimageslider.Models.ImageSlidesModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  implements ItemsListener {

    ItemsListener listener;
    ArrayList<ImageSlidesModel> autoImageList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listener = this;
        AutoImageSlider autoImageSlider = findViewById(R.id.autoImageSlider);
        try {
            autoImageList.add(new ImageSlidesModel("https://as1.ftcdn.net/v2/jpg/05/35/47/38/1000_F_535473874_OWCa2ohzXXNZgqnlzF9QETsnbrSO9pFS.jpg", "title 1"));
            autoImageList.add(new ImageSlidesModel("https://as1.ftcdn.net/v2/jpg/05/29/37/22/1000_F_529372232_2Z75XLUgwHQQmtsgeWwGdpdCx4inCPbP.jpg", "title 2"));
            autoImageList.add(new ImageSlidesModel(R.drawable.my_wallpaper, "title 3"));
            autoImageSlider.setImageList(autoImageList, ImageScaleType.FIT);
            autoImageSlider.setSlideAnimation(ImageAnimationTypes.ZOOM_IN);
        } catch (ExceptionsClass e) {
            throw new RuntimeException(e);
        }
        autoImageSlider.onItemClickListener(listener);
    }

    @Override
    public void onItemChanged(int position) {

    }

    @Override
    public void onTouched(ImageActionTypes actionTypes, int position) {

    }

    @Override
    public void onItemClicked(int position) {
        ImageSlidesModel model = autoImageList.get(position);
        Toast.makeText(this, "Clicked on " + model.getTitle(), Toast.LENGTH_SHORT).show();

    }
}