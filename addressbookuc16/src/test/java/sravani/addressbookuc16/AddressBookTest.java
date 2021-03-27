package sravani.addressbookuc16;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import junit.framework.Assert;

import java.util.List;

public class AddressBookTest {

    @Test
    public void givenAddressBookInDB_WhenRetrieved_ShouldMatchEmployeeCount(){
        AddressBookService employeePayrollService = new AddressBookService();
        List<AddressBookData> contactList = employeePayrollService.readAddressBookData(AddressBookService.IOService.DB_IO);
        Assert.assertEquals(3, contactList.size());
    }
}