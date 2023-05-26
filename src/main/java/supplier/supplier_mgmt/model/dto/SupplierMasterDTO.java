package supplier.supplier_mgmt.model.dto;

import java.io.Serializable;

public class SupplierMasterDTO implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8972390375654435614L;
	private Long supplierSeqNo;
	private Long companySeqNo;
	private Long personSeqNo;
	private String remark;
	private String status;

	public Long getSupplierSeqNo() {
		return supplierSeqNo;
	}

	public void setSupplierSeqNo(Long supplierSeqNo) {
		this.supplierSeqNo = supplierSeqNo;
	}

	public Long getCompanySeqNo() {
		return companySeqNo;
	}

	public void setCompanySeqNo(Long companySeqNo) {
		this.companySeqNo = companySeqNo;
	}

	public Long getPersonSeqNo() {
		return personSeqNo;
	}

	public void setPersonSeqNo(Long personSeqNo) {
		this.personSeqNo = personSeqNo;
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

	public SupplierMasterDTO(Long supplierSeqNo, Long companySeqNo, Long personSeqNo, String remark, String status) {
		super();
		this.supplierSeqNo = supplierSeqNo;
		this.companySeqNo = companySeqNo;
		this.personSeqNo = personSeqNo;
		this.remark = remark;
		this.status = status;
	}

	public SupplierMasterDTO() {
		super();
	}

}