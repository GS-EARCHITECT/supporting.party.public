package supplier.supplier_prodserv_prices.model.repo;

import java.sql.Timestamp;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import supplier.supplier_prodserv_prices.model.master.SupplierProdServPrice;

@Repository("supplierProdServPriceRepo")
public interface SupplierProdServPriceRepo extends JpaRepository<SupplierProdServPrice, Long> {

	@Query(value = "SELECT * FROM Supplier_ProdServ_Price a WHERE (a.PRODSERV_PRICE_SEQ_NO in :ids and ((:frDtTm BETWEEN b.FR_DTTM and b.TO_DTTM) and (:toDtTm BETWEEN b.FR_DTTM and b.TO_DTTM))) order by PRODSERV_PRICE_SEQ_NO", nativeQuery = true)
	ArrayList<SupplierProdServPrice> getSelectSupplierProdServPricesBetweenTimes(@Param("ids") ArrayList<Long> ids,
			@Param("frDtTm") Timestamp frDtTm, @Param("toDtTm") Timestamp toDtTm);

	@Query(value = "SELECT * FROM Supplier_ProdServ_Price a WHERE a.PRODSERV_PRICE_SEQ_NO in :ids order by PRODSERV_PRICE_SEQ_NO", nativeQuery = true)
	ArrayList<SupplierProdServPrice> getSelectSupplierProdServPrices(@Param("ids") ArrayList<Long> ids);

	@Query(value = "DELETE FROM Supplier_ProdServ_Price a WHERE (a.PRODSERV_PRICE_SEQ_NO in :ids and ((:frDtTm BETWEEN b.FR_DTTM and b.TO_DTTM) and (:toDtTm BETWEEN b.FR_DTTM and b.TO_DTTM)))", nativeQuery = true)
	void delSelectSupplierProdServPricesBetweenTimes(@Param("ids") ArrayList<Long> ids,
			@Param("frDtTm") Timestamp frDtTm, @Param("toDtTm") Timestamp toDtTm);

	@Query(value = "DELETE FROM Supplier_ProdServ_Price a WHERE a.PRODSERV_PRICE_SEQ_NO in :ids", nativeQuery = true)
	void delSelectSupplierProdServPrices(@Param("ids") ArrayList<Long> ids);

}
