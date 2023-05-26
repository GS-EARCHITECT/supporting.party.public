package supplier.supplier_mgmt.services;

import java.util.ArrayList;

import supplier.supplier_mgmt.model.dto.SupplierMasterDTO;

public interface I_SupplierMasterService
{
	public SupplierMasterDTO newSupplier(SupplierMasterDTO supplierMasterDTO);
    public ArrayList<SupplierMasterDTO> getAllSuppliers();    
    public ArrayList<SupplierMasterDTO> getSelectSuppliers(ArrayList<Long> ids);
    public void updSupplier(SupplierMasterDTO supplierMasterDTO);
    public void delAllSuppliers();    
    public void delSelectSuppliers(ArrayList<Long> ids);    		
}



