package com.adapalav.finalproj;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.web.bind.annotation.*;


@RestController
public class JDBCController {
    private final static String KEYFILEPATH = "./keyFile.key";

    @CrossOrigin
    @RequestMapping(value = "/helloworld", method = RequestMethod.GET)
    public String printCryptTest() {
        AESUtils aesUtils = new AESUtils();

        String encryptedStr = aesUtils.encrypt("Hello World!", KEYFILEPATH);
        return ("Decrypt = " + aesUtils.decrypt(encryptedStr, KEYFILEPATH));
    }

    @CrossOrigin
    @RequestMapping(value = "/printAllCustomers", method = RequestMethod.GET)
    public String printAllCustomers() {
        JdbcTemplate jdbcTemplate = JDBCConnector.getJdbcTemplate();
        StringBuilder resultStr = new StringBuilder();

        String queryStr = "SELECT * from customer_list;";
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(queryStr);
        while (sqlRowSet.next()) {
            resultStr.append(sqlRowSet.getString("cust_id")).append(", ")
                    .append(sqlRowSet.getString("first_name")).append(", ")
                    .append(sqlRowSet.getString("last_name")).append(", ")
                    .append(sqlRowSet.getString("email_id")).append(", ")
                    .append(sqlRowSet.getString("user_name")).append(", ")
                    .append(sqlRowSet.getString("phone_no")).append(", ")
                    .append(sqlRowSet.getString("addr"))
                    .append("\n");
        }
        return (queryStr + "\n" + resultStr);
    }

    @CrossOrigin
    @RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
    public String addCustomer(@RequestBody AddUserData addUserData) {
        JdbcTemplate jdbcTemplate = JDBCConnector.getJdbcTemplate();
        String queryStr = "INSERT INTO customer_list (first_name, last_name, email_id, user_name, phone_no, addr) " +
                "VALUES (" +
                "'" + addUserData.getFirstName() + "'," +
                "'" + addUserData.getLastName() + "'," +
                "'" + addUserData.getEmail() + "'," +
                "'" + addUserData.getUsrName() + "'," +
                "'" + addUserData.getPhoneNo() + "'," +
                "'" + addUserData.getAddress() + "'" +
                ");";
        int rowsUpdated = jdbcTemplate.update(queryStr);
        return ("Rows updated: " + rowsUpdated);
    }

    @CrossOrigin
    @RequestMapping(value = "/addMenuItem", method = RequestMethod.POST)
    public String addMenuItem(@RequestBody AddMenuItem addMenuItem) {
        JdbcTemplate jdbcTemplate = JDBCConnector.getJdbcTemplate();
        String queryStr = "INSERT INTO menu_list (dish_name, dish_type, description, dish_price) " +
                "VALUES (" +
                "'" + addMenuItem.getDishName() + "'," +
                "'" + addMenuItem.getDishType() + "'," +
                "'" + addMenuItem.getDescription() + "'," +
                "'" + addMenuItem.getDishPrice() + "'" +
                ");";
        int rowsUpdated = jdbcTemplate.update(queryStr);
        return ("Rows updated: " + rowsUpdated);
    }

    @CrossOrigin
    @RequestMapping(value = "/printMenuApitizersOnly", method = RequestMethod.GET)
    public String printMenuApitizersOnly() {
        JdbcTemplate jdbcTemplate = JDBCConnector.getJdbcTemplate();
        StringBuilder resultStr = new StringBuilder();

        // Get all Apitizers only
        String queryStr = "SELECT * from menu_list WHERE dish_type=\"Apitizer\";";
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(queryStr);
        while (sqlRowSet.next()) {
            resultStr.append(sqlRowSet.getString("menu_id")).append(", ")
                    .append(sqlRowSet.getString("dish_name")).append(", ")
                    .append(sqlRowSet.getString("dish_type")).append(", ")
                    .append(sqlRowSet.getString("description")).append(", ")
                    .append(sqlRowSet.getFloat("dish_price"))
                    .append("\n");
        }
        return (queryStr + "\n" + resultStr);
    }

