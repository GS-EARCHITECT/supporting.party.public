package enterprise.company_units.details.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the COMPANY_UNITS_STRUCTURE database table.
 * 
 */
@Embeddable
public class CompanyUnitDetailPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "PAR_COMPANY_UNIT_SEQUENCE_NO")
	private long parCompanyUnitSeqNo;

	@Column(name = "COMPANY_UNIT_SEQUENCE_NO")
	private long companyUnitSeqNo;

	public CompanyUnitDetailPK() {
	}

	public long getParCompanyUnitSeqNo() {
		return parCompanyUnitSeqNo;
	}

	public void setParCompanyUnitSeqNo(long parCompanyUnitSeqNo) {
		this.parCompanyUnitSeqNo = parCompanyUnitSeqNo;
	}

	public long getCompanyUnitSeqNo() {
		return companyUnitSeqNo;
	}

	public void setCompanyUnitSeqNo(long companyUnitSeqNo) {
		this.companyUnitSeqNo = companyUnitSeqNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (companyUnitSeqNo ^ (companyUnitSeqNo >>> 32));
		result = prime * result + (int) (parCompanyUnitSeqNo ^ (parCompanyUnitSeqNo >>> 32));
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
		CompanyUnitDetailPK other = (CompanyUnitDetailPK) obj;
		if (companyUnitSeqNo != other.companyUnitSeqNo)
			return false;
		if (parCompanyUnitSeqNo != other.parCompanyUnitSeqNo)
			return false;
		return true;
	}

	public CompanyUnitDetailPK(long parCompanyUnitSeqNo, long companyUnitSeqNo) {
		super();
		this.parCompanyUnitSeqNo = parCompanyUnitSeqNo;
		this.companyUnitSeqNo = companyUnitSeqNo;
	}

}