package customer.customer_prodservcs.services;

import java.util.ArrayList;

import customer.customer_prodservcs.model.dto.CustomerProdServDetailsDTO;

public interface I_CustomerProdServDetailsService
{
	public CustomerProdServDetailsDTO newCustomerProdServDetail(CustomerProdServDetailsDTO supplierProdServDetailsDTO);
    public ArrayList<CustomerProdServDetailsDTO> getAllCustomerProdServDetails();
    public ArrayList<CustomerProdServDetailsDTO> getSelectCustomerProdServDetails(ArrayList<Long> ids);
    public ArrayList<CustomerProdServDetailsDTO> getSelectCustomerAssets(ArrayList<Long> ids);
    public ArrayList<CustomerProdServDetailsDTO> getSelectCustomerResources(ArrayList<Long> ids);
    public ArrayList<CustomerProdServDetailsDTO> getSelectCustomerServices(ArrayList<Long> ids);
    public void updCustomerProdServDetail(CustomerProdServDetailsDTO supplierProdServDetailsDTO);
    public void delAllCustomerProdServDetails();    
    public void delSelectCustomerAssets(ArrayList<Long> ids);
    public void delSelectCustomerResources(ArrayList<Long> ids);
    public void delSelectCustomerServices(ArrayList<Long> ids);
    public void delSelectCustomerProdServDetails(ArrayList<Long> ids);
}



