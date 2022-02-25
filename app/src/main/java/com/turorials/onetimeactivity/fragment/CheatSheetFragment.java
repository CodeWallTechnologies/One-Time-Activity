package com.turorials.onetimeactivity.fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.turorials.onetimeactivity.R;
import com.turorials.onetimeactivity.adapters.MyAdapterCheatSheet;
import com.turorials.onetimeactivity.interfaces.ApiThirdInterface;
import com.turorials.onetimeactivity.model.ChildImagesModel;
import com.turorials.onetimeactivity.model.ShortCutModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class CheatSheetFragment extends Fragment {

    RecyclerView rv_short_cut;
    MyAdapterCheatSheet myAdapterCheatSheet;
    List<ShortCutModel> arrayList= new ArrayList<>();
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.activity_short_cut,container,false);
        rv_short_cut = view.findViewById(R.id.rv_short_cut);
//        int images1[] = {R.drawable.javascriptprojectidea,R.drawable.javascriptprojectidea,R.drawable.javascriptprojectidea,R.drawable.javascriptprojectidea,
//                R.drawable.javascriptprojectidea,};
//
//        int images2[] = {R.drawable.html1, R.drawable.html1, R.drawable.html1, R.drawable.html1, R.drawable.html1, R.drawable.html1, R.drawable.html1,};
//        int images3[] = {R.drawable.java1, R.drawable.java1, R.drawable.java2, R.drawable.pythoninterviewquesionspartone, R.drawable.weblesson2, R.drawable.html1, R.drawable.html1,};
//
//
//        ShortCutModel shortCutModel1 = new ShortCutModel();
//        shortCutModel1.setTitle("JavaScript project ideas for Beginners");
//        shortCutModel1.setImgResource(R.drawable.javascriptprojectidea);
////        shortCutModel1.setImages(imagesArrayList);
//        shortCutModel1.setImg(images1);
//
//
//
//        ShortCutModel shortCutModel2 = new ShortCutModel();
//        shortCutModel2.setTitle("Html for blah");
//        shortCutModel2.setImgResource(R.drawable.html1);
////        shortCutModel2.setImages(imagesArrayList1);
//        shortCutModel2.setImg(images2);
//
//
//
//
//        ShortCutModel shortCutModel3 = new ShortCutModel();
//        shortCutModel3.setTitle("JavaScript project ideas for Beginners");
//        shortCutModel3.setImgResource(R.drawable.java1);
////        shortCutModel3.setImages(imagesArrayList2);
//        shortCutModel3.setImg(images3);
//
////        ShortCutModel shortCutModel4 = new ShortCutModel();
////        ShortCutModel shortCutModel5 = new ShortCutModel();
//
//
//        shortCutModelArrayList = new ArrayList<>();
//        shortCutModelArrayList.add(shortCutModel1);
//        shortCutModelArrayList.add(shortCutModel2);
//        shortCutModelArrayList.add(shortCutModel3);
////        shortCutModelArrayList.add(shortCutModel4);
////        shortCutModelArrayList.add(shortCutModel5);
        LinearLayoutManager linearLayoutManagerNewFeed = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        rv_short_cut.setLayoutManager(linearLayoutManagerNewFeed);
        myAdapterCheatSheet = new MyAdapterCheatSheet(arrayList,getContext());
        rv_short_cut.setAdapter(myAdapterCheatSheet);
        rv_short_cut.setHasFixedSize(true);
        getData();
        return view;
    }

    public void getData() {
        // on below line we are creating a retrofit
        // builder and passing our base url
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://codewalltechnologies.com/")
                // on below line we are calling add Converter
                // factory as Scalar converter factory.
                .addConverterFactory(ScalarsConverterFactory.create())
                // at last we are building our retrofit builder.
                .build();
        // below line is to create an instance for our retrofit api class.
        ApiThirdInterface retrofitAPI = retrofit.create(ApiThirdInterface.class);
        Call<String> call = retrofitAPI.STRING_CALL6();
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful() ) {
                    try {
                        JSONArray jsonArray = new JSONArray(response.body());

                        parseArray(jsonArray);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }

        });
    }


    private void parseArray(JSONArray jsonArray) {
        arrayList.clear();
        for(int i= 0;i<jsonArray.length();i++){
            try {
                JSONObject jsonObject  = jsonArray.getJSONObject(i);
                // ShortCutModel data =  new ShortCutModel(jsonObject.getString("title"),jsonObject.getString("first_image_url"));
                ShortCutModel data =  new ShortCutModel();//obj
                data.setTitle(jsonObject.getString("title"));
                data.setImage_url(jsonObject.getString("first_image_url"));

                JSONArray childImages =  jsonObject.getJSONArray("img");
                List<ChildImagesModel>   newChildList = new ArrayList<>();

                for(int j = 0; j<childImages.length();j++){
                    JSONObject childObject = childImages.getJSONObject(j);
                    ChildImagesModel childImagesModel = new ChildImagesModel();
                    childImagesModel.setImage(childObject.getString("child_images"));
                    newChildList.add(childImagesModel);
                }

                data.setChildImagesModelList(newChildList);

                arrayList.add(data);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            MyAdapterCheatSheet myAdapterCheatSheet = new MyAdapterCheatSheet(arrayList, getContext());
            rv_short_cut.setAdapter(myAdapterCheatSheet);


        }
    }



}