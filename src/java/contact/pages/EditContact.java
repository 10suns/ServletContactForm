/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contact.pages;

import contact.config.Configuration;
import contact.dao.ContactDAO;
import contact.dao.ContactDAOImpl;
import contact.model.Contact;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tranthanhan
 */
public class EditContact extends HttpServlet {

  private ContactDAO contactDAO = new ContactDAOImpl(Configuration.getDataSource());

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    response.setContentType("text/html; charset=UTF-8");
    request.setCharacterEncoding("UTF-8");
    
    try {
      int id = Integer.parseInt(request.getParameter("id"));
    } catch (Exception e) {
      response.sendError(HttpServletResponse.SC_NOT_FOUND);
    }

    Contact contact = contactDAO.get(Integer.parseInt(request.getParameter("id")));
    request.setAttribute("contact", contact);
    request.getRequestDispatcher(Configuration.VIEW_DIR + "contactForm.jsp" ).forward(request, response);
  }
}
