package com.example.dampopup;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DlgFragment extends androidx.fragment.app.DialogFragment {

    private Button btn1, btn2;

    /* The activity that creates an instance of this dialog fragment must
     * implement this interface in order to receive event callbacks.
     * Each method passes the DialogFragment in case the host needs to query it. */
    public interface NoticeDialogListener {
        public void onDialogBtn1Click(DlgFragment dialog);
        public void onDialogBtn2Click(DlgFragment dialog);
    }

    // Use this instance of the interface to deliver action events
    // pour nous c'est mainActivity
    NoticeDialogListener listener;

    // Override the Fragment.onAttach() method to instantiate the NoticeDialogListener
    @Override
    public void onAttach(Context parentContext) {
        super.onAttach(parentContext);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            listener = (NoticeDialogListener) parentContext;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException("Caller must implement NoticeDialogListener");
        }
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btn1=view.findViewById(R.id.btn1);
        btn2=view.findViewById(R.id.btn2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(getActivity().getApplicationContext(), "Bye", Toast.LENGTH_SHORT).show();
                dismiss();
                listener.onDialogBtn1Click(DlgFragment.this);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(getActivity().getApplicationContext(), "Bye", Toast.LENGTH_SHORT).show();
                dismiss();
                listener.onDialogBtn2Click(DlgFragment.this);
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.customview,container,false);
    }


}