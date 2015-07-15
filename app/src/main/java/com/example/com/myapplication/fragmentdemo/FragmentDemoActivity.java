package com.example.com.myapplication.fragmentdemo;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.com.myapplication.R;

public class FragmentDemoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_demo);

        Button btSwitch = (Button) findViewById(R.id.fragment_switch_button);
        btSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AnotherRightFragment fragment = new AnotherRightFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.right_fragment_layout, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

    }

}
