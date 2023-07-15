package enterprise.company_unit_class_structure.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the COMPANY_UNIT_CLASS_STRUCTURE database table.
 * 
 */
@Embeddable
public class CompanyUnitClassStructurePK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "UNIT_CLASS_SEQ_NO")
	private Long unitClassSeqNo;

	@Column(name = "PAR_UNIT_CLASS_SEQ_NO")
	private Long parUnitClassSeqNo;

	@Column(name = "COMPANY_SEQ_NO")
	private Long companySeqNo;

	public CompanyUnitClassStructurePK() {
	}

	public Long getUnitClassSeqNo() {
		return this.unitClassSeqNo;
	}

	public void setUnitClassSeqNo(Long unitClassSeqNo) {
		this.unitClassSeqNo = unitClassSeqNo;
	}

	public Long getParUnitClassSeqNo() {
		return this.parUnitClassSeqNo;
	}

	public void setParUnitClassSeqNo(Long parUnitClassSeqNo) {
		this.parUnitClassSeqNo = parUnitClassSeqNo;
	}

	public Long getCompanySeqNo() {
		return this.companySeqNo;
	}

	public void setCompanySeqNo(Long companySeqNo) {
		this.companySeqNo = companySeqNo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CompanyUnitClassStructurePK)) {
			return false;
		}
		CompanyUnitClassStructurePK castOther = (CompanyUnitClassStructurePK) other;
		return (this.unitClassSeqNo == castOther.unitClassSeqNo)
				&& (this.parUnitClassSeqNo == castOther.parUnitClassSeqNo)
				&& (this.companySeqNo == castOther.companySeqNo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.unitClassSeqNo ^ (this.unitClassSeqNo >>> 32)));
		hash = hash * prime + ((int) (this.parUnitClassSeqNo ^ (this.parUnitClassSeqNo >>> 32)));
		hash = hash * prime + ((int) (this.companySeqNo ^ (this.companySeqNo >>> 32)));

		return hash;
	}

	public CompanyUnitClassStructurePK(Long unitClassSeqNo, Long parUnitClassSeqNo, Long companySeqNo) {
		super();
		this.unitClassSeqNo = unitClassSeqNo;
		this.parUnitClassSeqNo = parUnitClassSeqNo;
		this.companySeqNo = companySeqNo;
	}

}