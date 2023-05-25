package enterprise.company_units.master.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the COMPANY_UNITS database table.
 * 
 */
@Entity
@Table(name = "COMPANY_UNITS")
public class CompanyUnit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2589837660238631176L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_unit_sequence_no")
	@SequenceGenerator(name = "company_unit_sequence_no", sequenceName = "company_unit_sequence_no", allocationSize = 1)
	@Column(name = "COMPANY_UNIT_SEQUENCE_NO")
	private Long companyUnitSequenceNo;

	@Column(name = "UNIT_CLASS_SEQ_NO")
	private Long companyUnitClassSequenceNo;

	@Column(name = "COMPANY_SEQ_NO")
	private Long companySeqNo;

	@Column(name = "COMPANY_UNIT")
	private String companyUnit;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "REMARK")
	private String remark;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "UNIT_SEQ_NO")
	private Long unitSeqNo;

	public CompanyUnit() {
	}

	public Long getCompanyUnitSequenceNo() {
		return this.companyUnitSequenceNo;
	}

	public void setCompanyUnitSequenceNo(Long companyUnitSequenceNo) {
		this.companyUnitSequenceNo = companyUnitSequenceNo;
	}

	public Long getCompanySeqNo() {
		return this.companySeqNo;
	}

	public void setCompanySeqNo(Long companySeqNo) {
		this.companySeqNo = companySeqNo;
	}

	public String getCompanyUnit() {
		return this.companyUnit;
	}

	public void setCompanyUnit(String companyUnit) {
		this.companyUnit = companyUnit;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Long getUnitSeqNo() {
		return this.unitSeqNo;
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

	public CompanyUnit(Long companyUnitSequenceNo, Long companyUnitClassSequenceNo, Long companySeqNo,
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companySeqNo == null) ? 0 : companySeqNo.hashCode());
		result = prime * result + ((companyUnit == null) ? 0 : companyUnit.hashCode());
		result = prime * result + ((companyUnitClassSequenceNo == null) ? 0 : companyUnitClassSequenceNo.hashCode());
		result = prime * result + ((companyUnitSequenceNo == null) ? 0 : companyUnitSequenceNo.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((unitSeqNo == null) ? 0 : unitSeqNo.hashCode());
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
		CompanyUnit other = (CompanyUnit) obj;
		if (companySeqNo == null) {
			if (other.companySeqNo != null)
				return false;
		} else if (!companySeqNo.equals(other.companySeqNo))
			return false;
		if (companyUnit == null) {
			if (other.companyUnit != null)
				return false;
		} else if (!companyUnit.equals(other.companyUnit))
			return false;
		if (companyUnitClassSequenceNo == null) {
			if (other.companyUnitClassSequenceNo != null)
				return false;
		} else if (!companyUnitClassSequenceNo.equals(other.companyUnitClassSequenceNo))
			return false;
		if (companyUnitSequenceNo == null) {
			if (other.companyUnitSequenceNo != null)
				return false;
		} else if (!companyUnitSequenceNo.equals(other.companyUnitSequenceNo))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
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
		if (unitSeqNo == null) {
			if (other.unitSeqNo != null)
				return false;
		} else if (!unitSeqNo.equals(other.unitSeqNo))
			return false;
		return true;
	}

}