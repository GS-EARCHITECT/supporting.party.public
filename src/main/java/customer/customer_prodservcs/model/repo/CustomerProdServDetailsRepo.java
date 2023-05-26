package customer.customer_prodservcs.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import customer.customer_prodservcs.model.master.CustomerProdServDetails;

@Repository("customerProdServDetailsRepo")
public interface CustomerProdServDetailsRepo extends JpaRepository<CustomerProdServDetails, Long> 
{
	@Query(value = "SELECT * FROM Customer_ProdServ_Details a WHERE a.CUST_PRODSERV_SEQ_NO in :ids order by CUST_PRODSERV_SEQ_NO", nativeQuery = true)
	ArrayList<CustomerProdServDetails> getSelectCustomerProdServDetails(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "SELECT * FROM Customer_ProdServ_Details a WHERE a.asset_seq_no in :ids order by asset_seq_no", nativeQuery = true)
	ArrayList<CustomerProdServDetails> getSelectCustomerAssets(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "SELECT * FROM Customer_ProdServ_Details a WHERE a.resource_seq_no in :ids order by resource_seq_no", nativeQuery = true)
	ArrayList<CustomerProdServDetails> getSelectCustomerResources(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "SELECT * FROM Customer_ProdServ_Details a WHERE a.service_seq_no in :ids order by service_seq_no", nativeQuery = true)
	ArrayList<CustomerProdServDetails> getSelectCustomerServices(@Param("ids") ArrayList<Long> ids);

	@Query(value = "DELETE FROM Customer_ProdServ_Details WHERE a.asset_seq_no in :ids", nativeQuery = true)
	void delSelectCustomerAssets(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM Customer_ProdServ_Details WHERE a.resource_seq_no in :ids", nativeQuery = true)
	void delSelectCustomerResources(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM Customer_ProdServ_Details WHERE a.service_seq_no in :ids", nativeQuery = true)
	void delSelectCustomerServices(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM Customer_ProdServ_Details WHERE a.CUST_PRODSERV_SEQ_NO in :ids", nativeQuery = true)
	void delSelectCustomerProdServDetails(@Param("ids") ArrayList<Long> ids);
}
