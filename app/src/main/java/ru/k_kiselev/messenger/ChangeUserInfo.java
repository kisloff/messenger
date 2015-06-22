package ru.k_kiselev.messenger;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

/**
 * Created by Кирилл on 21.06.2015.
 */
public class ChangeUserInfo extends Activity implements View.OnClickListener {

    ImageView portrait;
    ImageButton takePhoto, addPhotoFromFile;
    EditText editNickname, editStatus;
    Button btnSave;

    File directory;
    final int TYPE_PHOTO = 1;
    final int REQUEST_CODE_PHOTO = 1;

    final String TAG = "myLogs";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_user_info);
        createDirectory();

        portrait = (ImageView)findViewById(R.id.iv_portrait);

        takePhoto = (ImageButton)findViewById(R.id.btn_take_photo);
        //takePhoto.setOnClickListener(onClickPhoto);
        addPhotoFromFile = (ImageButton)findViewById(R.id.btn_add_photo_form_file);
        addPhotoFromFile.setOnClickListener(this);

        editNickname = (EditText)findViewById(R.id.et_edit_nickname);
        editStatus = (EditText)findViewById(R.id.et_edit_status);

        btnSave = (Button)findViewById(R.id.btn_save);
        btnSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.btn_take_photo:
                //
                break;
            case R.id.btn_add_photo_form_file:
                //
                Context context = getApplicationContext();
                CharSequence text = "Foto from file";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                break;
            case R.id.btn_save:
                //

                break;

        }
    }

    public void onClickPhoto(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //intent.putExtra(MediaStore.EXTRA_OUTPUT, generateFileUri(TYPE_PHOTO));
        startActivityForResult(intent, REQUEST_CODE_PHOTO);
    }

    private Uri generateFileUri(int type) {
        File file = null;
        switch (type) {
            case TYPE_PHOTO:
                file = new File(directory.getPath() + "/" + "photo_"
                        + System.currentTimeMillis() + ".jpg");
                break;
        }
        Log.d(TAG, "fileName = " + file);
        return Uri.fromFile(file);
    }

    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent intent) {
        if (requestCode == REQUEST_CODE_PHOTO) {
            if (resultCode == RESULT_OK) {
                if (intent == null) {
                    Log.d(TAG, "Intent is null");
                } else {
                    Log.d(TAG, "Photo uri: " + intent.getData());
                    Bundle bndl = intent.getExtras();
                    if (bndl != null) {
                        Object obj = intent.getExtras().get("data");
                        if (obj instanceof Bitmap) {
                            Bitmap bitmap = (Bitmap) obj;
                            Log.d(TAG, "bitmap " + bitmap.getWidth() + " x "
                                    + bitmap.getHeight());
                            portrait.setImageBitmap(bitmap);
                        }
                    }
                }
            } else if (resultCode == RESULT_CANCELED) {
                Log.d(TAG, "Canceled");
            }
        }

    }

    private void createDirectory() {
        directory = new File(
                Environment
                        .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                "MyFolder");
        if (!directory.exists())
            directory.mkdirs();
    }
}
