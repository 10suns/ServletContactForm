/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contact.constraint;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author tranthanhan
 */
public class EmailValidator implements ConstraintValidator<Email, String>{

  @Override
  public void initialize(Email a) {
    // See JSR 303 Section 2.4.1 for sample implementation.
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext cvc) {
    if (value == null){
        return false;
    }
    boolean result = true;
    try {
       InternetAddress emailAddr = new InternetAddress(value);
       emailAddr.validate();
    } catch (AddressException ex) {
       result = false;
    }
    return result;
  }
}