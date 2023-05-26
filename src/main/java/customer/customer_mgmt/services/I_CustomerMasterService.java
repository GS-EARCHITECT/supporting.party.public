package customer.customer_mgmt.services;

import java.util.ArrayList;

import customer.customer_mgmt.model.dto.CustomerMasterDTO;

public interface I_CustomerMasterService
{
	public CustomerMasterDTO newCustomer(CustomerMasterDTO supplierMasterDTO);
    public ArrayList<CustomerMasterDTO> getAllCustomers();    
    public ArrayList<CustomerMasterDTO> getSelectCustomers(ArrayList<Long> ids);
    public void updCustomer(CustomerMasterDTO supplierMasterDTO);
    public void delAllCustomers();    
    public void delSelectCustomers(ArrayList<Long> ids);    		
}