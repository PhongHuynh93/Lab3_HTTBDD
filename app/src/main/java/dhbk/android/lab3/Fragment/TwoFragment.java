package dhbk.android.lab3.Fragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Random;

import dhbk.android.lab3.Activity.CalulatorActive;
import dhbk.android.lab3.R;

/**
 * Created by huynhducthanhphong on 3/21/16.
 */
public class TwoFragment extends Fragment {
    public TwoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_two, container, false);
        Button button = (Button) rootView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startIntent(v);
            }
        });
        return rootView;
    }

    public void startIntent (View v) {
        String baseAddress = "lab://lab3.com/payment";
        String address = String.format("%s?%s&%s&%s", baseAddress, "amount=500000", "discount=15", "code=MS-TAB2");
        Uri uri15percent = Uri.parse(address);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri15percent);
        startActivity(intent);
    }
}
