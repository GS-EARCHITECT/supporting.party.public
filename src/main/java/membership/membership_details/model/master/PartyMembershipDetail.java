package membership.membership_details.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the PARTY_MEMBERSHIPS_DETAILS database table.
 * 
 */
@Entity
@Table(name = "PARTY_MEMBERSHIPS_DETAILS")
public class PartyMembershipDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PartyMembershipDetailPK id;

	@Column(name = "REMARK")
	private String remark;

	@Column(name = "STATUS")
	private String status;

	public PartyMembershipDetail() {
	}

	public PartyMembershipDetailPK getId() {
		return this.id;
	}

	public void setId(PartyMembershipDetailPK id) {
		this.id = id;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		PartyMembershipDetail other = (PartyMembershipDetail) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	public PartyMembershipDetail(PartyMembershipDetailPK id, String remark, String status) {
		super();
		this.id = id;
		this.remark = remark;
		this.status = status;
	}

}