package dhbk.android.lab3.Data;

/**
 * Created by Thien Nhan on 3/7/2016.
 */
public class PaymentInfo {
    private static final long serialVersionUID = -9127824157756048355L;
    private double mAmount = 100000;
    private double mPayment = 0;
    private double mDiscountAmount = 0;
    private double mDiscount = 5;
    private String mCode = "";
    private String mCurrencySymbol = "";

    public PaymentInfo(double amount, double discount, String code, String currencySymbol) {
        this.mAmount = amount;
        this.mDiscount = discount;
        this.mCode = code;
        this.mCurrencySymbol = currencySymbol;

        this.mDiscountAmount = mAmount * (mDiscount / 100);
        this.mPayment = (mAmount - mDiscountAmount);
    }

    public String getPayment() {
        return (String.format("%s%,.2f", mCurrencySymbol, mPayment));
    }

    public String getAmount() {
        return (String.format("%s%,.2f", mCurrencySymbol, mAmount));
    }

    public String getmDiscountAmount() {
        return (String.format("%s%,.2f", mCurrencySymbol, mDiscountAmount));
    }

    public String getmDiscount() {
        return (String.format("%.2f%%", mDiscount));
    }

    public String getmCode() {
        return mCode;
    }

}
