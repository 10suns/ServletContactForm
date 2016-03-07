/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contact.model;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 *
 * @author tranthanhan
 */
public class Validation {

  public String[] rules;

  private final String data;
  private final Boolean isRequired;


  public Validation(String data, Boolean isRequired){
    this.data = data;
    if (isRequired == null){
      this.isRequired = false;
    } else {
      this.isRequired = isRequired;
    }
  }

  public String getData() {
    return data;
  }

  public boolean isEmail() {
    if (isBlank() && !isRequired){
      return true;
    }

    boolean result = true;
    try {
       InternetAddress emailAddr = new InternetAddress(data);
       emailAddr.validate();
    } catch (AddressException ex) {
       result = false;
    }
    return result;
  }

  public Boolean isBlank() {
    return data.length() > 0;
  }

  public Boolean range(int min, int max) {
    if (isBlank() && !isRequired){
      return true;
    } else {
      return (Integer.parseInt(data) >= min && Integer.parseInt(data) <= max);
    }
  }
}
