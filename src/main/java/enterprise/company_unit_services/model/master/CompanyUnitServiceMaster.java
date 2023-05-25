package enterprise.company_unit_services.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the COMPANY_UNIT_SERVICES database table.
 * 
 */
@Entity
@Table(name = "COMPANY_UNIT_SERVICES")
public class CompanyUnitServiceMaster implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 148504560499258414L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMPANY_SERVICE_SEQ_NO")
	@SequenceGenerator(name = "COMPANY_SERVICE_SEQ_NO", sequenceName = "COMPANY_SERVICE_SEQ_NO", allocationSize = 1)
	@Column(name = "COMPANY_SERVICE_SEQ_NO")
	private Long companyServiceSeqNo;

	@Column(name = "COMPANY_UNIT_SEQ_NO")
	private Long companyUnitSeqNo;

	@Column(name = "REMARK")
	private String remark;

	@Column(name = "SERVICE_SEQ_NO")
	private Long serviceSeqNo;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "UNIT_SERVICE_ID")
	private String unitServiceId;

	public CompanyUnitServiceMaster() {
	}

	public Long getCompanyServiceSeqNo() {
		return this.companyServiceSeqNo;
	}

	public void setCompanyServiceSeqNo(Long companyServiceSeqNo) {
		this.companyServiceSeqNo = companyServiceSeqNo;
	}

	public Long getCompanyUnitSeqNo() {
		return this.companyUnitSeqNo;
	}

	public void setCompanyUnitSeqNo(Long companyUnitSeqNo) {
		this.companyUnitSeqNo = companyUnitSeqNo;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getServiceSeqNo() {
		return this.serviceSeqNo;
	}

	public void setServiceSeqNo(Long serviceSeqNo) {
		this.serviceSeqNo = serviceSeqNo;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUnitServiceId() {
		return this.unitServiceId;
	}

	public void setUnitServiceId(String unitServiceId) {
		this.unitServiceId = unitServiceId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companyServiceSeqNo == null) ? 0 : companyServiceSeqNo.hashCode());
		result = prime * result + ((companyUnitSeqNo == null) ? 0 : companyUnitSeqNo.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((serviceSeqNo == null) ? 0 : serviceSeqNo.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((unitServiceId == null) ? 0 : unitServiceId.hashCode());
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
		CompanyUnitServiceMaster other = (CompanyUnitServiceMaster) obj;
		if (companyServiceSeqNo == null) {
			if (other.companyServiceSeqNo != null)
				return false;
		} else if (!companyServiceSeqNo.equals(other.companyServiceSeqNo))
			return false;
		if (companyUnitSeqNo == null) {
			if (other.companyUnitSeqNo != null)
				return false;
		} else if (!companyUnitSeqNo.equals(other.companyUnitSeqNo))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (serviceSeqNo == null) {
			if (other.serviceSeqNo != null)
				return false;
		} else if (!serviceSeqNo.equals(other.serviceSeqNo))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (unitServiceId == null) {
			if (other.unitServiceId != null)
				return false;
		} else if (!unitServiceId.equals(other.unitServiceId))
			return false;
		return true;
	}

	public CompanyUnitServiceMaster(Long companyServiceSeqNo, Long companyUnitSeqNo, String remark, Long serviceSeqNo,
			String status, String unitServiceId) {
		super();
		this.companyServiceSeqNo = companyServiceSeqNo;
		this.companyUnitSeqNo = companyUnitSeqNo;
		this.remark = remark;
		this.serviceSeqNo = serviceSeqNo;
		this.status = status;
		this.unitServiceId = unitServiceId;
	}

}