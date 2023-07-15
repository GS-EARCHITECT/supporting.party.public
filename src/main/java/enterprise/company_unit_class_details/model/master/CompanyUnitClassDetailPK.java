package enterprise.company_unit_class_details.model.master;

import java.io.Serializable;
import javax.persistence.*;

@Embeddable
public class CompanyUnitClassDetailPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "PAR_COMPANY_UNIT_SEQUENCE_NO")
	private Long parCompanyUnitSeqNo;

	@Column(name = "UNIT_CLASS_SEQ_NO")
	private Long unitClassSeqNo;

	@Column(name = "COMPANY_UNIT_SEQUENCE_NO")
	private Long companyUnitSeqNo;

	public CompanyUnitClassDetailPK() {
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

	public Long getCompanyUnitSeqNo() {
		return companyUnitSeqNo;
	}

	public void setCompanyUnitSeqNo(Long companyUnitSeqNo) {
		this.companyUnitSeqNo = companyUnitSeqNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companyUnitSeqNo == null) ? 0 : companyUnitSeqNo.hashCode());
		result = prime * result + ((parCompanyUnitSeqNo == null) ? 0 : parCompanyUnitSeqNo.hashCode());
		result = prime * result + ((unitClassSeqNo == null) ? 0 : unitClassSeqNo.hashCode());
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
		CompanyUnitClassDetailPK other = (CompanyUnitClassDetailPK) obj;
		if (companyUnitSeqNo == null) {
			if (other.companyUnitSeqNo != null)
				return false;
		} else if (!companyUnitSeqNo.equals(other.companyUnitSeqNo))
			return false;
		if (parCompanyUnitSeqNo == null) {
			if (other.parCompanyUnitSeqNo != null)
				return false;
		} else if (!parCompanyUnitSeqNo.equals(other.parCompanyUnitSeqNo))
			return false;
		if (unitClassSeqNo == null) {
			if (other.unitClassSeqNo != null)
				return false;
		} else if (!unitClassSeqNo.equals(other.unitClassSeqNo))
			return false;
		return true;
	}

	public CompanyUnitClassDetailPK(Long parCompanyUnitSeqNo, Long unitClassSeqNo, Long companyUnitSeqNo) {
		super();
		this.parCompanyUnitSeqNo = parCompanyUnitSeqNo;
		this.unitClassSeqNo = unitClassSeqNo;
		this.companyUnitSeqNo = companyUnitSeqNo;
	}

}