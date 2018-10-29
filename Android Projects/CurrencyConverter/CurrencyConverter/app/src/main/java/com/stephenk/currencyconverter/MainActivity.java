package com.stephenk.currencyconverter;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Surface;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

//Author: Stephen Karpathakis
//App Name: Currency converter
//Build Version: 1.0
//Build Date: 11/15/2015

public class MainActivity extends ActionBarActivity {


    //Setup object variables/regular variables
    Spinner currencyFrom, currencyTo;
    EditText currencyFromField;
    TextView txtVResults;


    public void convert(View view) {

        //Get and set variables
        String conversionFrom = String.valueOf(currencyFrom.getSelectedItem());
        String conversionTo = String.valueOf(currencyTo.getSelectedItem());
        Double convertFromVal = 0.00;
        double result;
        boolean errors = true;

       //Check for errors if None set errors flag to 0
       String strConvertFromErrors = currencyFromField.getText().toString();

       if ( strConvertFromErrors.contentEquals("") || strConvertFromErrors.contentEquals("0") || strConvertFromErrors.contentEquals("0.00") || strConvertFromErrors.contentEquals("0.0") )
       {
           errors = true;
           Toast.makeText(getApplicationContext(), "Error - Please enter a number like: 1 or 1.3", Toast.LENGTH_SHORT).show();
       }
       else
       {
           convertFromVal = Double.parseDouble(currencyFromField.getText().toString());
           errors = false;
       }

       //PERFORM All Conversion
       if ( errors == false)
       {
            switch (conversionFrom) {
                case "$ US Dollars":

                    if (conversionTo == "$ US Dollars"){
                        convert(convertFromVal, 1.00 );
                        break;
                    }

                    if (conversionTo == "£ British Pounds"){
                        convert(convertFromVal, 0.66 );
                        break;
                    }

                    if (conversionTo == "€ EUR") {
                        convert(convertFromVal, 0.93 );
                        break;
                    }

                    if (conversionTo == "$ Mexican Peso's") {
                        convert(convertFromVal, 16.72 );
                        break;
                    }

                    if (conversionTo == "C$ Canadian Dollar") {
                        convert(convertFromVal, 1.33 );
                        break;
                    }

                    if (conversionTo == "¥ Japanese Yen") {
                        convert(convertFromVal, 122.48);
                        break;
                    }

                case "£ British Pounds":

                    if (conversionTo == "$ US Dollars") {
                        convert(convertFromVal, 1.52);
                        break;
                    }

                    if (conversionTo == "£ British Pounds") {
                        convert(convertFromVal, 1.0 );
                        break;
                    }

                    if (conversionTo == "€ EUR") {
                        convert(convertFromVal, 1.42);
                        break;
                    }

                    if (conversionTo == "$ Mexican Peso's") {
                        convert(convertFromVal, 25.57);
                        break;
                    }

                    if (conversionTo == "C$ Canadian Dollar") {
                        convert(convertFromVal, 2.03);
                        break;
                    }

                    if (conversionTo == "¥ Japanese Yen") {
                       convert(convertFromVal, 186.31);
                        break;
                    }

                case "€ EUR": //NOTE DONE
                    if (conversionTo == "$ US Dollars") {
                        convert(convertFromVal, 1.07);
                        break;
                    }

                    if (conversionTo == "£ British Pounds") {
                        convert(convertFromVal, .70 );
                        break;
                    }

                    if (conversionTo == "€ EUR") {
                       convert(convertFromVal, 1.0);
                        break;
                    }

                    if (conversionTo == "$ Mexican Peso's") {
                        convert(convertFromVal, 17.947);
                        break;
                    }

                    if (conversionTo == "C$ Canadian Dollar") {
                        convert(convertFromVal, 1.43);
                        break;
                    }

                    if (conversionTo == "¥ Japanese Yen") {
                        convert(convertFromVal, 131.29);
                        break;
                    }

                case "$ Mexican Peso's":
                    if (conversionTo == "$ US Dollars") {
                        convert(convertFromVal, 0.060);
                        break;
                    }

                    if (conversionTo == "£ British Pounds") {
                        convert(convertFromVal, 0.039);
                        break;
                    }

                    if (conversionTo == "€ EUR") {
                       convert(convertFromVal, 0.056);
                        break;
                    }

                    if (conversionTo == "$ Mexican Peso's") {
                        convert(convertFromVal, 1.0 );
                        break;
                    }

                    if (conversionTo == "C$ Canadian Dollar") {
                        convert(convertFromVal, 0.08);
                        break;
                    }

                    if (conversionTo == "¥ Japanese Yen") {
                        convert(convertFromVal, 7.32);
                        break;
                    }

                case "C$ Canadian Dollar":
                    if (conversionTo == "$ US Dollars") {
                        convert(convertFromVal, 0.75);
                        break;
                    }

                    if (conversionTo == "£ British Pounds") {
                        convert(convertFromVal, 0.49);
                        break;
                    }

                    if (conversionTo == "€ EUR") {
                        convert(convertFromVal, 0.7);
                        break;
                    }

                    if (conversionTo == "$ Mexican Peso's") {
                        convert(convertFromVal, 12.56);
                        break;
                    }

                    if (conversionTo == "C$ Canadian Dollar") {
                        convert(convertFromVal, 1.00 );
                        break;
                    }
                    if (conversionTo == "¥ Japanese Yen") {
                        convert(convertFromVal, 91.97);
                        break;
                    }

                case "¥ Japanese Yen":
                    if (conversionTo == "$ US Dollars") {
                        convert(convertFromVal, 0.0082);
                        break;
                    }

                    if (conversionTo == "£ British Pounds") {
                        convert(convertFromVal, 0.0054);
                        break;
                    }

                    if (conversionTo == "€ EUR") {
                        convert(convertFromVal, 0.0076);
                        break;
                    }

                    if (conversionTo == "$ Mexican Peso's") {
                        convert(convertFromVal, 0.14);
                        break;
                    }

                    if (conversionTo == "C$ Canadian Dollar") {

                        convert(convertFromVal, 0.011);
                        break;
                    }

                    if (conversionTo == "¥ Japanese Yen") {
                        convert(convertFromVal, 1.00 );
                        break;
                    }
            } //End of switch
        }//End of error checking
    }

