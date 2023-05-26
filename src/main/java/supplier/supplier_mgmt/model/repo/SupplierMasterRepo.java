package supplier.supplier_mgmt.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import supplier.supplier_mgmt.model.master.SupplierMaster;

@Repository("supplierMasterRepo")
public interface SupplierMasterRepo extends JpaRepository<SupplierMaster, Long> 
{
	@Query(value = "SELECT * FROM Supplier_Master a WHERE a.supplier_seq_no in :ids order by supplier_seq_no", nativeQuery = true)
	ArrayList<SupplierMaster> getSelectSuppliers(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM Supplier_Master WHERE a.supplier_seq_no in :ids", nativeQuery = true)
	void delSelectSuppliers(@Param("ids") ArrayList<Long> ids);	
}
