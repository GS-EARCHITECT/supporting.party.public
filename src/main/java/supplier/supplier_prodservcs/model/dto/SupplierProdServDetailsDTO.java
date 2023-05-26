package supplier.supplier_prodservcs.model.dto;

import java.io.Serializable;

public class SupplierProdServDetailsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9025251631684379954L;
	private Long suppProdservSeqNo;
	private Long assetSeqNo;
	private String remark;
	private Long resourceSeqNo;
	private Long serviceSeqNo;
	private String status;
	private Long supplierSeqNo;

	public Long getSuppProdservSeqNo() {
		return suppProdservSeqNo;
	}

	public void setSuppProdservSeqNo(Long suppProdservSeqNo) {
		this.suppProdservSeqNo = suppProdservSeqNo;
	}

	public Long getAssetSeqNo() {
		return assetSeqNo;
	}

	public void setAssetSeqNo(Long assetSeqNo) {
		this.assetSeqNo = assetSeqNo;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getResourceSeqNo() {
		return resourceSeqNo;
	}

	public void setResourceSeqNo(Long resourceSeqNo) {
		this.resourceSeqNo = resourceSeqNo;
	}

	public Long getServiceSeqNo() {
		return serviceSeqNo;
	}

	public void setServiceSeqNo(Long serviceSeqNo) {
		this.serviceSeqNo = serviceSeqNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getSupplierSeqNo() {
		return supplierSeqNo;
	}

	public void setSupplierSeqNo(Long supplierSeqNo) {
		this.supplierSeqNo = supplierSeqNo;
	}

	public SupplierProdServDetailsDTO(Long suppProdservSeqNo, Long assetSeqNo, String remark, Long resourceSeqNo,
			Long serviceSeqNo, String status, Long supplierSeqNo) {
		super();
		this.suppProdservSeqNo = suppProdservSeqNo;
		this.assetSeqNo = assetSeqNo;
		this.remark = remark;
		this.resourceSeqNo = resourceSeqNo;
		this.serviceSeqNo = serviceSeqNo;
		this.status = status;
		this.supplierSeqNo = supplierSeqNo;
	}

	public SupplierProdServDetailsDTO() {
		super();
	}

}