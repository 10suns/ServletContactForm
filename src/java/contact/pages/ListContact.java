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
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;
/**
 *
 * @author tranthanhan
 */
public class ListContact extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    response.setContentType("text/html; charset=UTF-8");
    request.setCharacterEncoding("UTF-8");

    ContactDAO contactDAO = new ContactDAOImpl(Configuration.getDataSource());
    List<Contact> contacts = contactDAO.list();

    request.setAttribute("contacts", contacts);
    request.getRequestDispatcher(Configuration.VIEW_DIR + "contactList.jsp" ).forward(request, response);
  }
}
