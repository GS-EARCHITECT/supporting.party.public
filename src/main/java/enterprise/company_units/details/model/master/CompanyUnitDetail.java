package enterprise.company_units.details.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the COMPANY_UNITS_STRUCTURE database table.
 * 
 */
@Entity
@Table(name = "COMPANY_UNITS_DETAILS")
public class CompanyUnitDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CompanyUnitDetailPK id;

	public CompanyUnitDetail() {
	}

	public CompanyUnitDetailPK getId() {
		return this.id;
	}

	public void setId(CompanyUnitDetailPK id) {
		this.id = id;
	}

	public CompanyUnitDetail(CompanyUnitDetailPK id) {
		super();
		this.id = id;
	}

}