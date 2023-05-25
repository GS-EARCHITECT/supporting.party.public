package enterprise.company_unit_functions.master.model.dto;

import java.io.Serializable;

public class CompanyUnitFunctionDTO implements Serializable 
{


	/**
	 * 
	 */
	private static final long serialVersionUID = 8380622317708225881L;
	private Long companyFunctionSeqNo;
	private Long companyUnitSeqNo;
	private Long functionSeqNo;
	private String remark;
	private String status;
	private String unitFunctionId;

	public CompanyUnitFunctionDTO() {
	}

	public Long getCompanyFunctionSeqNo() {
		return this.companyFunctionSeqNo;
	}

	public void setCompanyFunctionSeqNo(Long companyFunctionSeqNo) {
		this.companyFunctionSeqNo = companyFunctionSeqNo;
	}

	public Long getCompanyUnitSeqNo() {
		return this.companyUnitSeqNo;
	}

	public void setCompanyUnitSeqNo(Long companyUnitSeqNo) {
		this.companyUnitSeqNo = companyUnitSeqNo;
	}

	public Long getFunctionSeqNo() {
		return this.functionSeqNo;
	}

	public void setFunctionSeqNo(Long functionSeqNo) {
		this.functionSeqNo = functionSeqNo;
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

	public String getUnitFunctionId() {
		return this.unitFunctionId;
	}

	public void setUnitFunctionId(String unitFunctionId) {
		this.unitFunctionId = unitFunctionId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companyFunctionSeqNo == null) ? 0 : companyFunctionSeqNo.hashCode());
		result = prime * result + ((companyUnitSeqNo == null) ? 0 : companyUnitSeqNo.hashCode());
		result = prime * result + ((functionSeqNo == null) ? 0 : functionSeqNo.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((unitFunctionId == null) ? 0 : unitFunctionId.hashCode());
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
		CompanyUnitFunctionDTO other = (CompanyUnitFunctionDTO) obj;
		if (companyFunctionSeqNo == null) {
			if (other.companyFunctionSeqNo != null)
				return false;
		} else if (!companyFunctionSeqNo.equals(other.companyFunctionSeqNo))
			return false;
		if (companyUnitSeqNo == null) {
			if (other.companyUnitSeqNo != null)
				return false;
		} else if (!companyUnitSeqNo.equals(other.companyUnitSeqNo))
			return false;
		if (functionSeqNo == null) {
			if (other.functionSeqNo != null)
				return false;
		} else if (!functionSeqNo.equals(other.functionSeqNo))
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
		if (unitFunctionId == null) {
			if (other.unitFunctionId != null)
				return false;
		} else if (!unitFunctionId.equals(other.unitFunctionId))
			return false;
		return true;
	}

	public CompanyUnitFunctionDTO(Long companyFunctionSeqNo, Long companyUnitSeqNo, Long functionSeqNo, String remark,
			String status, String unitFunctionId) {
		super();
		this.companyFunctionSeqNo = companyFunctionSeqNo;
		this.companyUnitSeqNo = companyUnitSeqNo;
		this.functionSeqNo = functionSeqNo;
		this.remark = remark;
		this.status = status;
		this.unitFunctionId = unitFunctionId;
	}

}