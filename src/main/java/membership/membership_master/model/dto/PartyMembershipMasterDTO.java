package membership.membership_master.model.dto;

import java.io.Serializable;

public class PartyMembershipMasterDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4616870702061792791L;
	private long membershipSeqNo;
	private String membershipId;
	private Long membershipForSeqNo;
	private Long membershipOfSeqNo;
	private String frDtTm;
	private String toDtTm;
	private String remark;
	private String status;

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

	public String getFrDtTm() {
		return frDtTm;
	}

	public void setFrDtTm(String frDtTm) {
		this.frDtTm = frDtTm;
	}

	public String getToDtTm() {
		return toDtTm;
	}

	public void setToDtTm(String toDtTm) {
		this.toDtTm = toDtTm;
	}

	public PartyMembershipMasterDTO(long membershipSeqNo, String membershipId, Long membershipForSeqNo,
			Long membershipOfSeqNo, String frDtTm, String toDtTm, String remark, String status) {
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

	public PartyMembershipMasterDTO() {
		super();
	}

}