package com.example.atul.justjava;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */

    int quantity = 0;

    public void submitOrder(View view) {
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();
        EditText nameFeild = (EditText) findViewById(R.id.name_field);
        String name = nameFeild.getText().toString();
        int price = calculatePrice(hasWhippedCream, hasChocolate);
        displayMessage(createOrderSummery(price, hasWhippedCream, hasChocolate, name));
    }


    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View View) {
        quantity = quantity + 1;
        display(quantity);

    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View View) {
        quantity = quantity - 1;
        display(quantity);

    }

    /**
     * @param addWhippedCream is whether or not the user want whipped cream topping
     * @param addChocolate    is whether or not the user want chocolate topping
     * @return total price
     */
    private int calculatePrice(boolean addWhippedCream, boolean addChocolate) {
        int basePrice = 5;

        if(addWhippedCream) {
            basePrice += 1;
        }

        if(addChocolate) {
            basePrice += 2;
        }

        return quantity * basePrice;
    }

    /**
     * @param price           of the order
     * @param addWhippedCream is whether or not the user want whipped cream topping
     * @param addChocolate    is whether or not the user want chocolate topping
     * @param addName         is store customer name
     * @return text summery
     */

    private String createOrderSummery(int price, boolean addWhippedCream, boolean addChocolate, String addName) {
        String priceMessage = "Name: " + addName;
        priceMessage += "\nAdd Whipped Cream? " + addWhippedCream;
        priceMessage += "\nAdd Chocolate? "+ addChocolate;
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal: $ " + price;
        priceMessage += "\nThank You!";
        return priceMessage;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummeryTextView = (TextView) findViewById(R.id.order_summery_text_view);
        orderSummeryTextView.setText(message);
    }

}
