package enterprise.company_units.master.model.dto;

import java.io.Serializable;

public class CompanyUnitDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1065946105318896111L;
	private Long companyUnitSequenceNo;
	private Long companyUnitClassSequenceNo;
	private Long companySeqNo;
	private String companyUnit;
	private String description;
	private String remark;
	private String status;
	private Long unitSeqNo;

	public Long getCompanyUnitSequenceNo() {
		return companyUnitSequenceNo;
	}

	public void setCompanyUnitSequenceNo(Long companyUnitSequenceNo) {
		this.companyUnitSequenceNo = companyUnitSequenceNo;
	}

	public Long getCompanySeqNo() {
		return companySeqNo;
	}

	public void setCompanySeqNo(Long companySeqNo) {
		this.companySeqNo = companySeqNo;
	}

	public String getCompanyUnit() {
		return companyUnit;
	}

	public void setCompanyUnit(String companyUnit) {
		this.companyUnit = companyUnit;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Long getUnitSeqNo() {
		return unitSeqNo;
	}

	public void setUnitSeqNo(Long unitSeqNo) {
		this.unitSeqNo = unitSeqNo;
	}

	public Long getCompanyUnitClassSequenceNo() {
		return companyUnitClassSequenceNo;
	}

	public void setCompanyUnitClassSequenceNo(Long companyUnitClassSequenceNo) {
		this.companyUnitClassSequenceNo = companyUnitClassSequenceNo;
	}

	public CompanyUnitDTO(Long companyUnitSequenceNo, Long companyUnitClassSequenceNo, Long companySeqNo,
			String companyUnit, String description, String remark, String status, Long unitSeqNo) {
		super();
		this.companyUnitSequenceNo = companyUnitSequenceNo;
		this.companyUnitClassSequenceNo = companyUnitClassSequenceNo;
		this.companySeqNo = companySeqNo;
		this.companyUnit = companyUnit;
		this.description = description;
		this.remark = remark;
		this.status = status;
		this.unitSeqNo = unitSeqNo;
	}

	public CompanyUnitDTO() {
		super();
	}

}