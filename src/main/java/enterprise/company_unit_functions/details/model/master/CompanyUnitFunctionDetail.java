package enterprise.company_unit_functions.details.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the COMPANY_UNIT_FUNCTIONS_DETAILS database table.
 * 
 */
@Entity
@Table(name = "COMPANY_UNIT_FUNCTIONS_DETAILS")
public class CompanyUnitFunctionDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CompanyUnitFunctionDetailPK id;

	public CompanyUnitFunctionDetail() {
	}

	public CompanyUnitFunctionDetailPK getId() {
		return this.id;
	}

	public void setId(CompanyUnitFunctionDetailPK id) {
		this.id = id;
	}

	public CompanyUnitFunctionDetail(CompanyUnitFunctionDetailPK id) {
		super();
		this.id = id;
	}

}