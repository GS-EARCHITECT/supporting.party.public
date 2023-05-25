package enterprise.company_unit_functions.details.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the COMPANY_UNIT_COMPANY_FUNCTIONS_DETAILS database table.
 * 
 */
@Embeddable
public class CompanyUnitFunctionDetailPK implements Serializable 
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3359413207491814579L;

	@Column(name = "COMPANY_FUNCTION_SEQ_NO")
	private Long companyFunctionSeqNo;

	@Column(name = "PAR_COMPANY_FUNCTION_SEQ_NO")
	private String parCompanyFunctionSeqNo;

	public CompanyUnitFunctionDetailPK() {
	}

	public Long getFunctionSeqNo() {
		return this.companyFunctionSeqNo;
	}

	public void setFunctionSeqNo(Long companyFunctionSeqNo) {
		this.companyFunctionSeqNo = companyFunctionSeqNo;
	}

	public String getParFunctionSeqNo() {
		return this.parCompanyFunctionSeqNo;
	}

	public void setParFunctionSeqNo(String parCompanyFunctionSeqNo) {
		this.parCompanyFunctionSeqNo = parCompanyFunctionSeqNo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CompanyUnitFunctionDetailPK)) {
			return false;
		}
		CompanyUnitFunctionDetailPK castOther = (CompanyUnitFunctionDetailPK) other;
		return (this.companyFunctionSeqNo == castOther.companyFunctionSeqNo)
				&& this.parCompanyFunctionSeqNo.equals(castOther.parCompanyFunctionSeqNo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.companyFunctionSeqNo ^ (this.companyFunctionSeqNo >>> 32)));
		hash = hash * prime + this.parCompanyFunctionSeqNo.hashCode();

		return hash;
	}

	public CompanyUnitFunctionDetailPK(Long companyFunctionSeqNo, String parCompanyFunctionSeqNo) {
		super();
		this.companyFunctionSeqNo = companyFunctionSeqNo;
		this.parCompanyFunctionSeqNo = parCompanyFunctionSeqNo;
	}

}