package enterprise.company_unit_class_structure.model.master;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the COMPANY_UNIT_CLASS_STRUCTURE database table.
 * 
 */
@Entity
@Table(name="COMPANY_UNIT_CLASS_STRUCTURE")
@NamedQuery(name="CompanyUnitClassStructure.findAll", query="SELECT c FROM CompanyUnitClassStructure c")
public class CompanyUnitClassStructure implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CompanyUnitClassStructurePK id;

	public CompanyUnitClassStructure() {
	}

	public CompanyUnitClassStructurePK getId() {
		return this.id;
	}

	public void setId(CompanyUnitClassStructurePK id) {
		this.id = id;
	}

}