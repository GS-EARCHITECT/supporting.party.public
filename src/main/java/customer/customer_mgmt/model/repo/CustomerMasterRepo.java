package customer.customer_mgmt.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import customer.customer_mgmt.model.master.CustomerMaster;

@Repository("customerMasterRepo")
public interface CustomerMasterRepo extends JpaRepository<CustomerMaster, Long> 
{
	@Query(value = "SELECT * FROM Customer_Master a WHERE a.customer_seq_no in :ids order by customer_seq_no", nativeQuery = true)
	ArrayList<CustomerMaster> getSelectCustomers(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM Customer_Master WHERE a.customer_seq_no in :ids", nativeQuery = true)
	void delSelectCustomers(@Param("ids") ArrayList<Long> ids);	
}