    //Convert currency function
    public void convert(Double CurrentCurrency,double AmoutToMut )
    {
        //Create variables/selected item text from drop down
        double num;
        num = CurrentCurrency * AmoutToMut;
        String conversionFrom = String.valueOf(currencyFrom.getSelectedItem());
        String conversionTo = String.valueOf(currencyTo.getSelectedItem());

        //Create string builder for message
        StringBuilder resultMessage = new StringBuilder();;
        resultMessage.append(CurrentCurrency);
        resultMessage.append(' ');
        resultMessage.append(conversionFrom);
        resultMessage.append(" = ");
        resultMessage.append(num + " ");
        resultMessage.append(conversionTo);


        //Gets and displays result message
        txtVResults = (TextView) findViewById(R.id.txtViewResults);
        txtVResults.setText(resultMessage);
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);





            setContentView(R.layout.activity_main);



        //Setup and add drop down rates
       setupDropDownRates();
    }

    public void setupDropDownRates()
    {
        //Set Variables
        currencyFrom = (Spinner)findViewById(R.id.SpCurrencyFrom);
        currencyTo = (Spinner)findViewById(R.id.SpCurrencyTo);
        currencyFromField = (EditText) findViewById(R.id.editTextConvertFrom);
        txtVResults = (TextView) findViewById(R.id.txtViewResults);

        //Conversion rates
        // $1 = .66 $ US Dollars
        // $1 = 0.0026 £ British Pound
        // $1 = 0.93 € EUR
        // $1 = 16.83 $ Mexican Peso's
        // $1 = 1.33 Canadian Dollar
        // $1 = 0.0081 ¥ Japanese Yen

        //Create Conversion from List the set list adapter
        List<String> convertFromList = new ArrayList<String>();
        convertFromList.add("$ US Dollars");
        convertFromList.add("£ British Pounds");
        convertFromList.add("€ EUR");
        convertFromList.add("$ Mexican Peso's");
        convertFromList.add("C$ Canadian Dollar");
        convertFromList.add("¥ Japanese Yen");

        ArrayAdapter<String> convertFromAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, convertFromList);
        currencyFrom.setAdapter(convertFromAdapter);

        //Create Conversion To List the set list adapter
        List<String> convertToList = new ArrayList<String>();
        convertToList.add("$ US Dollars");
        convertToList.add("£ British Pounds");
        convertToList.add("€ EUR");
        convertToList.add("$ Mexican Peso's");
        convertToList.add("C$ Canadian Dollar");
        convertToList.add("¥ Japanese Yen");

        ArrayAdapter<String> convertToAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, convertToList);
        currencyTo.setAdapter(convertToAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
