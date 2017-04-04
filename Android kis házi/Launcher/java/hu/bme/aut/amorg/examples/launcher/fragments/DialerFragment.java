package hu.bme.aut.amorg.examples.launcher.fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.devspark.robototextview.widget.RobotoButton;
import com.devspark.robototextview.widget.RobotoEditText;

import hu.bme.aut.amorg.examples.launcher.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DialerFragment extends Fragment {


    public DialerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_dialer, container, false);

        onButtonPressed(layout);

        final RobotoEditText callEditText = (RobotoEditText) layout.findViewById(R.id.callEditText);

        RobotoButton callButton = (RobotoButton) layout.findViewById(R.id.btn_call);
        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(
                        Intent.ACTION_CALL,
                        Uri.parse("tel:" + callEditText.getText())
                );
                startActivity(i);
            }


        });


        return layout;
    }

    private void onButtonPressed(View layout) {


        final RobotoEditText editText = (RobotoEditText) layout.findViewById(R.id.callEditText);

        RobotoButton btn_0 = (RobotoButton) layout.findViewById(R.id.btn_0);
        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "0");
            }

        });
        btn_0.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                editText.setText(editText.getText() + "+");
                return true;
            }

        });
        RobotoButton btn_1 = (RobotoButton) layout.findViewById(R.id.btn_1);
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "1");
            }

        });
        RobotoButton btn_2 = (RobotoButton) layout.findViewById(R.id.btn_2);
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "2");
            }

        });
        RobotoButton btn_3 = (RobotoButton) layout.findViewById(R.id.btn_3);
        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "3");
            }

        });
        RobotoButton btn_4 = (RobotoButton) layout.findViewById(R.id.btn_4);
        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "4");
            }

        });
        RobotoButton btn_5 = (RobotoButton) layout.findViewById(R.id.btn_5);
        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "5");
            }

        });
        RobotoButton btn_6 = (RobotoButton) layout.findViewById(R.id.btn_6);
        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "6");
            }

        });
        RobotoButton btn_7 = (RobotoButton) layout.findViewById(R.id.btn_7);
        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "7");
            }

        });
        RobotoButton btn_8 = (RobotoButton) layout.findViewById(R.id.btn_8);
        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "8");
            }

        });
        RobotoButton btn_9 = (RobotoButton) layout.findViewById(R.id.btn_9);
        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "9");
            }

        });
        RobotoButton btn_star = (RobotoButton) layout.findViewById(R.id.btn_star);
        btn_star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "*");
            }

        });
        RobotoButton btn_sharp = (RobotoButton) layout.findViewById(R.id.btn_sharp);
        btn_sharp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "#");
            }

        });
        ImageButton btn_BackSpace = (ImageButton) layout.findViewById(R.id.callBackSpaceButton);
        btn_BackSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int length = editText.getText().length();
                if (length > 0) {
                    editText.getText().delete(length - 1, length);
                }
            }

        });
        btn_BackSpace.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                int length = editText.getText().length();
                if (length > 0) {
                    editText.getText().delete(0, length);
                }
                return true;
            }
        });

    }
}
