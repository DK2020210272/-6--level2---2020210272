package fragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.level2.R;

public class BlankFragment extends Fragment {
    private View view;
    private TextView textView;
    public static BlankFragment newInstance(String label){
        Bundle args=new Bundle();
        args.putString("label",label);
        BlankFragment fragment=new BlankFragment();
        fragment.setArguments(args);
        return  fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_blank, container, false);
        textView=view.findViewById(R.id.tv_blank_fragment);


        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        String label=getArguments().getString("label");
        TextView text=getView().findViewById(R.id.tv_blank_fragment);
        text.setText(label);
        text.setBackgroundColor(Color.rgb((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
    }
}