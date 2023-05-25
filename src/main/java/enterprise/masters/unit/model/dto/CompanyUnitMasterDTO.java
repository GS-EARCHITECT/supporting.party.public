package enterprise.masters.unit.model.dto;

import java.io.Serializable;

public class CompanyUnitMasterDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 667380722704739578L;
	private Long unitSeqNo;
	private String remark;
	private String status;
	private String unit;
	private Long unitClassSeqNo;

	public Long getUnitSeqNo() {
		return unitSeqNo;
	}

	public void setUnitSeqNo(Long unitSeqNo) {
		this.unitSeqNo = unitSeqNo;
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

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public CompanyUnitMasterDTO(Long unitSeqNo, String remark, String status, String unit, Long unitClassSeqNo) {
		super();
		this.unitSeqNo = unitSeqNo;
		this.remark = remark;
		this.status = status;
		this.unit = unit;
		this.unitClassSeqNo = unitClassSeqNo;
	}

	public Long getUnitClassSeqNo() {
		return unitClassSeqNo;
	}

	public void setUnitClassSeqNo(Long unitClassSeqNo) {
		this.unitClassSeqNo = unitClassSeqNo;
	}

	public CompanyUnitMasterDTO() {
		super();
	}

}