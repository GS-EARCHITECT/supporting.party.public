package enterprise.company_unit_class_structure.model.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class CompanyUnitClassStructure_DTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -297341940368995020L;
	
	@NotEmpty
	private Long unitClassSeqNo;
	
	private Long parUnitClassSeqNo;
	
	@NotEmpty
	private Long companySeqNo;

	public Long getUnitClassSeqNo() {
		return unitClassSeqNo;
	}

	public void setUnitClassSeqNo(Long unitClassSeqNo) {
		this.unitClassSeqNo = unitClassSeqNo;
	}

	public Long getParUnitClassSeqNo() {
		return parUnitClassSeqNo;
	}

	public void setParUnitClassSeqNo(Long parUnitClassSeqNo) {
		this.parUnitClassSeqNo = parUnitClassSeqNo;
	}

	public Long getCompanySeqNo() {
		return companySeqNo;
	}

	public void setCompanySeqNo(Long companySeqNo) {
		this.companySeqNo = companySeqNo;
	}

	public CompanyUnitClassStructure_DTO(Long unitClassSeqNo, Long parUnitClassSeqNo, Long companySeqNo) {
		super();
		this.unitClassSeqNo = unitClassSeqNo;
		this.parUnitClassSeqNo = parUnitClassSeqNo;
		this.companySeqNo = companySeqNo;
	}

	public CompanyUnitClassStructure_DTO() {
		super();
	}

}