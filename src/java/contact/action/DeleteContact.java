/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contact.action;

import contact.config.Configuration;
import contact.dao.ContactDAO;
import contact.dao.ContactDAOImpl;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author tranthanhan
 */
public class DeleteContact extends HttpServlet{

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    ContactDAO contactDAO = new ContactDAOImpl(Configuration.getDataSource());
    try {
      int id = Integer.parseInt(request.getParameter("id"));
      contactDAO.delete(id);
    } catch (Exception e) {
      response.sendError(HttpServletResponse.SC_NOT_FOUND);
    }

    response.sendRedirect("");
  }
}
