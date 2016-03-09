/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contact.model;

import contact.constraint.Email;
import java.util.HashMap;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.*;

/**
 *
 * @author tranthanhan
 */
public class Contact {

  private final Validator validator;
  private HashMap<String, String> errorMessages;
  
  private int id;

  @NotNull
  @Size(min=1, max=255)
  private String name;

  @NotNull
  @Size(min=1, max=255)
  @Email
  private String email;

  @NotNull
  @Size(min=1, max=255)
  private String address;

  @NotNull
  @Pattern(regexp="(^[0-9]{10}$)")
  private String telephone;

  public Contact() {
    ValidatorFactory vf;
    vf = javax.validation.Validation.buildDefaultValidatorFactory();
    validator = vf.getValidator();
  }

  public Contact(String name, String email, String address, String telephone){
    this.name = name;
    this.email = email;
    this.address = address;
    this.telephone = telephone;

    ValidatorFactory vf;
    vf = javax.validation.Validation.buildDefaultValidatorFactory();
    validator = vf.getValidator();
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public boolean isValid(){
    Set<ConstraintViolation<Contact>> violations;
    violations = validator.validate(this);
    HashMap<String, String> messages = new HashMap<>();
    if (violations != null) {
      for (ConstraintViolation<Contact> cv : violations) {
        String field = cv .getPropertyPath().toString();
        String message = cv.getMessage();
        messages.put(field, message);
      }
    }
    errorMessages = messages;
    return violations == null;
  }
}
