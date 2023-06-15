package si.uni_lj.fe.tnuv.plant;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.time.LocalDate;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UrnikFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UrnikFragment extends Fragment implements CalendarAdapter.OnItemListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public UrnikFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UrnikFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UrnikFragment newInstance(String param1, String param2) {
        UrnikFragment fragment = new UrnikFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_urnik, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        loadFragment(new MesecFragment());

        Button button1 = view.findViewById(R.id.btn_mesec);
        Button button2 = view.findViewById(R.id.btn_teden);
        Button button3 = view.findViewById(R.id.btn_dan);

        // Set onClickListeners for your buttons
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new MesecFragment());
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new TedenFragment());
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new DanFragment());
            }
        });
    }

    private void loadFragment(Fragment fragment) {
        // create a FragmentManager
        FragmentManager fm = getFragmentManager();
        // create a FragmentTransaction to begin the transaction and replace the Fragment
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        // replace the FrameLayout with new Fragment
        fragmentTransaction.replace(R.id.flUrnikFrameFragment, fragment);
        fragmentTransaction.commit(); // save the changes
    }

    @Override
    public void onItemClick(int position, LocalDate date) {

    }
}


