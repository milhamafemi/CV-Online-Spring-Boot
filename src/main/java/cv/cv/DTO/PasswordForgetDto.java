/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.cv.DTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 *
 * @author kresna92
 */
public class PasswordForgetDto {
    @Email
    @NotEmpty
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
