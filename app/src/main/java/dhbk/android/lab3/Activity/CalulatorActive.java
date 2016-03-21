package dhbk.android.lab3.Activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import dhbk.android.lab3.Data.PaymentInfo;
import dhbk.android.lab3.R;

public class CalulatorActive extends AppCompatActivity {
    private double mAmount = 100000;
    private double mDiscount = 5.0;
    private String mCode = "MS-3333";
    private String mCurrencySymbol = "$";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calulator_active);
        setInputsFromUri();
        setInputFromExtras();
        calculateAndSetInputValues();
    }

    private void calculateAndSetInputValues() {
        PaymentInfo paymentInfo = new PaymentInfo(mAmount, mDiscount, mCode, mCurrencySymbol);

        TextView amount = (TextView) findViewById(R.id.lbamount);
        amount.setText(paymentInfo.getAmount());

        TextView discount = (TextView) findViewById(R.id.lbdiscount);
        discount.setText(paymentInfo.getmDiscount());

        TextView discountmoney = (TextView) findViewById(R.id.lbdiscountmoney);
        discountmoney.setText(paymentInfo.getmDiscountAmount());

        TextView code = (TextView) findViewById(R.id.lbcode);
        code.setText(paymentInfo.getmCode());

        TextView payment = (TextView) findViewById(R.id.lbpayment);
        payment.setText(paymentInfo.getPayment());

    }

    private void setInputFromExtras() {
        Intent intent = getIntent();
        Bundle info = intent.getExtras();
        if (info != null) {
            mAmount = info.getDouble("amount");
            mDiscount = info.getDouble("discount");
            mCode = info.getString("code");
        }
    }

    private void setInputsFromUri() {
        Uri uri = getIntent().getData();
        if (uri != null) {
            mAmount = getDoubleParam(uri, "amount");
            mDiscount = getDoubleParam(uri, "discount");
            mCode = uri.getQueryParameter("code");
        }
    }

    private double getDoubleParam(Uri uri, String queryParamName) {
        String rawValue = uri.getQueryParameter(queryParamName);
        double value = 0.0;
        value = Double.parseDouble(rawValue);

        return value;
    }
}
