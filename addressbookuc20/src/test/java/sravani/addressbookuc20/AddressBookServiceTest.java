package sravani.addressbookuc20;

import org.junit.Assert;
import org.junit.Test;

import sravani.addressbookuc20.AddressBookService.IOService;

import java.time.LocalDate;
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
        addressBookService.updatePersonByAddress("SRAVANI","Sector 4");
        boolean result = addressBookService.checkAddressBookDataIsSyncWithDB("SRAVANI");
        Assert.assertTrue(result);
    }

    @Test
    public void givenDateRangeForContact_WhenRetrieved_ShouldMatchContactCount(IOService DB_IO){
        AddressBookService addressBookService = new AddressBookService();
        addressBookService.readAddressBookData(DB_IO);
        LocalDate addedDate = LocalDate.of(2020, 01,01);
        LocalDate endDate = LocalDate.now();
        List<AddressBookData> addressBookData =
                addressBookService.readContactDateRange(DB_IO, addedDate, endDate);
        Assert.assertEquals(2, addressBookData.size());
    }

    @Test
    public void givenContact_WhenRetrieved_ShouldMatchByState(IOService DB_IO){
        AddressBookService addressBookService = new AddressBookService();
        addressBookService.readAddressBookData(DB_IO);
        String State = "DNH";
        List<AddressBookData> addressBookDataList = addressBookService.readAddressBookDataByState(DB_IO, State);
        Assert.assertEquals(1, addressBookDataList.size());
    }

    @Test
    public void givenContact_WhenRetrieved_ShouldMatchByCity(IOService DB_IO){
        AddressBookService addressBookService = new AddressBookService();
        addressBookService.readAddressBookData(DB_IO);
        String City = "Mysore";
        List<AddressBookData> addressBookDataList = addressBookService.readAddressBookDataByCity(DB_IO, City);
        Assert.assertEquals(1, addressBookDataList.size());
    }

    @Test
    public void givenContact_WhenAdded_ShouldSyncWithDB(IOService DB_IO){
        AddressBookService addressBookService = new AddressBookService();
        addressBookService.readAddressBookData(DB_IO);
        addressBookService.addingNewContactToBook("SHAMAL","PATIL","Sector 12", "Bhuj", "Gujarat", 370001, 932493612,"vikrant@gmail.com",LocalDate.now());
        boolean result = addressBookService.checkAddressBookDataIsSyncWithDB("Vikrant");
        Assert.assertTrue(result);
    }
}