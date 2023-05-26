package supplier.supplier_prodservcs.model.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import supplier.supplier_prodservcs.model.master.SupplierProdServDetails;

@Repository("supplierProdServDetailsRepo")
public interface SupplierProdServDetailsRepo extends JpaRepository<SupplierProdServDetails, Long> 
{
	@Query(value = "SELECT * FROM Supplier_ProdServ_Details a WHERE a.SUPP_PRODSERV_SEQ_NO in :ids order by SUPP_PRODSERV_SEQ_NO", nativeQuery = true)
	ArrayList<SupplierProdServDetails> getSelectSupplierProdServDetails(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "SELECT * FROM Supplier_ProdServ_Details a WHERE a.asset_seq_no in :ids order by asset_seq_no", nativeQuery = true)
	ArrayList<SupplierProdServDetails> getSelectSupplierAssets(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "SELECT * FROM Supplier_ProdServ_Details a WHERE a.resource_seq_no in :ids order by resource_seq_no", nativeQuery = true)
	ArrayList<SupplierProdServDetails> getSelectSupplierResources(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "SELECT * FROM Supplier_ProdServ_Details a WHERE a.service_seq_no in :ids order by service_seq_no", nativeQuery = true)
	ArrayList<SupplierProdServDetails> getSelectSupplierServices(@Param("ids") ArrayList<Long> ids);

	@Query(value = "DELETE FROM Supplier_ProdServ_Details WHERE a.asset_seq_no in :ids", nativeQuery = true)
	void delSelectSupplierAssets(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM Supplier_ProdServ_Details WHERE a.resource_seq_no in :ids", nativeQuery = true)
	void delSelectSupplierResources(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM Supplier_ProdServ_Details WHERE a.service_seq_no in :ids", nativeQuery = true)
	void delSelectSupplierServices(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM Supplier_ProdServ_Details WHERE a.SUPP_PRODSERV_SEQ_NO in :ids", nativeQuery = true)
	void delSelectSupplierProdServDetails(@Param("ids") ArrayList<Long> ids);
}
