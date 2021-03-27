package sravani.addressbookuc17;

import org.junit.Assert;
import org.junit.Test;

import sravani.addressbookuc17.AddressBookService.IOService;

import java.util.List;
public class AddressBookServiceTest {

    @Test
    public void givenAddressBookInDB_WhenRetrieved_ShouldMatchContactCount(IOService DB_IO){
        AddressBookService addressBookService = new AddressBookService();
        List<AddressBookData> addressBookData = addressBookService.readAddressBookData(DB_IO);
        Assert.assertEquals(2,addressBookData.size());
    }

    @Test
    public void givenNewAddressForContact_WhenUpdated_ShouldSyncWithDB(IOService DB_IO){
        AddressBookService addressBookService = new AddressBookService();
        List<AddressBookData> addressBookDataList = addressBookService.readAddressBookData(DB_IO);
        addressBookService.updatePersonByAddress("Gautam","Sector 4");
        boolean result = addressBookService.checkAddressBookDataIsSyncWithDB("Gautam");
        Assert.assertTrue(result);
    }
}