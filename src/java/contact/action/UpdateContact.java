/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contact.action;

import contact.config.Configuration;
import contact.dao.ContactDAO;
import contact.dao.ContactDAOImpl;
import contact.model.Contact;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author tranthanhan
 */
public class UpdateContact extends HttpServlet{
  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("text/html");
    Contact contact = new Contact();
    contact.setEmail(request.getParameter("email"));
    contact.setName(request.getParameter("name"));
    contact.setAddress(request.getParameter("add"));
    contact.setTelephone(request.getParameter("tel"));

    try {
      contact.setId(Integer.parseInt(request.getParameter("id")));
    } catch (Exception e){

    }

    if (validate()){
      ContactDAO contactDAO = new ContactDAOImpl(Configuration.getDataSource());
      contactDAO.saveOrUpdate(contact);
      response.sendRedirect("contacts");
    } else {
      request.setAttribute("contact", contact);
      request.getRequestDispatcher(Configuration.VIEW_DIR + "contactForm.jsp").forward(request, response);
    }
  }

  public Boolean validate() {
    return true;
  }
}
