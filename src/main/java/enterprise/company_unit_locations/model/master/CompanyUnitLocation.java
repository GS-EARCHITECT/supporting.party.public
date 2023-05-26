package enterprise.company_unit_locations.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the COMPANY_UNIT_LOCATIONS database table.
 * 
 */
@Entity
@Table(name = "COMPANY_UNIT_LOCATIONS")
public class CompanyUnitLocation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1563000542571922631L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMPANY_LOCATION_SEQUENCE")
	@SequenceGenerator(name = "COMPANY_LOCATION_SEQUENCE", sequenceName = "COMPANY_LOCATION_SEQUENCE", allocationSize = 1)
	@Column(name = "COMPANY_LOCATION_SEQ_NO")
	private Long companyLocationSeqNo;

	@Column(name = "COMPANY_UNIT_SEQ_NO")
	private Long companyUnitSeqNo;

	@Column(name = "LOCATION_SEQ_NO")
	private Long locationSeqNo;

	@Column(name = "REMARK")
	private String remark;

	@Column(name = "STATUS")
	private String status;

	public CompanyUnitLocation() {
	}

	public Long getCompanyLocationSeqNo() {
		return this.companyLocationSeqNo;
	}

	public void setCompanyLocationSeqNo(Long companyLocationSeqNo) {
		this.companyLocationSeqNo = companyLocationSeqNo;
	}

	public Long getCompanyUnitSeqNo() {
		return this.companyUnitSeqNo;
	}

	public void setCompanyUnitSeqNo(Long companyUnitSeqNo) {
		this.companyUnitSeqNo = companyUnitSeqNo;
	}

	public Long getLocationSeqNo() {
		return this.locationSeqNo;
	}

	public void setLocationSeqNo(Long locationSeqNo) {
		this.locationSeqNo = locationSeqNo;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companyLocationSeqNo == null) ? 0 : companyLocationSeqNo.hashCode());
		result = prime * result + ((companyUnitSeqNo == null) ? 0 : companyUnitSeqNo.hashCode());
		result = prime * result + ((locationSeqNo == null) ? 0 : locationSeqNo.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		CompanyUnitLocation other = (CompanyUnitLocation) obj;
		if (companyLocationSeqNo == null) {
			if (other.companyLocationSeqNo != null)
				return false;
		} else if (!companyLocationSeqNo.equals(other.companyLocationSeqNo))
			return false;
		if (companyUnitSeqNo == null) {
			if (other.companyUnitSeqNo != null)
				return false;
		} else if (!companyUnitSeqNo.equals(other.companyUnitSeqNo))
			return false;
		if (locationSeqNo == null) {
			if (other.locationSeqNo != null)
				return false;
		} else if (!locationSeqNo.equals(other.locationSeqNo))
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
		return true;
	}

	public CompanyUnitLocation(Long companyLocationSeqNo, Long companyUnitSeqNo, Long locationSeqNo, String remark,
			String status) {
		super();
		this.companyLocationSeqNo = companyLocationSeqNo;
		this.companyUnitSeqNo = companyUnitSeqNo;
		this.locationSeqNo = locationSeqNo;
		this.remark = remark;
		this.status = status;
	}

}