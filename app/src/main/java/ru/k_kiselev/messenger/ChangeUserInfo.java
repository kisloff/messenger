package ru.k_kiselev.messenger;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * Created by Кирилл on 21.06.2015.
 */
public class ChangeUserInfo extends Activity implements View.OnClickListener {

    ImageView portrait;
    ImageButton takePhoto, addPhotoFromFile;
    EditText editNickname, editStatus;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_user_info);

        portrait = (ImageView)findViewById(R.id.iv_portrait);

        takePhoto = (ImageButton)findViewById(R.id.btn_take_photo);
        takePhoto.setOnClickListener(this);
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
                break;
            case R.id.btn_save:
                //
                break;

        }
    }
}
