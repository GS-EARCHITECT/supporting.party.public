package supplier.supplier_prodserv_prices.model.master;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the SUPPLIER_PRODSERV_PRICES database table.
 * 
 */
@Entity
@Table(name="SUPPLIER_PRODSERV_PRICES")
public class SupplierProdServPrice implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODSERV_PRICE_SEQUENCE")
	@SequenceGenerator(name = "PRODSERV_PRICE_SEQUENCE", sequenceName = "PRODSERV_PRICE_SEQUENCE", allocationSize = 1)
	@Column(name="PRODSERV_PRICE_SEQ_NO")
	private Long prodservPriceSeqNo;

	@Column(name="AMOUNT")
	private Float amount;

	@Column(name="AMT_UNIT_SEQ_NO")
	private Float amtUnitSeqNo;

	@Column(name="DISC_PERC")
	private Float discPerc;

	@Column(name="DISC_VAL")
	private Float discVal;

	@Column(name="FR_DTTM")
	private Timestamp frDttm;

	@Column(name="QTY")
	private Float qty;

	@Column(name="QTY_UNIT_SEQ_NO")
	private Long qtyUnitSeqNo;

	@Column(name="REMARK")
	private String remark;

	@Column(name="STATUS")
	private String status;

	@Column(name="SUPP_PRODSERV_SEQ_NO")
	private Long suppProdservSeqNo;

	@Column(name="TAX_PERC")
	private Float taxPerc;

	@Column(name="TAX_VAL")
	private Float taxVal;

	@Column(name="TO_DTTM")
	private Timestamp toDttm;

	public SupplierProdServPrice() {
	}

	public long getProdservPriceSeqNo() {
		return this.prodservPriceSeqNo;
	}

	public void setProdservPriceSeqNo(long prodservPriceSeqNo) {
		this.prodservPriceSeqNo = prodservPriceSeqNo;
	}

	public Float getAmount() {
		return this.amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public Float getAmtUnitSeqNo() {
		return this.amtUnitSeqNo;
	}

	public void setAmtUnitSeqNo(Float amtUnitSeqNo) {
		this.amtUnitSeqNo = amtUnitSeqNo;
	}

	public Float getDiscPerc() {
		return this.discPerc;
	}

	public void setDiscPerc(Float discPerc) {
		this.discPerc = discPerc;
	}

	public Float getDiscVal() {
		return this.discVal;
	}

	public void setDiscVal(Float discVal) {
		this.discVal = discVal;
	}

	public Timestamp getFrDttm() {
		return this.frDttm;
	}

	public void setFrDttm(Timestamp frDttm) {
		this.frDttm = frDttm;
	}

	public Float getQty() {
		return this.qty;
	}

	public void setQty(Float qty) {
		this.qty = qty;
	}

	public Long getQtyUnitSeqNo() {
		return this.qtyUnitSeqNo;
	}

	public void setQtyUnitSeqNo(Long qtyUnitSeqNo) {
		this.qtyUnitSeqNo = qtyUnitSeqNo;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getSuppProdservSeqNo() {
		return this.suppProdservSeqNo;
	}

	public void setSuppProdservSeqNo(Long suppProdservSeqNo) {
		this.suppProdservSeqNo = suppProdservSeqNo;
	}

	public Float getTaxPerc() {
		return this.taxPerc;
	}

	public void setTaxPerc(Float taxPerc) {
		this.taxPerc = taxPerc;
	}

	public Float getTaxVal() {
		return this.taxVal;
	}

	public void setTaxVal(Float taxVal) {
		this.taxVal = taxVal;
	}

	public Timestamp getToDttm() {
		return this.toDttm;
	}

	public void setToDttm(Timestamp toDttm) {
		this.toDttm = toDttm;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((amtUnitSeqNo == null) ? 0 : amtUnitSeqNo.hashCode());
		result = prime * result + ((discPerc == null) ? 0 : discPerc.hashCode());
		result = prime * result + ((discVal == null) ? 0 : discVal.hashCode());
		result = prime * result + ((frDttm == null) ? 0 : frDttm.hashCode());
		result = prime * result + ((prodservPriceSeqNo == null) ? 0 : prodservPriceSeqNo.hashCode());
		result = prime * result + ((qty == null) ? 0 : qty.hashCode());
		result = prime * result + ((qtyUnitSeqNo == null) ? 0 : qtyUnitSeqNo.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((suppProdservSeqNo == null) ? 0 : suppProdservSeqNo.hashCode());
		result = prime * result + ((taxPerc == null) ? 0 : taxPerc.hashCode());
		result = prime * result + ((taxVal == null) ? 0 : taxVal.hashCode());
		result = prime * result + ((toDttm == null) ? 0 : toDttm.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SupplierProdServPrice other = (SupplierProdServPrice) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (amtUnitSeqNo == null) {
			if (other.amtUnitSeqNo != null)
				return false;
		} else if (!amtUnitSeqNo.equals(other.amtUnitSeqNo))
			return false;
		if (discPerc == null) {
			if (other.discPerc != null)
				return false;
		} else if (!discPerc.equals(other.discPerc))
			return false;
		if (discVal == null) {
			if (other.discVal != null)
				return false;
		} else if (!discVal.equals(other.discVal))
			return false;
		if (frDttm == null) {
			if (other.frDttm != null)
				return false;
		} else if (!frDttm.equals(other.frDttm))
			return false;
		if (prodservPriceSeqNo == null) {
			if (other.prodservPriceSeqNo != null)
				return false;
		} else if (!prodservPriceSeqNo.equals(other.prodservPriceSeqNo))
			return false;
		if (qty == null) {
			if (other.qty != null)
				return false;
		} else if (!qty.equals(other.qty))
			return false;
		if (qtyUnitSeqNo == null) {
			if (other.qtyUnitSeqNo != null)
				return false;
		} else if (!qtyUnitSeqNo.equals(other.qtyUnitSeqNo))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (suppProdservSeqNo == null) {
			if (other.suppProdservSeqNo != null)
				return false;
		} else if (!suppProdservSeqNo.equals(other.suppProdservSeqNo))
			return false;
		if (taxPerc == null) {
			if (other.taxPerc != null)
				return false;
		} else if (!taxPerc.equals(other.taxPerc))
			return false;
		if (taxVal == null) {
			if (other.taxVal != null)
				return false;
		} else if (!taxVal.equals(other.taxVal))
			return false;
		if (toDttm == null) {
			if (other.toDttm != null)
				return false;
		} else if (!toDttm.equals(other.toDttm))
			return false;
		return true;
	}

	public SupplierProdServPrice(Long prodservPriceSeqNo, Float amount, Float amtUnitSeqNo, Float discPerc,
			Float discVal, Timestamp frDttm, Float qty, Long qtyUnitSeqNo, String remark, String status,
			Long suppProdservSeqNo, Float taxPerc, Float taxVal, Timestamp toDttm) {
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
	
	

}