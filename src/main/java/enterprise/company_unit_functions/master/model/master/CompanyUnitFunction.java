package enterprise.company_unit_functions.master.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the COMPANY_UNIT_FUNCTIONS database table.
 * 
 */
@Entity
@Table(name = "COMPANY_UNIT_FUNCTIONS")
public class CompanyUnitFunction implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7998213785194992204L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMPANY_FUNCTION_SEQ")
	@SequenceGenerator(name = "COMPANY_FUNCTION_SEQ", sequenceName = "COMPANY_FUNCTION_SEQ", allocationSize = 1)
	@Column(name = "COMPANY_FUNCTION_SEQ_NO")
	private Long companyFunctionSeqNo;

	@Column(name = "COMPANY_UNIT_SEQ_NO")
	private Long companyUnitSeqNo;

	@Column(name = "FUNCTION_SEQ_NO")
	private Long functionSeqNo;

	@Column(name = "REMARK")
	private String remark;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "UNIT_FUNCTION_ID")
	private String unitFunctionId;

	public CompanyUnitFunction() {
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
		CompanyUnitFunction other = (CompanyUnitFunction) obj;
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

	public CompanyUnitFunction(Long companyFunctionSeqNo, Long companyUnitSeqNo, Long functionSeqNo, String remark,
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