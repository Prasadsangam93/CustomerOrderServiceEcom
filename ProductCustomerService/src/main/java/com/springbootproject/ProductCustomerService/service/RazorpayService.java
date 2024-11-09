package com.springbootproject.ProductCustomerService.service;




//
//
//import com.razorpay.RazorpayClient;
//import com.razorpay.Order;
//import org.json.JSONObject;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//@Service
//public class    RazorpayPaymentService {
//
//    @Value("${razorpay.key.id}")
//    private String razorpayKey;
//
//    @Value("${razorpay.secret.key}")
//    private String razorpaySecret;
//
//    // Method to create Razorpay Order
//    public JSONObject createOrder(Double amount) throws Exception {
//        RazorpayClient client = new RazorpayClient(razorpayKey, razorpaySecret);
//
//        JSONObject orderRequest = new JSONObject();
//        orderRequest.put("amount", amount * 100); // Razorpay accepts amount in paise (1 INR = 100 paise)
//        orderRequest.put("currency", "INR");
//        orderRequest.put("receipt", "order_receipt");
//
//        Order order = client.orders.create(orderRequest);
//        return order.toJson();
//    }
//
//    // Method to verify payment signature (if needed in your app)
//    public boolean verifyPaymentSignature(JSONObject params, String signature) {
//        // Add your signature verification logic here
//        return true; // For simplicity, assume it is always true
//    }
//}


import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.razorpay.*;

@Service
public class RazorpayService {

    @Value("${razorpay.key.id}")
    private String razorpayKeyId;

    @Value("${razorpay.secret.key}")
    private String razorpayKeySecret;

    public void createPayment(Double amount, String email) throws RazorpayException {
        RazorpayClient client = new RazorpayClient(razorpayKeyId, razorpayKeySecret);
        JSONObject orderRequest = new JSONObject();
        orderRequest.put("amount", amount * 100); // Amount in paise
        orderRequest.put("currency", "INR");
        orderRequest.put("receipt", email);

        Order order = client.orders.create(orderRequest);
    }

    public Payment getPayment(String paymentId) throws RazorpayException {
        RazorpayClient client = new RazorpayClient(razorpayKeyId, razorpayKeySecret);
        return client.payments.fetch(paymentId);
    }
}
