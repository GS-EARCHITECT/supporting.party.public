package supplier.supplier_prodserv_prices.services;

import java.util.ArrayList;

import supplier.supplier_prodserv_prices.model.dto.SupplierProdServPriceDTO;

public interface I_SupplierProdServPriceService
{
	public SupplierProdServPriceDTO newSupplierProdServPrice(SupplierProdServPriceDTO supplierProdServPriceDTO);
    public ArrayList<SupplierProdServPriceDTO> getAllSupplierProdServPrices();
    public ArrayList<SupplierProdServPriceDTO> getSelectSupplierProdServPrices(ArrayList<Long> ids);
    public ArrayList<SupplierProdServPriceDTO> getSelectSupplierProdServPricesBetweenTimes(ArrayList<Long> ids, String frDtTm, String toDtTm);
    public void updSupplierProdServPrice(SupplierProdServPriceDTO supplierProdServPriceDTO);
    public void delAllSupplierProdServPrices();
    public void delSelectSupplierProdServPricesBetweenTimes(ArrayList<Long> ids, String frDtTm, String toDtTm);
    public void delSelectSupplierProdServPrices(ArrayList<Long> ids);
}



