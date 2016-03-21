/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contact.ajax;

import com.google.gson.JsonObject;
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
public class DeleteContact extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        ContactDAO contactDAO = new ContactDAOImpl(Configuration.getDataSource());
        JsonObject ret = new JsonObject();

        int id = Integer.parseInt(request.getParameter("id"));

        if (contactDAO.delete(id) > 0) {
            ret.addProperty("result", Boolean.TRUE);
        } else {
            ret.addProperty("errors", "Can not delete this contact!");
        }

        response.getWriter().write(ret.toString());
    }
}
