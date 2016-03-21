/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contact.dao;

import contact.model.Contact;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author tranthanhan
 */
public class ContactDAOImpl implements ContactDAO {

    private JdbcTemplate jdbcTemplate;

    public ContactDAOImpl(DataSource datasource) {
        jdbcTemplate = new JdbcTemplate(datasource);
    }

//<editor-fold defaultstate="collapsed" desc="save and update">
    @Override
    public int saveOrUpdate(Contact contact) {
        try {
            if (contact.getId() > 0) {
                // update
                String sql = "UPDATE CONTACT SET NAME = ?, EMAIL =?, ADDRESS = ?, TELEPHONE= ? WHERE CONTACT_ID = ?";
                return jdbcTemplate.update(sql, contact.getName(), contact.getEmail(), contact.getAddress(), contact.getTelephone(), contact.getId());
            } else {
                // insert
                String sql = "INSERT INTO CONTACT(NAME, EMAIL, ADDRESS, TELEPHONE) VALUE(?, ?, ?, ?)";
                return jdbcTemplate.update(sql, contact.getName(), contact.getEmail(), contact.getAddress(), contact.getTelephone());
            }
        } catch (DataAccessException ex) {
            ex.printStackTrace();
            return -1;
        }
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="delete">
    @Override
    public int delete(int contactID) {
        try {
        String sql = "DELETE FROM contact WHERE contact_id=?";
        return jdbcTemplate.update(sql, contactID);
        } catch(DataAccessException ex) {
            ex.printStackTrace();
            return -1;
        }
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="get a contact">
    @Override
    public Contact get(int contactID) {
        try {
            String sql = "SELECT * FROM CONTAT WHERE CONTACT_ID=" + contactID;
            return jdbcTemplate.query(sql, new ResultSetExtractor<Contact>() {
                @Override
                public Contact extractData(ResultSet rs) throws SQLException, DataAccessException {
                    if (rs.next()) {
                        Contact contact = new Contact();
                        contact.setId(rs.getInt("contact_id"));
                        contact.setName(rs.getString("name"));
                        contact.setEmail(rs.getString("email"));
                        contact.setAddress(rs.getString("address"));
                        contact.setTelephone(rs.getString("telephone"));
                        return contact;
                    }
                    return null;
                }
            });
        } catch (DataAccessException ex) {
            ex.printStackTrace();
            return null;
        }
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="get all contacts">
    @Override
    public List<Contact> list() {
        String sql = "SELECT * from contact";
        try {
            List<Contact> listContact = jdbcTemplate.query(sql, new RowMapper<Contact>() {
            @Override
            public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
                Contact aContact = new Contact();
                aContact.setId(rs.getInt("contact_id"));
                aContact.setName(rs.getString("name"));
                aContact.setEmail(rs.getString("email"));
                aContact.setAddress(rs.getString("address"));
                aContact.setTelephone(rs.getString("telephone"));

                return aContact;
            }
            });
            return listContact;
        } catch(DataAccessException ex) {
            ex.printStackTrace();
            return null;
        }
    }
//</editor-fold>

}
