/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contact.page;

import contact.dao.ContactDAO;
import contact.dao.ContactDAOImpl;
import contact.model.Contact;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.sql.DataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author tranthanhan
 */
public class ContactForm extends HttpServlet {

  private static final String VIEW_DIR = "/WEB-INF/jsp/";

  public static final String[] FIELDS = {"name", "email", "add", "tel"};

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    response.setContentType("text/html");
    request.getRequestDispatcher(VIEW_DIR + "contactForm.jsp" ).forward(request, response);
  }

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    response.setContentType("text/html");
    // Validation Form
    Boolean validate = true;
    if (validate) {
      Contact contact = new Contact();
      contact.setEmail(request.getParameter("email"));
      contact.setName(request.getParameter("name"));
      contact.setAddress(request.getParameter("add"));
      contact.setTelephone(request.getParameter("tel"));

      ContactDAO contactDAO = new ContactDAOImpl(getDataSource());
      contactDAO.saveOrUpdate(contact);
    } else {
      for (String field : FIELDS) {
        request.setAttribute(field, request.getParameter(field));
      }
      request.getRequestDispatcher(VIEW_DIR + "contactForm.jsp" ).forward(request, response);
    }
  }

  private DataSource getDataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
    dataSource.setUrl("jdbc:mysql://localhost:3306/contactdb");
    dataSource.setUsername("root");
    dataSource.setPassword("");

    return dataSource;
  }
}
