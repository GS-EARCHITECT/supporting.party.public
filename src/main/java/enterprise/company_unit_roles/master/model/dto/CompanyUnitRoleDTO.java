package enterprise.company_unit_roles.master.model.dto;

import java.io.Serializable;

public class CompanyUnitRoleDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6287065913918825751L;
	private Long companyRoleSeqNo;
	private Long roleSeqNo;
	private String roleId;
	private Long companyUnitSeqNo;
	private String remark;
	private String status;
	private String role;

	public Long getCompanyRoleSeqNo() {
		return companyRoleSeqNo;
	}

	public void setCompanyRoleSeqNo(Long companyRoleSeqNo) {
		this.companyRoleSeqNo = companyRoleSeqNo;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public Long getRoleSeqNo() {
		return roleSeqNo;
	}

	public void setRoleSeqNo(Long roleSeqNo) {
		this.roleSeqNo = roleSeqNo;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public CompanyUnitRoleDTO(Long companyRoleSeqNo, Long roleSeqNo, String roleId, Long companyUnitSeqNo,
			String remark, String status, String role) {
		super();
		this.companyRoleSeqNo = companyRoleSeqNo;
		this.roleSeqNo = roleSeqNo;
		this.roleId = roleId;
		this.companyUnitSeqNo = companyUnitSeqNo;
		this.remark = remark;
		this.status = status;
		this.role = role;
	}

	public CompanyUnitRoleDTO() {
		super();
	}

}