    @CrossOrigin
    @RequestMapping(value = "/printMenuLunchItemsOnly", method = RequestMethod.GET)
    public String printMenuLunchItemsOnly() {
        JdbcTemplate jdbcTemplate = JDBCConnector.getJdbcTemplate();
        StringBuilder resultStr = new StringBuilder();

        // get all Lunch Items Only
        String queryStr = "SELECT * from menu_list WHERE dish_type=\"Lunch\";";
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(queryStr);
        while (sqlRowSet.next()) {
            resultStr.append(sqlRowSet.getString("menu_id")).append(", ")
                    .append(sqlRowSet.getString("dish_name")).append(", ")
                    .append(sqlRowSet.getString("dish_type")).append(", ")
                    .append(sqlRowSet.getString("description")).append(", ")
                    .append(sqlRowSet.getFloat("dish_price"))
                    .append("\n");
        }
        return (queryStr + "\n" + resultStr);
    }

    @CrossOrigin
    @RequestMapping(value = "/printMenuDesertsOnly", method = RequestMethod.GET)
    public String printMenuDesertsOnly() {
        JdbcTemplate jdbcTemplate = JDBCConnector.getJdbcTemplate();
        StringBuilder resultStr = new StringBuilder();

        // Show items with different entry for the same type, misspelled in this case (Desert instead of Dessert)
        String queryStr = "SELECT * from menu_list WHERE (dish_type=\"Dessert\" OR dish_type=\"Desert\");";
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(queryStr);
        while (sqlRowSet.next()) {
            resultStr.append(sqlRowSet.getString("menu_id")).append(", ")
                    .append(sqlRowSet.getString("dish_name")).append(", ")
                    .append(sqlRowSet.getString("dish_type")).append(", ")
                    .append(sqlRowSet.getString("description")).append(", ")
                    .append(sqlRowSet.getFloat("dish_price"))
                    .append("\n");
        }
        return (queryStr + "\n" + resultStr);
    }

    @CrossOrigin
    @RequestMapping(value = "/printMenuApitizersAndDrinks", method = RequestMethod.GET)
    public String printMenuApitizersAndDrinks() {
        JdbcTemplate jdbcTemplate = JDBCConnector.getJdbcTemplate();
        StringBuilder resultStr = new StringBuilder();

        // get both Apitizers and Drinks
        String queryStr = "SELECT * from menu_list WHERE (dish_type=\"Apitizer\" OR dish_type=\"Drink\");";
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(queryStr);
        while (sqlRowSet.next()) {
            resultStr.append(sqlRowSet.getString("menu_id")).append(", ")
                    .append(sqlRowSet.getString("dish_name")).append(", ")
                    .append(sqlRowSet.getString("dish_type")).append(", ")
                    .append(sqlRowSet.getString("description")).append(", ")
                    .append(sqlRowSet.getFloat("dish_price"))
                    .append("\n");
        }
        return (queryStr + "\n" + resultStr);
    }

    @CrossOrigin
    @RequestMapping(value = "/printMenuDrinksOnly", method = RequestMethod.GET)
    public String printMenuDrinksOnly() {
        JdbcTemplate jdbcTemplate = JDBCConnector.getJdbcTemplate();
        StringBuilder resultStr = new StringBuilder();

        // get Drinks Only
        String queryStr = "SELECT * from menu_list WHERE dish_type=\"Drink\";";
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(queryStr);
        while (sqlRowSet.next()) {
            resultStr.append(sqlRowSet.getString("menu_id")).append(", ")
                    .append(sqlRowSet.getString("dish_name")).append(", ")
                    .append(sqlRowSet.getString("dish_type")).append(", ")
                    .append(sqlRowSet.getString("description")).append(", ")
                    .append(sqlRowSet.getFloat("dish_price"))
                    .append("\n");
        }
        return (queryStr + "\n" + resultStr);
    }

    @CrossOrigin
    @RequestMapping(value = "/printAllMenuItems", method = RequestMethod.GET)
    public String printAllMenuItems() {
        JdbcTemplate jdbcTemplate = JDBCConnector.getJdbcTemplate();
        StringBuilder resultStr = new StringBuilder();

        // Get entire menu
        String queryStr = "SELECT * from menu_list;";
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(queryStr);
        while (sqlRowSet.next()) {
            resultStr.append(sqlRowSet.getString("menu_id")).append(", ")
                    .append(sqlRowSet.getString("dish_name")).append(", ")
                    .append(sqlRowSet.getString("dish_type")).append(", ")
                    .append(sqlRowSet.getString("description")).append(", ")
                    .append(sqlRowSet.getFloat("dish_price"))
                    .append("\n");
        }
        return (queryStr + "\n" + resultStr);
    }
}
