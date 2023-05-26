package supplier.supplier_prodserv_prices.model.dto;

import java.io.Serializable;

public class SupplierProdServPriceDTO implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6532985119316333247L;
	private Long prodservPriceSeqNo;
	private Float amount;
	private Float amtUnitSeqNo;
	private Float discPerc;
	private Float discVal;
	private String frDttm;
	private Float qty;
	private Long qtyUnitSeqNo;
	private String remark;
	private String status;
	private Long suppProdservSeqNo;
	private Float taxPerc;
	private Float taxVal;
	private String toDttm;

	public Long getProdservPriceSeqNo() {
		return prodservPriceSeqNo;
	}

	public void setProdservPriceSeqNo(Long prodservPriceSeqNo) {
		this.prodservPriceSeqNo = prodservPriceSeqNo;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public Float getAmtUnitSeqNo() {
		return amtUnitSeqNo;
	}

	public void setAmtUnitSeqNo(Float amtUnitSeqNo) {
		this.amtUnitSeqNo = amtUnitSeqNo;
	}

	public Float getDiscPerc() {
		return discPerc;
	}

	public void setDiscPerc(Float discPerc) {
		this.discPerc = discPerc;
	}

	public Float getDiscVal() {
		return discVal;
	}

	public void setDiscVal(Float discVal) {
		this.discVal = discVal;
	}

	public String getFrDttm() {
		return frDttm;
	}

	public void setFrDttm(String frDttm) {
		this.frDttm = frDttm;
	}

	public Float getQty() {
		return qty;
	}

	public void setQty(Float qty) {
		this.qty = qty;
	}

	public Long getQtyUnitSeqNo() {
		return qtyUnitSeqNo;
	}

	public void setQtyUnitSeqNo(Long qtyUnitSeqNo) {
		this.qtyUnitSeqNo = qtyUnitSeqNo;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getSuppProdservSeqNo() {
		return suppProdservSeqNo;
	}

	public void setSuppProdservSeqNo(Long suppProdservSeqNo) {
		this.suppProdservSeqNo = suppProdservSeqNo;
	}

	public Float getTaxPerc() {
		return taxPerc;
	}

	public void setTaxPerc(Float taxPerc) {
		this.taxPerc = taxPerc;
	}

	public Float getTaxVal() {
		return taxVal;
	}

	public void setTaxVal(Float taxVal) {
		this.taxVal = taxVal;
	}

	public String getToDttm() {
		return toDttm;
	}

	public void setToDttm(String toDttm) {
		this.toDttm = toDttm;
	}

	public SupplierProdServPriceDTO(Long prodservPriceSeqNo, Float amount, Float amtUnitSeqNo, Float discPerc,
			Float discVal, String frDttm, Float qty, Long qtyUnitSeqNo, String remark, String status,
			Long suppProdservSeqNo, Float taxPerc, Float taxVal, String toDttm) {
		super();
		this.prodservPriceSeqNo = prodservPriceSeqNo;
		this.amount = amount;
		this.amtUnitSeqNo = amtUnitSeqNo;
		this.discPerc = discPerc;
		this.discVal = discVal;
		this.frDttm = frDttm;
		this.qty = qty;
		this.qtyUnitSeqNo = qtyUnitSeqNo;
		this.remark = remark;
		this.status = status;
		this.suppProdservSeqNo = suppProdservSeqNo;
		this.taxPerc = taxPerc;
		this.taxVal = taxVal;
		this.toDttm = toDttm;
	}

	public SupplierProdServPriceDTO() {
		super();
	}

}