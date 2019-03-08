/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.cv.controller;

import cv.cv.DTO.PasswordForgetDto;
import cv.cv.entities.UserMii;
import cv.cv.repository.serviceinterface.serviceimpl.EmailServiceImpl;
import cv.cv.repository.serviceinterface.serviceimpl.UserMiiServiceImpl;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author kresna92
 */
@Controller
@RequestMapping("/ForgetPassword")
public class ForgetPasswordController {

    @Autowired
    UserMiiServiceImpl userService;
    
    @Autowired
    EmailServiceImpl emailImpl;
    
    private static Logger log = LoggerFactory.getLogger(ForgetPasswordController.class);
    
    @ModelAttribute("forgotPasswordForm")
    public PasswordForgetDto forgotPasswordDto() {
        return new PasswordForgetDto();
    }

    @GetMapping
    public String displayForgotPasswordPage() {
        return "pages/ForgetPassword";
    }

    @PostMapping
    public String processForgotPasswordForm(@ModelAttribute("forgotPasswordForm") @Valid PasswordForgetDto form,
                                            BindingResult result,
                                            HttpServletRequest request) {

        if (result.hasErrors()){
            return "/ForgetPassword";
        }

        UserMii user = userService.findbyemail(form.getEmail());
        if (user == null){
            result.rejectValue("email", null, "We could not find an account for that e-mail address.");
            return "/ForgetPassword";
        }

        user.setToken(UUID.randomUUID().toString());
        user.setExpiryDate(30);
        userService.save(user);

        String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()+"/ResetPassword?token=" + user.getToken();
        try {

            emailImpl.sendForgetpassword(user,url);

        } catch (Exception e) {
            log.info("Error sending email = " + e.getMessage());
        }

        return "redirect:/ForgetPassword?success";

    }

}