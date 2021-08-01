package vn.techmaster.shopingcart.util;

import java.util.Locale;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import vn.techmaster.shopingcart.model.Cart;
import vn.techmaster.shopingcart.model.Customer;
@Component
public class Mail {
    @Autowired
    private Environment env;
    @Autowired
    private TemplateEngine templateEngine;

    //Cấu hình mail gửi đến khách hàng
    public MimeMessagePreparator constructOrderConfirmationEmail(Customer customer, Cart cart, Locale local){
        Context context = new Context();
        context.setVariable("customer",customer); //attribute user trong mail template
        context.setVariable("cart",cart); // attribute cart trong mail template
        //Email template
        String text = templateEngine.process("shoppingCartFinalize", context);

        MimeMessagePreparator messagePreparator = new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper email = new MimeMessageHelper(mimeMessage);
                //Địa chỉ nhận mail
                email.setTo(customer.getEmail());
                //Thông tin tiêu đề mail
                email.setSubject("Order Confirmation -"+ customer.getName());
                //Nội dung mail
                email.setText(text,true);
                //Thông tin người gửi mail
                email.setFrom(new InternetAddress("linhle51098@gmail.com.com"));
            }
        };
        return messagePreparator;
    }
}
