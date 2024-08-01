package dev.ruchir.payment_service.Services;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import com.razorpay.RazorpayClient;



@Service("razorpayPaymentGateway")
public class Razorpay_Payment_Gateway implements Payment_Service{

    //Dependency injection
    private RazorpayClient razorpayClient;

    public Razorpay_Payment_Gateway(RazorpayClient razorpayClient) {
        this.razorpayClient = razorpayClient;
    }

    @Override
    public String generate_Payment_Link(Long order_Id) throws RazorpayException {
        //Make a call to RazorPay to generate the Payment Link

        JSONObject paymentLinkRequest = new JSONObject();
        paymentLinkRequest.put("amount",1000);
        paymentLinkRequest.put("currency","INR");
//        paymentLinkRequest.put("accept_partial",true);
//        paymentLinkRequest.put("first_min_partial_amount",100);
        paymentLinkRequest.put("expire_by",System.currentTimeMillis() + 10*60*1000);
        paymentLinkRequest.put("reference_id",order_Id.toString());
        paymentLinkRequest.put("description","Payment for Subscription.");

        //Call the orderservice to get the order details
        //Order order = restTemplate.getForObject("orderService URL ", Order.class)

        JSONObject customer = new JSONObject();
        customer.put("name","+Dr. K. L. Mandora");
        customer.put("contact","8764611551");
        customer.put("email","DrmandoraClinic@gmail.com");
        paymentLinkRequest.put("customer",customer);

        JSONObject notify = new JSONObject();
        notify.put("sms",true);
        notify.put("email",true);
        paymentLinkRequest.put("reminder_enable",true);

        JSONObject notes = new JSONObject();
//        notes.put("policy_name","Jeevan Bima");
//        paymentLinkRequest.put("notes",notes);
        paymentLinkRequest.put("callback_url","https://razorpay.com /");
        paymentLinkRequest.put("callback_method","get");

        PaymentLink payment = razorpayClient.paymentLink.create(paymentLinkRequest);

        return payment.get("short_url");
//        return payment.toString();
    }
}
