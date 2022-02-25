package com.turorials.onetimeactivity;

import static android.app.Activity.RESULT_OK;
import static com.firebase.ui.auth.AuthUI.getApplicationContext;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;


import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserProfile extends Fragment {
    private ImageView imgUser, change_img;
    private TextView tvUserName, tvUserMail;
    private Button btnSignOut;

    private StorageReference storageReference, storageReference2;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser user;
    private FirebaseStorage firebaseStorage;
    private GoogleSignInAccount signInAccount;
    private Uri imagreUri;

    private ExpandableListView listView;
    List<String> headers;
    List<Integer> images, subImage;
    Map<String, List<String>> subHeaders;


    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_user_profile, container, false);

        imgUser = view.findViewById(R.id.imgUser);
        change_img = view.findViewById(R.id.change_img);
        tvUserName = view.findViewById(R.id.tvUserName);
        tvUserMail = view.findViewById(R.id.tvUserMail);

        listView = view.findViewById(R.id.expandList);
        getData();
        ExpandListAdapter adapter = new ExpandListAdapter(getContext(), headers, subHeaders, images, subImage);
        listView.setAdapter(adapter);

        btnSignOut = view.findViewById(R.id.btnSignOut);
        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Log out");
                builder.setMessage("Are you sure do you want to quit?");
                builder.setCancelable(false);
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        FirebaseAuth.getInstance().signOut();
                        Intent intent = new Intent(getContext(), LoginPage.class);
                        startActivity(intent);
                        ((Activity)view.getContext()).finish();
                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });

        //choose image to set new profile pic
        change_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choosePic();
            }
        });

        firebaseAuth = FirebaseAuth.getInstance();
        user = firebaseAuth.getCurrentUser();
        signInAccount = GoogleSignIn.getLastSignedInAccount(getContext());

        //Display user name and email via TextView
        if (signInAccount != null) {
            tvUserName.setText(signInAccount.getDisplayName());
            tvUserMail.setText(signInAccount.getEmail());

            try {
                Glide.with(this).load(signInAccount.getPhotoUrl()).into(imgUser);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }//Display user info

        firebaseStorage = FirebaseStorage.getInstance();
        storageReference2 = firebaseStorage.getReference();

        //storageReference = FirebaseStorage.getInstance().getReference().child(user.getUid() + "/user_pic");

        //get image from firebase storage and set image to image view.
        storageReference = FirebaseStorage.getInstance().getReference().child("user_pic/" + user.getUid());
        try {
            final File file = File.createTempFile("user", "jpg");
            storageReference.getFile(file).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                    Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
                    imgUser.setImageBitmap(bitmap);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(getContext(), "No new pic found!", Toast.LENGTH_SHORT).show();
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }// get image from firebase storage


        return view;
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_user_profile);
//        getSupportActionBar().hide();
//
//        imgUser = findViewById(R.id.imgUser);
//        change_img = findViewById(R.id.change_img);
//        tvUserName = findViewById(R.id.tvUserName);
//        tvUserMail = findViewById(R.id.tvUserMail);
//
//        listView = findViewById(R.id.expandList);
//        getData();
//        ExpandListAdapter adapter = new ExpandListAdapter(this, headers, subHeaders, images, subImage);
//        listView.setAdapter(adapter);
//
//        btnSignOut = findViewById(R.id.btnSignOut);
//        btnSignOut.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                FirebaseAuth.getInstance().signOut();
//                Intent intent = new Intent(UserProfile.this, MainActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        });
//
//        //choose image to set new profile pic
//        change_img.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                choosePic();
//            }
//        });
//
//        firebaseAuth = FirebaseAuth.getInstance();
//        user = firebaseAuth.getCurrentUser();
//        signInAccount = GoogleSignIn.getLastSignedInAccount(this);
//
//        //Display user name and email via TextView
//        if (signInAccount != null){
//            tvUserName.setText(signInAccount.getDisplayName());
//            tvUserMail.setText(signInAccount.getEmail());
//
//            try {
//                Glide.with(this).load(signInAccount.getPhotoUrl()).into(imgUser);
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        }//Display user info
//
//        firebaseStorage = FirebaseStorage.getInstance();
//        storageReference2 = firebaseStorage.getReference();
//
//        //storageReference = FirebaseStorage.getInstance().getReference().child(user.getUid() + "/user_pic");
//
//        //get image from firebase storage and set image to image view.
//        storageReference = FirebaseStorage.getInstance().getReference().child("user_pic/" + user.getUid());
//        try {
//            final File file = File.createTempFile("user", "jpg");
//            storageReference.getFile(file).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
//                @Override
//                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
//                    Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
//                    imgUser.setImageBitmap(bitmap);
//                }
//            }).addOnFailureListener(new OnFailureListener() {
//                @Override
//                public void onFailure(@NonNull Exception e) {
//                    Toast.makeText(UserProfile.this, "No new pic found!", Toast.LENGTH_SHORT).show();
//                }
//            });
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }// get image from firebase storage
//
//    }

    //get photo from gallery and upload it to fb store
    private void choosePic() {

        Intent intent = new Intent();
        intent.setType("image/*").setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, 2022);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2022 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            imagreUri = data.getData();
            imgUser.setImageURI(imagreUri);
            uploadPicToFbStore();
        }
    }

    //upload chosen pic to firebase store
    private void uploadPicToFbStore() {
        StorageReference reference = storageReference2.child("user_pic/" + user.getUid());
        reference.putFile(imagreUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Toast.makeText(getContext(), "Uploading Success!", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getContext(), "Uploading Fails!", Toast.LENGTH_SHORT).show();
            }
        });

    }//upload chosen pic to fb store


    //This is for expandable list view.
    private void getData() {

        images = new ArrayList<>();
        images.add(R.drawable.setting);
        images.add(R.drawable.earth);

        subImage = new ArrayList<>();
        subImage.add(R.drawable.privacy);
        subImage.add(R.drawable.showdata);
        subImage.add(R.drawable.invite);
        subImage.add(R.drawable.dev);
        subImage.add(R.drawable.fb);
        subImage.add(R.drawable.youtube);


        headers = new ArrayList<>();
        headers.add("Setting & Privacy");
        headers.add("Communication");

        subHeaders = new HashMap<>();

        List<String> setting = new ArrayList<>();
        setting.add("Privacy Policy");
        setting.add("Show new data first");

        List<String> invite = new ArrayList<>();
        invite.add("Invite friends");
        invite.add("Developers");
        invite.add("Follow on Facebook");
        invite.add("Subscribe on YouTube");


        subHeaders.put(headers.get(0), setting);
        subHeaders.put(headers.get(1), invite);
        //subHeaders.put(headers.get(2), ourBlog);

    }


}