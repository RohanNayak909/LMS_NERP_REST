package nirmalya.aatithya.restmodule.lms.services;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.Utils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RazorpayService {

  private final RazorpayClient client;

  @Value("${razorpay.key_id}")
  private String keyId;

  @Value("${razorpay.key_secret}")
  private String keySecret;

  @Value("${razorpay.currency:INR}")
  private String defaultCurrency;

  public RazorpayService(
      @Value("${razorpay.key_id}") String keyId,
      @Value("${razorpay.key_secret}") String keySecret) throws Exception {
    this.client = new RazorpayClient(keyId, keySecret);
  }

  public String getKeyId() {
    return keyId;
  }

  /**
   * Create a Razorpay order for the given amount.
   *
   * @param amountPaise amount in paise (e.g. ₹600 => 60000)
   * @param currency    currency code ("INR")
   * @param receipt     internal order code (lms_payment_order.order_code)
   * @param notes       optional notes JSON
   */
  public Order createOrder(long amountPaise, String currency, String receipt, JSONObject notes) throws Exception {
    JSONObject options = new JSONObject();

    // Use explicit types to avoid ambiguous put overloads in Java 8
    options.put("amount", Long.valueOf(amountPaise)); // paise
    options.put("currency", (currency != null ? currency : defaultCurrency));
    options.put("receipt", receipt);

    // Avoid boolean overload – use "1" as String for safety,
    // or you can remove this line and control capture mode from Razorpay dashboard.
    options.put("payment_capture", "1");

    if (notes != null) {
      options.put("notes", notes);
    }

    // IMPORTANT: 'orders' is lowercase – this fixes "Orders cannot be resolved" error
    return client.orders.create(options);
  }

  public boolean verifySignature(String orderId, String paymentId, String signature) throws Exception {
    JSONObject payload = new JSONObject();
    payload.put("razorpay_order_id", orderId);
    payload.put("razorpay_payment_id", paymentId);
    payload.put("razorpay_signature", signature);

    try {
      Utils.verifyPaymentSignature(payload, keySecret);
      return true;
    } catch (Exception ex) {
      return false;
    }
  }
}
