package com.turorials.onetimeactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.turorials.onetimeactivity.adapters.MyAdapterNewFeeds;
import com.turorials.onetimeactivity.adapters.MyAdapterShortCut;
import com.turorials.onetimeactivity.model.Images;
import com.turorials.onetimeactivity.model.ShortCutModel;

import java.util.ArrayList;

public class ShortCutActivity extends AppCompatActivity {

    RecyclerView rv_short_cut;
    MyAdapterShortCut myAdapterShortCut;
    ArrayList<ShortCutModel> shortCutModelArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_short_cut);

        rv_short_cut = findViewById(R.id.rv_short_cut);


        //Images imagesArrayList = new Images[]{new Images(),new Images(),new Images()}
        ArrayList<Images> imagesArrayList = new ArrayList<>();
        imagesArrayList.add(new Images(R.drawable.reactcommoninterviewquestions));
        imagesArrayList.add(new Images(R.drawable.reactcommoninterviewquestions1));
        imagesArrayList.add(new Images(R.drawable.reactcommoninterviewquestions2));
        imagesArrayList.add(new Images(R.drawable.reactcommoninterviewquestions3));
        imagesArrayList.add(new Images(R.drawable.reactcommoninterviewquestions4));


        ArrayList<Images> imagesArrayList1 = new ArrayList<>();
        imagesArrayList.add(new Images(R.drawable.html1));
        imagesArrayList.add(new Images(R.drawable.html2));
        imagesArrayList.add(new Images(R.drawable.html3));
        imagesArrayList.add(new Images(R.drawable.html4));
        imagesArrayList.add(new Images(R.drawable.html5));
        imagesArrayList.add(new Images(R.drawable.html6));
        imagesArrayList.add(new Images(R.drawable.html7));

        ArrayList<Images> imagesArrayList2 = new ArrayList<>();
        imagesArrayList.add(new Images(R.drawable.java1));
        imagesArrayList.add(new Images(R.drawable.java2));
        imagesArrayList.add(new Images(R.drawable.java3));



        int images1[] = {R.drawable.javascriptprojectidea,R.drawable.javascriptprojectidea,R.drawable.javascriptprojectidea,R.drawable.javascriptprojectidea,
                R.drawable.javascriptprojectidea,};

        int images2[] = {R.drawable.html1, R.drawable.html1, R.drawable.html1, R.drawable.html1, R.drawable.html1, R.drawable.html1, R.drawable.html1,};
        int images3[] = {R.drawable.java1, R.drawable.java1, R.drawable.java2, R.drawable.pythoninterviewquesionspartone, R.drawable.weblesson2, R.drawable.html1, R.drawable.html1,};


        ShortCutModel shortCutModel1 = new ShortCutModel();
        shortCutModel1.setTitle("JavaScript project ideas for Beginners");
        shortCutModel1.setImgResource(R.drawable.javascriptprojectidea);
        shortCutModel1.setImages(imagesArrayList);
        shortCutModel1.setImg(images1);



        ShortCutModel shortCutModel2 = new ShortCutModel();
        shortCutModel2.setTitle("Html for blah");
        shortCutModel2.setImgResource(R.drawable.html1);
        shortCutModel2.setImages(imagesArrayList1);
        shortCutModel2.setImg(images2);




        ShortCutModel shortCutModel3 = new ShortCutModel();
        shortCutModel3.setTitle("JavaScript project ideas for Beginners");
        shortCutModel3.setImgResource(R.drawable.java1);
        shortCutModel3.setImages(imagesArrayList2);
        shortCutModel3.setImg(images3);

//        ShortCutModel shortCutModel4 = new ShortCutModel();
//        ShortCutModel shortCutModel5 = new ShortCutModel();


         shortCutModelArrayList = new ArrayList<>();
        shortCutModelArrayList.add(shortCutModel1);
        shortCutModelArrayList.add(shortCutModel2);
        shortCutModelArrayList.add(shortCutModel3);
//        shortCutModelArrayList.add(shortCutModel4);
//        shortCutModelArrayList.add(shortCutModel5);

        LinearLayoutManager linearLayoutManagerNewFeed = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        rv_short_cut.setLayoutManager(linearLayoutManagerNewFeed);
        myAdapterShortCut = new MyAdapterShortCut(shortCutModelArrayList,this);
        rv_short_cut.setAdapter(myAdapterShortCut);
        rv_short_cut.setHasFixedSize(true);

    }
}