package enterprise.company_unit_class_details.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the COMPANY_UNIT_DETAILS database table.
 * 
 */
@Entity
@Table(name = "COMPANY_UNIT_CLASS_DETAILS")
public class CompanyUnitClassDetail implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CompanyUnitClassDetailPK id;

	public CompanyUnitClassDetail() {
	}

	public CompanyUnitClassDetailPK getId() {
		return this.id;
	}

	public void setId(CompanyUnitClassDetailPK id) {
		this.id = id;
	}

	public CompanyUnitClassDetail(CompanyUnitClassDetailPK id) 
	{
		super();
		this.id = id;
	}

}