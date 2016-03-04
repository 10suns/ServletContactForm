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

  private final String data;

  public Validation(String data){
    this.data = data;
  }

  public String getData() {
    return data;
  }

  public boolean isEmail(Boolean require) {
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

  public Boolean length(int min, int max) {

  }
}
