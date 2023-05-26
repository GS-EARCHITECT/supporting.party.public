package enterprise.company_unit_roles.master.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the COMPANY_UNIT_ROLES database table.
 * 
 */
@Entity
@Table(name = "COMPANY_UNIT_ROLES")
public class CompanyUnitRole implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8730603685480848212L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMPANY_UNIT_ROLE_SEQUENCE")
	@SequenceGenerator(name = "COMPANY_UNIT_ROLE_SEQUENCE", sequenceName = "COMPANY_UNIT_ROLE_SEQUENCE", allocationSize = 1)
	@Column(name = "COMPANY_ROLE_SEQ_NO")
	private Long companyRoleSeqNo;

	@Column(name = "ROLE_SEQ_NO")
	private Long roleSeqNo;

	@Column(name = "COMPANY_UNIT_SEQ_NO")
	private Long companyUnitSeqNo;

	@Column(name = "ROLE_ID")
	private String roleId;

	@Column(name = "REMARK")
	private String remark;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "ROLE")
	private String role;

	public CompanyUnitRole() {
	}

	public Long getCompanyRoleSeqNo() {
		return this.companyRoleSeqNo;
	}

	public void setCompanyRoleSeqNo(Long companyRoleSeqNo) {
		this.companyRoleSeqNo = companyRoleSeqNo;
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

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Long getRoleSeqNo() {
		return this.roleSeqNo;
	}

	public void setRoleSeqNo(Long roleSeqNo) {
		this.roleSeqNo = roleSeqNo;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companyRoleSeqNo == null) ? 0 : companyRoleSeqNo.hashCode());
		result = prime * result + ((companyUnitSeqNo == null) ? 0 : companyUnitSeqNo.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
		result = prime * result + ((roleSeqNo == null) ? 0 : roleSeqNo.hashCode());
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
		CompanyUnitRole other = (CompanyUnitRole) obj;
		if (companyRoleSeqNo == null) {
			if (other.companyRoleSeqNo != null)
				return false;
		} else if (!companyRoleSeqNo.equals(other.companyRoleSeqNo))
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
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (roleId == null) {
			if (other.roleId != null)
				return false;
		} else if (!roleId.equals(other.roleId))
			return false;
		if (roleSeqNo == null) {
			if (other.roleSeqNo != null)
				return false;
		} else if (!roleSeqNo.equals(other.roleSeqNo))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	public CompanyUnitRole(Long companyRoleSeqNo, Long roleSeqNo, Long companyUnitSeqNo, String roleId, String remark,
			String status, String role) {
		super();
		this.companyRoleSeqNo = companyRoleSeqNo;
		this.roleSeqNo = roleSeqNo;
		this.companyUnitSeqNo = companyUnitSeqNo;
		this.roleId = roleId;
		this.remark = remark;
		this.status = status;
		this.role = role;
	}

}