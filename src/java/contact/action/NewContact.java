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
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author tranthanhan
 */
public class NewContact extends HttpServlet {

  private ContactDAO contactDAO = new ContactDAOImpl(Configuration.getDataSource());

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    response.setContentType("text/html");

    if (request.getParameter("id") != null) {
      Contact contact = contactDAO.get(Integer.parseInt(request.getParameter("id")));
      request.setAttribute("contact", contact);
    }
    request.getRequestDispatcher(Configuration.VIEW_DIR + "contactForm.jsp" ).forward(request, response);
  }
}
