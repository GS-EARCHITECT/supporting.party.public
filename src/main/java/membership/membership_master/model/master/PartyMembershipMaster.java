package membership.membership_master.model.master;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;

/**
 * The persistent class for the PARTY_MEMBERSHIPS_MASTER database table.
 * 
 */
@Entity
@Table(name = "PARTY_MEMBERSHIPS_MASTER")
public class PartyMembershipMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "membership_sequence")
	@SequenceGenerator(name = "membership_sequence", allocationSize = 1)
	@Column(name = "MEMBERSHIP_SEQ_NO")
	private long membershipSeqNo;

	@Column(name = "MEMBERSHIP_ID")
	private String membershipId;

	@Column(name = "PARTY_SEQ_NO")
	private Long membershipForSeqNo;

	@Column(name = "PARTY_OF_SEQ_NO")
	private Long membershipOfSeqNo;

	@Column(name = "FR_DTTM")
	private Timestamp frDtTm;

	@Column(name = "TO_DTTM")
	private Timestamp toDtTm;

	@Column(name = "REMARK")
	private String remark;

	@Column(name = "STATUS")
	private String status;

	public PartyMembershipMaster() {
	}

	public long getMembershipSeqNo() {
		return membershipSeqNo;
	}

	public void setMembershipSeqNo(long membershipSeqNo) {
		this.membershipSeqNo = membershipSeqNo;
	}

	public String getMembershipId() {
		return membershipId;
	}

	public void setMembershipId(String membershipId) {
		this.membershipId = membershipId;
	}

	public Long getMembershipForSeqNo() {
		return membershipForSeqNo;
	}

	public void setMembershipForSeqNo(Long membershipForSeqNo) {
		this.membershipForSeqNo = membershipForSeqNo;
	}

	public Long getMembershipOfSeqNo() {
		return membershipOfSeqNo;
	}

	public void setMembershipOfSeqNo(Long membershipOfSeqNo) {
		this.membershipOfSeqNo = membershipOfSeqNo;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getFrDtTm() {
		return frDtTm;
	}

	public void setFrDtTm(Timestamp frDtTm) {
		this.frDtTm = frDtTm;
	}

	public Timestamp getToDtTm() {
		return toDtTm;
	}

	public void setToDtTm(Timestamp toDtTm) {
		this.toDtTm = toDtTm;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((frDtTm == null) ? 0 : frDtTm.hashCode());
		result = prime * result + ((membershipForSeqNo == null) ? 0 : membershipForSeqNo.hashCode());
		result = prime * result + ((membershipId == null) ? 0 : membershipId.hashCode());
		result = prime * result + ((membershipOfSeqNo == null) ? 0 : membershipOfSeqNo.hashCode());
		result = prime * result + (int) (membershipSeqNo ^ (membershipSeqNo >>> 32));
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((toDtTm == null) ? 0 : toDtTm.hashCode());
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
		PartyMembershipMaster other = (PartyMembershipMaster) obj;
		if (frDtTm == null) {
			if (other.frDtTm != null)
				return false;
		} else if (!frDtTm.equals(other.frDtTm))
			return false;
		if (membershipForSeqNo == null) {
			if (other.membershipForSeqNo != null)
				return false;
		} else if (!membershipForSeqNo.equals(other.membershipForSeqNo))
			return false;
		if (membershipId == null) {
			if (other.membershipId != null)
				return false;
		} else if (!membershipId.equals(other.membershipId))
			return false;
		if (membershipOfSeqNo == null) {
			if (other.membershipOfSeqNo != null)
				return false;
		} else if (!membershipOfSeqNo.equals(other.membershipOfSeqNo))
			return false;
		if (membershipSeqNo != other.membershipSeqNo)
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
		if (toDtTm == null) {
			if (other.toDtTm != null)
				return false;
		} else if (!toDtTm.equals(other.toDtTm))
			return false;
		return true;
	}

	public PartyMembershipMaster(long membershipSeqNo, String membershipId, Long membershipForSeqNo,
			Long membershipOfSeqNo, Timestamp frDtTm, Timestamp toDtTm, String remark, String status) {
		super();
		this.membershipSeqNo = membershipSeqNo;
		this.membershipId = membershipId;
		this.membershipForSeqNo = membershipForSeqNo;
		this.membershipOfSeqNo = membershipOfSeqNo;
		this.frDtTm = frDtTm;
		this.toDtTm = toDtTm;
		this.remark = remark;
		this.status = status;
	}

}