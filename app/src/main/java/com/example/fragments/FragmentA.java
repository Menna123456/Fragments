package com.example.fragments;

import android.app.Activity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;




public class FragmentA extends Fragment implements View.OnClickListener {
    Button button;
    private connection mCallback;

    // This is the interface that the Activity will implement
    // so that this Fragment can communicate with the Activity.
    public interface connection{
        public void sendText(String text);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_a_layout,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        button = (Button) getActivity().findViewById(R.id.button);
        button.setOnClickListener(this);

        if(savedInstanceState!=null)
        {
            mCallback = (MainActivity)getActivity();
        }

    }

    @Override
    public void onClick(View v) {

        String message = "Hello !!";
        mCallback.sendText(message);


    }


    // This method insures that the Activity has actually implemented our
    // listener and that it isn't null.
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof connection) {
            mCallback = (connection) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement connection ");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallback = null;
    }

}
