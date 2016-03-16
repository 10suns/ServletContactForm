/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contact.action;

import com.google.gson.JsonObject;
import contact.config.Configuration;
import contact.dao.ContactDAO;
import contact.dao.ContactDAOImpl;
import contact.model.Contact;
import java.io.IOException;
import java.util.Map;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 *
 * @author tranthanhan
 */
public class UpdateContact extends HttpServlet {

    private Validator validator;
    private ValidatorFactory vf;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        ContactDAO contactDAO = new ContactDAOImpl(Configuration.getDataSource());
        JsonObject ret = new JsonObject();
        Contact contact = new Contact();

        if (!request.getParameter("id").equals("")) {
            contact = contactDAO.get(Integer.parseInt(request.getParameter("id")));
        }

        contact.setEmail(request.getParameter("email"));
        contact.setName(request.getParameter("name"));
        contact.setAddress(request.getParameter("add"));
        contact.setTelephone(request.getParameter("tel"));

        if (contact.isValid() && contactDAO.saveOrUpdate(contact) > 0) {
            ret.addProperty("result", Boolean.TRUE);
        } else {
            JsonObject inner = new JsonObject();
            Map<String, String> errors = contact.getErrorMessages();
            for (Map.Entry<String, String> error : errors.entrySet()) {
                inner.addProperty(error.getKey(), error.getValue());
            }
            ret.add("errors", inner);
        }

        response.getWriter().write(ret.toString());
    }
}
