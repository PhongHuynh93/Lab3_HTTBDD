package dhbk.android.lab3.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.ButtonBarLayout;
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
public class OneFragment extends Fragment {

    public OneFragment() {
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
        View rootView = inflater.inflate(R.layout.fragment_one, container, false);
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
        Random random = new Random();
        double discount = 0.25 * (1 + random.nextInt(60));
        Bundle bundle = createBundle(discount);
        Intent intent = new Intent(getActivity(), CalulatorActive.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private Bundle createBundle(double discount) {
        Random random = new Random();
        double amount = 30000 * (1 + random.nextInt(10));

        String code = "MS-" + 100 * random.nextInt(100);
        Bundle info = new Bundle();
        info.putDouble("amount", amount);
        info.putDouble("discount", discount);
        info.putString("code", code);
        return info;
    }
}
