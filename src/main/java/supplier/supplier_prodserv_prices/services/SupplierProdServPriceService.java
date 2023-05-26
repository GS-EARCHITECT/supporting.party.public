package supplier.supplier_prodserv_prices.services;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import supplier.supplier_prodserv_prices.model.dto.SupplierProdServPriceDTO;
import supplier.supplier_prodserv_prices.model.master.SupplierProdServPrice;
import supplier.supplier_prodserv_prices.model.repo.SupplierProdServPriceRepo;

@Service("supplierProdServPriceServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class SupplierProdServPriceService implements I_SupplierProdServPriceService {

	@Autowired
	private SupplierProdServPriceRepo supplierProdServPriceRepo;

	public SupplierProdServPriceDTO newSupplierProdServPrice(SupplierProdServPriceDTO lProdServPrices) {
		if (!supplierProdServPriceRepo.existsById(lProdServPrices.getProdservPriceSeqNo())) {
			lProdServPrices = getSupplierProdServPriceDTO(
					supplierProdServPriceRepo.save(this.setSupplierProdServPrice(lProdServPrices)));
		}
		return lProdServPrices;
	}

	public ArrayList<SupplierProdServPriceDTO> getAllSupplierProdServPrices() 
	{
		ArrayList<SupplierProdServPrice> supplierList = (ArrayList<SupplierProdServPrice>) supplierProdServPriceRepo
				.findAll();
		ArrayList<SupplierProdServPriceDTO> lProdServPricess = new ArrayList<SupplierProdServPriceDTO>();
		lProdServPricess = supplierList != null ? this.getSupplierProdServPriceDTOs(supplierList) : null;
		return lProdServPricess;
	}

	public ArrayList<SupplierProdServPriceDTO> getSelectSupplierProdServPrices(ArrayList<Long> ids) 
	{
		ArrayList<SupplierProdServPrice> lProdServPrices = supplierProdServPriceRepo.getSelectSupplierProdServPrices(ids);
		ArrayList<SupplierProdServPriceDTO> supplierProdServPriceDTOs = lProdServPrices != null ? this.getSupplierProdServPriceDTOs(lProdServPrices) : null;
		return supplierProdServPriceDTOs;
	}

	public ArrayList<SupplierProdServPriceDTO> getSelectSupplierProdServPricesBetweenTimes(ArrayList<Long> ids, String frDtTm, String toDtTm) 
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime frDateTime = LocalDateTime.parse(frDtTm, formatter);
		LocalDateTime toDateTime = LocalDateTime.parse(toDtTm, formatter);
		Timestamp frTsTimestamp = Timestamp.valueOf(frDateTime);
		Timestamp toTsTimestamp = Timestamp.valueOf(toDateTime);
		ArrayList<SupplierProdServPrice> lProdServPrices = supplierProdServPriceRepo.getSelectSupplierProdServPricesBetweenTimes(ids, frTsTimestamp, toTsTimestamp);
		ArrayList<SupplierProdServPriceDTO> supplierProdServPriceDTOs = lProdServPrices != null	? this.getSupplierProdServPriceDTOs(lProdServPrices) : null;
		return supplierProdServPriceDTOs;
	}

	
	public void updSupplierProdServPrice(SupplierProdServPriceDTO lProdServPrice) {
		SupplierProdServPrice supplierProdServPrice = this.setSupplierProdServPrice(lProdServPrice);

		if (supplierProdServPriceRepo.existsById(lProdServPrice.getProdservPriceSeqNo()))
				{
			supplierProdServPrice.setProdservPriceSeqNo(lProdServPrice.getProdservPriceSeqNo());
			supplierProdServPriceRepo.save(supplierProdServPrice);
		}
		return;
	}

	public void delSelectSupplierProdServPrices(ArrayList<Long> ids) 
	{
		supplierProdServPriceRepo.delSelectSupplierProdServPrices(ids);
		return;
	}

	
	public void delSelectSupplierProdServPricesBetweenTimes(ArrayList<Long> ids, String frDtTm, String toDtTm) 
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime frDateTime = LocalDateTime.parse(frDtTm, formatter);
		LocalDateTime toDateTime = LocalDateTime.parse(toDtTm, formatter);
		Timestamp frTsTimestamp = Timestamp.valueOf(frDateTime);
		Timestamp toTsTimestamp = Timestamp.valueOf(toDateTime);		
		supplierProdServPriceRepo.delSelectSupplierProdServPricesBetweenTimes(ids, frTsTimestamp, toTsTimestamp);
		return;
	}

	public void delAllSupplierProdServPrices() 
	{
		supplierProdServPriceRepo.deleteAll();
	}

	private ArrayList<SupplierProdServPriceDTO> getSupplierProdServPriceDTOs(
			ArrayList<SupplierProdServPrice> lProdServPrices) {
		SupplierProdServPriceDTO lDTO = null;
		ArrayList<SupplierProdServPriceDTO> lProdServPriceDTOs = new ArrayList<SupplierProdServPriceDTO>();
		for (int i = 0; i < lProdServPrices.size(); i++) {
			lDTO = getSupplierProdServPriceDTO(lProdServPrices.get(i));
			lProdServPriceDTOs.add(lDTO);
		}
		return lProdServPriceDTOs;
	}

	private SupplierProdServPriceDTO getSupplierProdServPriceDTO(SupplierProdServPrice lProdServPrice) {
		SupplierProdServPriceDTO lDTO = new SupplierProdServPriceDTO();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		lDTO.setFrDttm(formatter.format(lProdServPrice.getFrDttm().toLocalDateTime()));
		lDTO.setToDttm(formatter.format(lProdServPrice.getToDttm().toLocalDateTime()));		
		lDTO.setAmount(lProdServPrice.getAmount());
		lDTO.setAmtUnitSeqNo(lProdServPrice.getAmtUnitSeqNo());
		lDTO.setDiscPerc(lProdServPrice.getDiscPerc());
		lDTO.setDiscVal(lProdServPrice.getDiscVal());
		lDTO.setQty(lProdServPrice.getQty());
		lDTO.setQtyUnitSeqNo(lProdServPrice.getQtyUnitSeqNo());
		lDTO.setTaxPerc(lProdServPrice.getTaxPerc());
		lDTO.setTaxVal(lProdServPrice.getTaxVal());		
		lDTO.setSuppProdservSeqNo(lProdServPrice.getSuppProdservSeqNo());
		lDTO.setStatus(lProdServPrice.getStatus());
		lDTO.setRemark(lProdServPrice.getRemark());
		lDTO.setProdservPriceSeqNo(lProdServPrice.getProdservPriceSeqNo());
		return lDTO;
	}

	private SupplierProdServPrice setSupplierProdServPrice(SupplierProdServPriceDTO lDTO) 
	{
		SupplierProdServPrice lProdServPrice = new SupplierProdServPrice();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime frDateTime = LocalDateTime.parse(lDTO.getFrDttm(), formatter);
		LocalDateTime toDateTime = LocalDateTime.parse(lDTO.getToDttm(), formatter);
		Timestamp frTsTimestamp = Timestamp.valueOf(frDateTime);
		Timestamp toTsTimestamp = Timestamp.valueOf(toDateTime);	
		lProdServPrice.setFrDttm(frTsTimestamp);
		lProdServPrice.setToDttm(toTsTimestamp);		
		lProdServPrice.setAmount(lProdServPrice.getAmount());
		lProdServPrice.setAmtUnitSeqNo(lProdServPrice.getAmtUnitSeqNo());
		lProdServPrice.setDiscPerc(lProdServPrice.getDiscPerc());
		lProdServPrice.setDiscVal(lProdServPrice.getDiscVal());
		lProdServPrice.setQty(lProdServPrice.getQty());
		lProdServPrice.setQtyUnitSeqNo(lProdServPrice.getQtyUnitSeqNo());
		lProdServPrice.setTaxPerc(lProdServPrice.getTaxPerc());
		lProdServPrice.setTaxVal(lProdServPrice.getTaxVal());		
		lProdServPrice.setSuppProdservSeqNo(lProdServPrice.getSuppProdservSeqNo());
		lProdServPrice.setStatus(lProdServPrice.getStatus());
		lProdServPrice.setRemark(lProdServPrice.getRemark());		
		return lProdServPrice;
	}
}