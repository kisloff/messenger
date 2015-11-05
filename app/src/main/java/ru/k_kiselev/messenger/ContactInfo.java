package ru.k_kiselev.messenger;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ContactInfo extends Activity {

    ImageView ivPortrait;
    TextView nickname, status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_info);

        ivPortrait = (ImageView)findViewById(R.id.iv_portrait);
        nickname = (TextView)findViewById(R.id.lbl_nickname);
        status = (TextView)findViewById(R.id.lbl_status);

        //temporary
        ivPortrait.setImageResource(R.drawable.ic_drawer);
    }
}
