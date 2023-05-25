package enterprise.company_unit_services.model.dto;

import java.io.Serializable;

public class CompanyUnitServiceMasterDTO implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3585331501788101083L;
	private Long companyServiceSeqNo;
	private Long companyUnitSeqNo;
	private String remark;
	private Long serviceSeqNo;
	private String status;
	private String unitServiceId;

	public Long getCompanyServiceSeqNo() {
		return companyServiceSeqNo;
	}

	public void setCompanyServiceSeqNo(Long companyServiceSeqNo) {
		this.companyServiceSeqNo = companyServiceSeqNo;
	}

	public Long getCompanyUnitSeqNo() {
		return companyUnitSeqNo;
	}

	public void setCompanyUnitSeqNo(Long companyUnitSeqNo) {
		this.companyUnitSeqNo = companyUnitSeqNo;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public String getUnitServiceId() {
		return unitServiceId;
	}

	public void setUnitServiceId(String unitServiceId) {
		this.unitServiceId = unitServiceId;
	}

	public CompanyUnitServiceMasterDTO(Long companyServiceSeqNo, Long companyUnitSeqNo, String remark, Long serviceSeqNo,
			String status, String unitServiceId) {
		super();
		this.companyServiceSeqNo = companyServiceSeqNo;
		this.companyUnitSeqNo = companyUnitSeqNo;
		this.remark = remark;
		this.serviceSeqNo = serviceSeqNo;
		this.status = status;
		this.unitServiceId = unitServiceId;
	}

	public CompanyUnitServiceMasterDTO() {
		super();
	}

}