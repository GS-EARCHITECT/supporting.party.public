package enterprise.masters.unit.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the COMPANY_UNIT_MASTER database table.
 * 
 */
@Entity
@Table(name = "COMPANY_UNIT_MASTER")
public class CompanyUnitMaster implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 454939421889205516L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_unit_sequence")
	@SequenceGenerator(name = "company_unit_sequence", sequenceName = "company_unit_sequence", allocationSize = 1)
	@Column(name = "UNIT_SEQ_NO")
	private Long unitSeqNo;

	@Column(name = "UNIT_CLASS_SEQ_NO")
	private Long unitClassSeqNo;

	@Column(name = "REMARK")
	private String remark;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "UNIT")
	private String unit;

	public CompanyUnitMaster() {
	}

	public Long getUnitSeqNo() {
		return this.unitSeqNo;
	}

	public void setUnitSeqNo(Long unitSeqNo) {
		this.unitSeqNo = unitSeqNo;
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

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Long getUnitClassSeqNo() {
		return unitClassSeqNo;
	}

	public void setUnitClassSeqNo(Long unitClassSeqNo) {
		this.unitClassSeqNo = unitClassSeqNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((unit == null) ? 0 : unit.hashCode());
		result = prime * result + ((unitClassSeqNo == null) ? 0 : unitClassSeqNo.hashCode());
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
		CompanyUnitMaster other = (CompanyUnitMaster) obj;
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
		if (unit == null) {
			if (other.unit != null)
				return false;
		} else if (!unit.equals(other.unit))
			return false;
		if (unitClassSeqNo == null) {
			if (other.unitClassSeqNo != null)
				return false;
		} else if (!unitClassSeqNo.equals(other.unitClassSeqNo))
			return false;
		if (unitSeqNo == null) {
			if (other.unitSeqNo != null)
				return false;
		} else if (!unitSeqNo.equals(other.unitSeqNo))
			return false;
		return true;
	}

	public CompanyUnitMaster(Long unitSeqNo, Long unitClassSeqNo, String remark, String status, String unit) {
		super();
		this.unitSeqNo = unitSeqNo;
		this.unitClassSeqNo = unitClassSeqNo;
		this.remark = remark;
		this.status = status;
		this.unit = unit;
	}

}