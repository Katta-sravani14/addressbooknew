package sravani.addressbookuc17;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressBookDBService {
    private static AddressBookDBService addressBookDBService;
    private PreparedStatement addressBookDataStatement;

    public AddressBookDBService(){}

    public static AddressBookDBService getInstance(){
        if(addressBookDBService == null)
            addressBookDBService = new AddressBookDBService();
        return addressBookDBService;
    }

    private Connection getConnection() throws SQLException {
        String jdbcURL = "jdbc:mysql://localhost:3306/address_book_service?useSSL=false";
        String userName = "root";
        String password = "sravani14";
        Connection connection;
        System.out.println("Connecting to database:"+jdbcURL);
        connection = DriverManager.getConnection(jdbcURL, userName, password);
        System.out.println("Connection is successful!!!!");
        return connection;
    }

    public List<AddressBookData> readData(){
        String sql = "SELECT * FROM address_book; ";
        List<AddressBookData> addressBookContactList = new ArrayList<>();
        try (Connection connection = this.getConnection()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            addressBookContactList = this.getAddressBookData(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addressBookContactList;
    }

    public List<AddressBookData> getAddressBookData(String name){
        List<AddressBookData> addressBookDataList = null;
        if(this.addressBookDataStatement == null)
            this.prepareStatementForContactData();
        try{
            addressBookDataStatement.setString(1, name);
            ResultSet resultSet = addressBookDataStatement.executeQuery();
            addressBookDataList = this.getAddressBookData(resultSet);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return addressBookDataList;
    }

    private List<AddressBookData> getAddressBookData(ResultSet resultSet){
        List<AddressBookData> addressBookDataList = new ArrayList<>();
        try{
            while(resultSet.next()){
                String firstName = resultSet.getString("FirstName");
                String lastName = resultSet.getString("LastName");
                String address = resultSet.getString("Address");
                String city = resultSet.getString("City");
                String state = resultSet.getString("State");
                int zipCode = resultSet.getInt("ZipCode");
                long phoneNumber = resultSet.getLong("PhoneNumber");
                String email = resultSet.getString("Email");
                addressBookDataList.add(new AddressBookData(firstName, lastName, address, city, state, zipCode, phoneNumber, email));
        }
    } catch (SQLException e){
            e.printStackTrace();
        }
        return addressBookDataList;
    }

    private void prepareStatementForContactData(){
        try{
            Connection connection = this.getConnection();
            String sql = "SELECT * FROM address_book WHERE FirstName = ?";
            addressBookDataStatement = connection.prepareStatement(sql);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public int updateContactData(String name, String address){
        return this.updateContactDataUsingStatement(name, address);
    }

    private int updateContactDataUsingStatement(String name, String address) {
        String sql = String.format("update address_book set address = '%s' where FirstName = '%s';", address, name);
        try(Connection connection = this.getConnection()){
            Statement statement = connection.createStatement();
            return statement.executeUpdate(sql);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
}