package com.turorials.onetimeactivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.telephony.CellSignalStrength;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;
import java.util.Map;

public class ExpandListAdapter extends BaseExpandableListAdapter {
    Context context;
    List<String> headers;
    Map<String, List<String>> subHeader;
    List<Integer> images, subImage;

    public ExpandListAdapter(Context context, List<String> headers, Map<String, List<String>> subHeader,
                             List<Integer> images, List<Integer> subImages) {
        this.context = context;
        this.headers = headers;
        this.subHeader = subHeader;
        this.images = images;
        this.subImage = subImages;
    }

    @Override
    public int getGroupCount() {
        return headers.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return subHeader.get(headers.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return headers.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return subHeader.get(headers.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        String text = (String) getGroup(i);

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.parnet_list_item, null);
        }

        TextView textView = view.findViewById(R.id.tvParentList);
        ImageView imageView = view.findViewById(R.id.imgParent);
        imageView.setImageResource(images.get(i));
        textView.setText(text);
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        String child = (String) getChild(i, i1);

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.child_list_item, null);
        }

        ImageView subImgV = view.findViewById(R.id.imgChild);

        if (i == 0){
            subImgV.setImageResource(subImage.get(i1));
        }
        else if (i == 1){
            subImgV.setImageResource(subImage.get(i1+2));
        }


        TextView textView = view.findViewById(R.id.tvChildrenList);
        textView.setText(child);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (i == 0){
                    //privacy and policy
                    if (i1 == 0){
                       context.startActivity(new Intent(context.getApplicationContext(), PrivacyActivity.class));
                    }
                    else if (i1 == 1){
                        //show new data first
                        Toast.makeText(context.getApplicationContext(), ""+ child, Toast.LENGTH_SHORT).show();
                    }
                }

                if (i == 1){
                    //invite friends
                    if (i1 == 0){
                        Intent intent = new Intent(Intent.ACTION_SEND);
                        intent.setType("text/plain");
                        String appUrl = "https://play.google.com/store/apps/details?id=com.codewall.learnprogramming";
                        intent.putExtra(Intent.EXTRA_TEXT, appUrl);
                        try{

                            intent.setPackage("com.facebook.katana");
                            context.startActivity(intent);
                        }catch (Exception e){
                            Toast.makeText(context.getApplicationContext(), ""+e, Toast.LENGTH_SHORT).show();
                        }
                    }
                    //developers
                    else if (i1 == 1){

                        context.startActivity(new Intent(context, Developer.class));
                    }
                    //follow on fb
                    else if (i1 == 2){

                        try {
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/108304764365518/"));
                            context.startActivity(intent);
                        }
                        catch (Exception e){
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/codeWallTechnologiesMyanmar"));
                            context.startActivity(intent);
                        }
                    }
                    //follow on youtube
                    else if (i1 == 3){

                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCAFmcX9pIO-eEJje1gtCdJA"));
                        context.startActivity(intent);
                    }

                }
            }
        });
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

}
