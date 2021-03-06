package sravani.addressbookuc21;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AddressBookDBService {
    private PreparedStatement addressBookStatement;
    private static AddressBookDBService addressBookDBService;
    private AddressBookDBService(){}

    public static AddressBookDBService getInstance(){
        if (addressBookDBService == null)
            addressBookDBService = new AddressBookDBService();
        return addressBookDBService;
    }

    private Connection getConnection() throws SQLException {
        String jdbcURL = "jdbc:mysql://localhost:3306/address_book_service?useSSL=false";
        String userName = "root";
        String password = "sravani14";
        Connection connection;
        System.out.println("Connecting to database:"+jdbcURL);
        connection = DriverManager.getConnection(jdbcURL,userName,password);
        System.out.println("Connection is successful!"+connection);
        return connection;
    }

    public List<Contact> readData() {
        String sql = "SELECT * FROM address_book";
        return this.getAddressBookDataUsingDB(sql);
    }

    private List<Contact> getAddressBookDataUsingDB(String sql) {
        List<Contact> contactList = new ArrayList<>();
        try (Connection connection = this.getConnection()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            contactList = this.getAddressBookData(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contactList;
    }

    private List<Contact> getAddressBookData(ResultSet resultSet) {
        List<Contact> contactList = new ArrayList<>();
        try {
            while (resultSet.next()){
                String first = resultSet.getString("first_name");
                String last = resultSet.getString("last_name");
                String address = resultSet.getString("address");
                String city = resultSet.getString("city");
                String state = resultSet.getString("state");
                int zip = resultSet.getInt("zip");
                int phone = resultSet.getInt("phone_number");
                String email = resultSet.getString("email");
                contactList.add(new Contact(first,last,address,city,state,zip,phone,email));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return contactList;
    }

    public int updateAddressBookData(String name, String address){
        return this.updateAddressBookDataUsingStatement(name, address);
    }

    public int updateAddressBookDataUsingStatement(String firstname, String address) {
        String sql = String.format("update address_book set address = '%s' where first_name = '%s';", address, firstname);
        try (Connection connection = this.getConnection()){
            Statement statement = connection.createStatement();
            return statement.executeUpdate(sql);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    public List<Contact> getAddressBookData(String first_name) {
        List<Contact> contactList = null;
        if(this.addressBookStatement == null)
            this.prepareStatementForAddressBook();
        try {
            addressBookStatement.setString(1,first_name);
            ResultSet resultSet = addressBookStatement.executeQuery();
            contactList = this.getAddressBookData(resultSet);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return contactList;
    }

    private void prepareStatementForAddressBook() {
        try {
            Connection connection = this.getConnection();
            String sql = "SELECT * FROM address_book WHERE first_name = ?";
            addressBookStatement = connection.prepareStatement(sql);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Contact> getContactForDateRange(LocalDate startDate, LocalDate endDate) {
        String sql = String.format("SELECT * FROM address_book WHERE start BETWEEN '%s' and '%s';",Date.valueOf(startDate),Date.valueOf(endDate));
        return this.getAddressBookDataUsingDB(sql);
    }

    public List<Contact> getContactForCityOrState(String city, String state) {
        String sql = String.format("SELECT * FROM address_book WHERE city = '%s' OR state = '%s';",city,state);
        return this.getAddressBookDataUsingDB(sql);
    }

    public Contact addContactToBook(String firstName, String lastName, String address, String city, String state, int zip, int phoneNumber, String email, LocalDate startDate) {
        Contact contact = null;
        String sql = String.format("INSERT INTO address_book (first_name, last_name, address, city, state, zip, phone_number, email , start) " +
                "VALUES ( '%s', '%s', '%s', '%s', '%s', '%s', %s, '%s', '%s' );", firstName, lastName, address, city, state, zip, phoneNumber, email, Date.valueOf(startDate));
        try (Connection connection = this.getConnection()){
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            contact = new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email, startDate);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return contact ;
    }
}