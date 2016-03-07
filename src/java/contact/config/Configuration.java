/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contact.config;

import javax.sql.DataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author tranthanhan
 */
public class Configuration {
  public static final String VIEW_DIR = "/WEB-INF/jsp/";
  
  public Configuration() {

  }

  public static DataSource getDataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
    dataSource.setUrl("jdbc:mysql://localhost:3306/contactdb");
    dataSource.setUsername("root");
    dataSource.setPassword("");

    return dataSource;
    }
}