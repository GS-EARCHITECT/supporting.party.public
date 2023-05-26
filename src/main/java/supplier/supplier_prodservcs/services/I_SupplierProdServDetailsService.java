package supplier.supplier_prodservcs.services;

import java.util.ArrayList;

import supplier.supplier_prodservcs.model.dto.SupplierProdServDetailsDTO;

public interface I_SupplierProdServDetailsService
{
	public SupplierProdServDetailsDTO newSupplierProdServDetail(SupplierProdServDetailsDTO supplierProdServDetailsDTO);
    public ArrayList<SupplierProdServDetailsDTO> getAllSupplierProdServDetails();
    public ArrayList<SupplierProdServDetailsDTO> getSelectSupplierProdServDetails(ArrayList<Long> ids);
    public ArrayList<SupplierProdServDetailsDTO> getSelectSupplierAssets(ArrayList<Long> ids);
    public ArrayList<SupplierProdServDetailsDTO> getSelectSupplierResources(ArrayList<Long> ids);
    public ArrayList<SupplierProdServDetailsDTO> getSelectSupplierServices(ArrayList<Long> ids);
    public void updSupplierProdServDetail(SupplierProdServDetailsDTO supplierProdServDetailsDTO);
    public void delAllSupplierProdServDetails();    
    public void delSelectSupplierAssets(ArrayList<Long> ids);
    public void delSelectSupplierResources(ArrayList<Long> ids);
    public void delSelectSupplierServices(ArrayList<Long> ids);
    public void delSelectSupplierProdServDetails(ArrayList<Long> ids);
}



