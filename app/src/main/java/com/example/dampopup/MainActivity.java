package com.example.dampopup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements DlgFragment.NoticeDialogListener {
    private Button btnFragment;
    private DlgFragment dlgFragment;


    // The dialog fragment receives a reference to this Activity through the
    // Fragment.onAttach() callback, which it uses to call the following methods
    // defined by the NoticeDialogFragment.NoticeDialogListener interface
    @Override
    public void onDialogBtn1Click(DlgFragment dialog) {
        // User touched the dialog's positive button
        Toast.makeText(this, "BOUTON 1 ", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDialogBtn2Click(DlgFragment dialog) {
        // User touched the dialog's negative button
        Toast.makeText(this, "BOUTON 2 ", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFragment=findViewById(R.id.btnFragment);
        btnFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dlgFragment =new DlgFragment();
                dlgFragment.show(getSupportFragmentManager(),"My  Fragment");
            }
        });
    }

}
