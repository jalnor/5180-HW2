package com.example.gameon.areacalculator;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView initialShape = findViewById(R.id.shapeId);
        initialShape.setTextColor(getResources().getColor(R.color.error));
        initialShape.setText("Please select a shape to begin");

        // This onclicklistener resets length 1 error when user clicks inside text area
        findViewById(R.id.length1Input).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextInputLayout l3 = findViewById(R.id.textInputLayout2);
                l3.setError("");
            }
        });
        // This onclicklistener resets length 2 error when user clicks inside text area
        findViewById(R.id.length2Input).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextInputLayout l4 = findViewById(R.id.textInputLayout3);
                l4.setError("");
            }
        });
        /*
         * This onclicklistener resets length 2 text input visibility,
         * length 2 label visibility, resets length 1 label if coming from circle,
         * resets text color in shape textview in case had error
         */
        findViewById(R.id.imageView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextInputLayout l4 = findViewById(R.id.textInputLayout3);
                l4.setVisibility(v.VISIBLE);
                TextView lengthLabel1 = findViewById(R.id.length1Id);
                lengthLabel1.setText("Length 1:");
                TextView lengthLabel = findViewById(R.id.length2Id);
                lengthLabel.setVisibility(v.VISIBLE);
                TextView shape = findViewById(R.id.shapeId);
                shape.setTextColor(getResources().getColor(R.color.colorPrimary));
                shape.setText("Triangle");
                TextView results = findViewById(R.id.resultsId);
                results.setText("");

            }
        });
        /*
         * This onclicklistener hides length 2 text input,
         * hides length 2 label,
         * resets text color in shape textview in case had error
         */
        findViewById(R.id.imageView2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextInputLayout l4 = findViewById(R.id.textInputLayout3);
                TextView lengthLabel = findViewById(R.id.length2Id);
                lengthLabel.setVisibility(v.INVISIBLE);
                l4.setVisibility(v.INVISIBLE);
                TextView shape = findViewById(R.id.shapeId);
                shape.setTextColor(getResources().getColor(R.color.colorPrimary));
                shape.setText("Square");
                TextView results = findViewById(R.id.resultsId);
                results.setText("");

            }
        });
        /*
         * This onclicklistener hides length 2 text input,
         * hides length 2 label, changes length 1 label text to radius,
         * resets text color in shape textview in case had error
         */
        findViewById(R.id.imageView3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextInputLayout l4 = findViewById(R.id.textInputLayout3);
                l4.setVisibility(v.INVISIBLE);
                TextView lengthLabel2 = findViewById(R.id.length2Id);
                lengthLabel2.setVisibility(v.INVISIBLE);
                TextView lengthLabel1 = findViewById(R.id.length1Id);
                lengthLabel1.setText("Radius:");
                TextView shape = findViewById(R.id.shapeId);
                shape.setTextColor(getResources().getColor(R.color.colorPrimary));
                shape.setText("Circle");
                TextView results = findViewById(R.id.resultsId);
                results.setText("");

            }
        });
        /*
         * This onclicklistener gets the various inputs and performs
         * error checking and handling before calculating the area of the
         * specified shape
         */
        findViewById(R.id.btnCalc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                TextInputLayout l3 = findViewById(R.id.textInputLayout2);
                TextInputLayout l4 = findViewById(R.id.textInputLayout3);
                TextView typeOfShape = findViewById(R.id.shapeId);

                TextView area = findViewById(R.id.resultsId);

                Log.d("Shape", "shape field is " + !typeOfShape.getText().toString().isEmpty() + " Length1 " + !l3.getEditText().getText().toString().isEmpty());

                if ( !typeOfShape.getText().toString().isEmpty() && !l3.getEditText().getText().toString().isEmpty() ) {

                    if ( typeOfShape.getText().toString() == "Triangle" ) {


                        if ( !l4.getEditText().getText().toString().isEmpty() ) {

                            double length1 = Double.parseDouble(l3.getEditText().getText().toString());
                            double length2 = Double.parseDouble(l4.getEditText().getText().toString());
                            double result = (.5 * length2) * length1;

                            area.setText(Double.toString(result));

                        } else {


                            Toast.makeText(getApplicationContext(), getString(R.string.tInput2_error) , Toast.LENGTH_SHORT).show();

                        }

                    } else {

                        if ( !l3.getEditText().getText().toString().isEmpty() ) {

                            double length1 = Double.parseDouble(l3.getEditText().getText().toString());

                            if (typeOfShape.getText().toString() == "Square") {

                                double result = length1 * length1;
                                area.setText(Double.toString(result));

                            } else {

                                double result = 3.1416 * length1 * length1;
                                area.setText(Double.toString(result));

                            }

                        } else {

                            Toast.makeText(getApplicationContext(), getString(R.string.tInput1_error), Toast.LENGTH_SHORT).show();

                        }
                    }
                } else {

                    if ( typeOfShape.getText().toString().isEmpty() && l3.getEditText().getText().toString().isEmpty() ) {

                        Toast.makeText(getApplicationContext(), getString(R.string.tv_shape) , Toast.LENGTH_SHORT).show();
                        Toast.makeText(getApplicationContext(), getString(R.string.tInput1_error) , Toast.LENGTH_SHORT).show();

                    } else if ( typeOfShape.getText().toString().isEmpty() ) {

                        Toast.makeText(getApplicationContext(), getString(R.string.tv_shape) , Toast.LENGTH_SHORT).show();

                    } else if ( l3.getEditText().getText().toString().isEmpty() ){

                        Toast.makeText(getApplicationContext(), getString(R.string.tInput1_error) , Toast.LENGTH_SHORT).show();

                    }

                }
            }
        });
        /*
         * This onclicklistener resets all input and textview fields
         */
        findViewById(R.id.btnCancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextInputLayout l3 = findViewById(R.id.textInputLayout2);
                TextInputLayout l4 = findViewById(R.id.textInputLayout3);
                TextView shape = findViewById(R.id.shapeId);
                TextView area = findViewById(R.id.resultsId);


                l3.getEditText().setText("");
                l4.getEditText().setText("");
                shape.setText("");
                area.setText("");
            }
        });


    }
}