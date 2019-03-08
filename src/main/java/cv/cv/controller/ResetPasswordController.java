/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.cv.controller;

import cv.cv.entities.UserMii;
import cv.cv.DTO.PasswordResetDto;
import cv.cv.repository.serviceinterface.serviceimpl.EmailServiceImpl;
import cv.cv.repository.serviceinterface.serviceimpl.UserMiiServiceImpl;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author kresna92
 */
@Controller
@RequestMapping("/ResetPassword")
public class ResetPasswordController {

    @Autowired
    UserMiiServiceImpl userService;

    @Autowired
    EmailServiceImpl emailImpl;

    private static Logger log = LoggerFactory.getLogger(ForgetPasswordController.class);

    public PasswordEncoder bcrypt() {
        return new BCryptPasswordEncoder();
    }

    @ModelAttribute("passwordResetForm")
    public PasswordResetDto passwordReset() {
        return new PasswordResetDto();
    }

    @GetMapping
    public String displayResetPasswordPage(@RequestParam(required = false) String token, Model model) {

        UserMii resetToken = userService.findbytoken(token);
        if (resetToken == null) {
            model.addAttribute("error", "Could not find password reset token.");
        } else if (resetToken.isExpired()) {
            model.addAttribute("error", "Token has expired, please request a new password reset.");
        } else {
            model.addAttribute("token", resetToken.getToken());
        }

        return "pages/ResetPassword";
    }

    @PostMapping
    @Transactional
    public String handlePasswordReset(@ModelAttribute("passwordResetForm") @Valid PasswordResetDto form,
            BindingResult result,
            RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute(BindingResult.class.getName() + ".passwordResetForm", result);
            redirectAttributes.addFlashAttribute("passwordResetForm", form);
            return "redirect:/ResetPassword?token=" + form.getToken();
        }

        UserMii user = userService.findbytoken(form.getToken());
        String updatedPassword = bcrypt().encode(form.getPassword());
        user.setToken("");
        userService.updatePassword(updatedPassword, user.getId());

        return "redirect:/login";
    }

}
