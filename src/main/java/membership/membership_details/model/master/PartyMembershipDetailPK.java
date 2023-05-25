package membership.membership_details.model.master;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;

/**
 * The primary key class for the PARTY_MEMBERSHIPS_DETAILS database table.
 * 
 */
@Embeddable
public class PartyMembershipDetailPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4453207584340607923L;

	@Column(name = "MEMBERSHIP_SEQ_NO")
	private Long membershipSeqNo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ON_DTTM")
	private Timestamp onDttm;

	public Long getMembershipSeqNo() {
		return membershipSeqNo;
	}

	public void setMembershipSeqNo(Long membershipSeqNo) {
		this.membershipSeqNo = membershipSeqNo;
	}

	public Timestamp getOnDttm() {
		return onDttm;
	}

	public void setOnDttm(Timestamp onDttm) {
		this.onDttm = onDttm;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (membershipSeqNo ^ (membershipSeqNo >>> 32));
		result = prime * result + ((onDttm == null) ? 0 : onDttm.hashCode());
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
		PartyMembershipDetailPK other = (PartyMembershipDetailPK) obj;
		if (membershipSeqNo != other.membershipSeqNo)
			return false;
		if (onDttm == null) {
			if (other.onDttm != null)
				return false;
		} else if (!onDttm.equals(other.onDttm))
			return false;
		return true;
	}

	public PartyMembershipDetailPK(Long membershipSeqNo, Timestamp onDttm) {
		super();
		this.membershipSeqNo = membershipSeqNo;
		this.onDttm = onDttm;
	}

	public PartyMembershipDetailPK() {
		super();
	}

}