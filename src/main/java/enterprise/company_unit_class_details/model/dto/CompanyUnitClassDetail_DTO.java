package enterprise.company_unit_class_details.model.dto;

import java.io.Serializable;

public class CompanyUnitClassDetail_DTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1755359272696650091L;
	private Long companyUnitSeqNo;
	private Long parCompanyUnitSeqNo;
	private Long unitClassSeqNo;

	public Long getCompanyUnitSeqNo() {
		return companyUnitSeqNo;
	}

	public void setCompanyUnitSeqNo(Long companyUnitSeqNo) {
		this.companyUnitSeqNo = companyUnitSeqNo;
	}

	public Long getParCompanyUnitSeqNo() {
		return parCompanyUnitSeqNo;
	}

	public void setParCompanyUnitSeqNo(Long parCompanyUnitSeqNo) {
		this.parCompanyUnitSeqNo = parCompanyUnitSeqNo;
	}

	public Long getUnitClassSeqNo() {
		return unitClassSeqNo;
	}

	public void setUnitClassSeqNo(Long unitClassSeqNo) {
		this.unitClassSeqNo = unitClassSeqNo;
	}

	public CompanyUnitClassDetail_DTO(Long companyUnitSeqNo, Long parCompanyUnitSeqNo, Long unitClassSeqNo) {
		super();
		this.companyUnitSeqNo = companyUnitSeqNo;
		this.parCompanyUnitSeqNo = parCompanyUnitSeqNo;
		this.unitClassSeqNo = unitClassSeqNo;
	}

	public CompanyUnitClassDetail_DTO() {
		super();
	}

}