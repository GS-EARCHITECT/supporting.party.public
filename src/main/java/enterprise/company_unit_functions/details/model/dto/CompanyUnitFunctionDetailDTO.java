package enterprise.company_unit_functions.details.model.dto;

import java.io.Serializable;

public class CompanyUnitFunctionDetailDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4165200481447884852L;
	private Long companyFunctionSeqNo;
	private String parCompanyFunctionSeqNo;

	public Long getFunctionSeqNo() {
		return companyFunctionSeqNo;
	}

	public void setFunctionSeqNo(Long companyFunctionSeqNo) {
		this.companyFunctionSeqNo = companyFunctionSeqNo;
	}

	public String getParFunctionSeqNo() {
		return parCompanyFunctionSeqNo;
	}

	public void setParFunctionSeqNo(String parCompanyFunctionSeqNo) {
		this.parCompanyFunctionSeqNo = parCompanyFunctionSeqNo;
	}

	public CompanyUnitFunctionDetailDTO(Long companyFunctionSeqNo, String parCompanyFunctionSeqNo) {
		super();
		this.companyFunctionSeqNo = companyFunctionSeqNo;
		this.parCompanyFunctionSeqNo = parCompanyFunctionSeqNo;
	}

	public CompanyUnitFunctionDetailDTO() {
		super();
	}

}