/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.cv.repository.serviceinterface.serviceimpl;


import cv.cv.entities.UserMii;
import freemarker.template.Configuration;
import freemarker.template.Template;
import java.util.HashMap;
import java.util.Map;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

/**
 *
 * @author NINDA
 */

@Service
public class EmailServiceImpl {
    private JavaMailSender javaMailSender;
    
    @Autowired
    private Configuration freemarkerConfig;
    
    @Autowired
    public EmailServiceImpl (JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }
    
    
    @Bean
     public PasswordEncoder bcrypt() {
        return new BCryptPasswordEncoder();
    }
     
                                           //kelas yg ada fungsi email
    public void sendNotificationService(UserMii umii) throws Exception {
        
               
        
        //send template message
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        
        Map<String, Object> model = new HashMap();
        model.put("user", "qpt");
        model.put("name", umii.getName());
        model.put("id", umii.getId());
        model.put("password", umii.getPassword());
        freemarkerConfig.setClassForTemplateLoading(this.getClass(), "/");
        
        Template t = freemarkerConfig.getTemplate("templateemail.html");
        String text = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
        
        helper.setTo(umii.getEmail());
        helper.setText(text, true);
        helper.setFrom("adm.cvonline@gmail.com");
        helper.setSubject("Email With Template");
        
        javaMailSender.send(message);
    }
                                           //kelas yg ada fungsi email
    public void sendForgetpassword(UserMii umii, String url) throws Exception {
        
               
        
        //send template message
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        
        Map<String, Object> model = new HashMap();
        model.put("name", umii.getName());
        model.put("id", umii.getId());
        model.put("url", url);
        model.put("signature", "CV Online Team");
        freemarkerConfig.setClassForTemplateLoading(this.getClass(), "/");
        
        Template t = freemarkerConfig.getTemplate("resetpass.html");
        String text = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
        helper.setTo(umii.getEmail());
        helper.setText(text, true);
        helper.setFrom("adm.cvonline@gmail.com");
        helper.setSubject("Email With Template");
        
        javaMailSender.send(message);
    }
}
