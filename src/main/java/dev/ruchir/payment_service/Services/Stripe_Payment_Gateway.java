package dev.ruchir.payment_service.Services;

import com.razorpay.RazorpayException;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentLink;
import com.stripe.model.Price;
import com.stripe.param.PaymentLinkCreateParams;
import com.stripe.param.PriceCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("stripePaymentGateway")

public class Stripe_Payment_Gateway implements Payment_Service{

    @Value("${stripe.api.key}")
    private String stripeApiKey;

    @Override
    public String generate_Payment_Link(Long order_Id) throws RazorpayException, StripeException {

        //Make a call to RazorPay to generate the Payment Link

        Stripe.apiKey = stripeApiKey;

        PriceCreateParams priceCreateParams =
                PriceCreateParams.builder()
                        .setCurrency("INR")
                        .setUnitAmount(5000L)
                        .setRecurring(
                                PriceCreateParams.Recurring.builder()
                                        .setInterval(PriceCreateParams.Recurring.Interval.MONTH)
                                        .build()
                        )
                        .setProductData(
                                PriceCreateParams.ProductData.builder().setName("Dr.Mandora's Clinic").build()
                        )
                        .build();

        Price price = Price.create(priceCreateParams);

        PaymentLinkCreateParams paymentLinkCreateParams =
                PaymentLinkCreateParams.builder()
                        .addLineItem(
                                PaymentLinkCreateParams.LineItem.builder()
                                        .setPrice(price.getId())
                                        .setQuantity(1L)
                                        .build()
                        )
                        .build();

        PaymentLink paymentLink = PaymentLink.create(paymentLinkCreateParams);

        return paymentLink.toString();
    }
}