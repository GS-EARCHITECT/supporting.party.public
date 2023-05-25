package enterprise.company_units.details.model.dto;

import java.io.Serializable;

public class CompanyUnitDetailDTO implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1755359272696650091L;
	private Long companyUnitSeqNo;
	private Long parCompanyUnitSeqNo;

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

	public CompanyUnitDetailDTO(Long companyUnitSeqNo, Long parCompanyUnitSeqNo) {
		super();
		this.companyUnitSeqNo = companyUnitSeqNo;
		this.parCompanyUnitSeqNo = parCompanyUnitSeqNo;
	}

	public CompanyUnitDetailDTO() {
		super();
	}

}