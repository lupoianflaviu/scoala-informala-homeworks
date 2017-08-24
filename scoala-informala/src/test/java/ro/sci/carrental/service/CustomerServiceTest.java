package ro.sci.carrental.service;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import ro.sci.carrental.domain.customer.Customer;
import ro.sci.carrental.repository.CustomerRepository;
import ro.sci.carrental.repository.CustomerRepositoryImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author flaviu.lupoian
 *
 * date 2017.08.22
 */
public class CustomerServiceTest {

    private Customer customer = new Customer();
    private Customer customer2 = new Customer();
    private CustomerService<Customer> customerService = new CustomerServiceImpl();
    private CustomerRepository<Customer> customerRepositoryMock;
    private List<Customer> customerList = new ArrayList<>();

    @Before
    public void init() throws Exception {
        customerRepositoryMock = mock(CustomerRepositoryImpl.class);
        customerService.setCustomerRepository(customerRepositoryMock);
        customerList.add(customer);
        when(customerRepositoryMock.getAll()).thenReturn(customerList);
        when(customerRepositoryMock.getCustomerByLastName(anyString())).thenReturn(customerList);
        when(customerRepositoryMock.getCustomerByFullName(anyString(), anyString())).thenReturn(customerList);
        when(customerRepositoryMock.getCustomerByTelephone(anyString())).thenReturn(customerList);
    }

    @Test
    public void testAdd() throws Exception {
        customerService.add(customer2);

        verify(customerRepositoryMock, times(1)).add(customer2);
        assertEquals(1, customerRepositoryMock.getAll()
                                              .size());
    }

    @Test
    public void testAddNotUsed() throws Exception {
        verify(customerRepositoryMock, never()).add(customer2);
    }

    @Test
    public void testDelete() throws Exception {
        customerService.add(customer2);
        customerService.delete(customer);
        customerService.delete(customer2);

        verify(customerRepositoryMock, times(2)).delete(customer);
    }

    @Test
    public void testDeleteNotUsed() throws Exception {
        verify(customerRepositoryMock, never()).delete(customer);
    }

    @Test
    public void testUpdate() throws Exception {
        customerService.update(customer2);
        verify(customerRepositoryMock, times(1)).update(customer2);
    }

    @Test
    public void testUpdateNotUsed() throws Exception {
        verify(customerRepositoryMock, never()).update(customer2);
    }

    @Test
    public void testGetAll() throws Exception {
        assertEquals(1, customerService.getAll()
                                       .size());
        verify(customerRepositoryMock, times(1)).getAll();
    }

    @Test
    public void testGetAllNotEquals() throws Exception {
        assertNotEquals(0, customerService.getAll()
                                          .size());
    }

    @Test
    public void testFindCustomerByLastName() throws Exception {
        customerService.findCustomerByLastName("Cretu");
        verify(customerRepositoryMock, times(1)).getCustomerByLastName("Cretu");
        assertEquals(1, customerService.getAll()
                                       .size());
    }

    @Test
    public void testFindCustomerByLastNameNotEquals() throws Exception {
        customerService.findCustomerByLastName("Lupoian");
        verify(customerRepositoryMock, never()).getCustomerByLastName("Cretu");
        assertNotEquals(0, customerService.getAll()
                                          .size());
    }

    @Test
    public void testFindCustomerByFullName() throws Exception {
        customerService.findCustomerByFullName("Dorel", "Cretu");

        verify(customerRepositoryMock, times(1)).getCustomerByFullName("Dorel", "Cretu");
        assertEquals(1, customerService.getAll()
                                       .size());
    }

    @Test
    public void testFindCustomerByFullNameNotEquals() throws Exception {
        customerService.findCustomerByFullName("Flaviu", "Lupoian");

        verify(customerRepositoryMock, never()).getCustomerByFullName("Dorel", "Cretu");
        assertNotEquals(0, customerService.getAll()
                                          .size());
    }

    @Test
    public void findCustomerByTelephone() throws Exception {
        customerService.findCustomerByTelephone("0727807427");
        verify(customerRepositoryMock, times(1)).getCustomerByTelephone("0727807427");
        assertEquals(1, customerService.getAll()
                                       .size());
    }

    @Test
    public void setCustomerRepository() throws Exception {
        customerService.findCustomerByLastName("0727000000");
        verify(customerRepositoryMock, never()).getCustomerByLastName("0727807427");
        assertNotEquals(0, customerService.getAll()
                                          .size());
    }
}