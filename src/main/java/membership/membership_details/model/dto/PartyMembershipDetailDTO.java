package membership.membership_details.model.dto;

import java.io.Serializable;

public class PartyMembershipDetailDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1140885739486184858L;
	private String remark;
	private String status;
	private Long membershipSeqNo;
	private String onDttm;

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

	public Long getMembershipSeqNo() {
		return membershipSeqNo;
	}

	public void setMembershipSeqNo(Long membershipSeqNo) {
		this.membershipSeqNo = membershipSeqNo;
	}

	public String getOnDttm() {
		return onDttm;
	}

	public void setOnDttm(String onDttm) {
		this.onDttm = onDttm;
	}

	public PartyMembershipDetailDTO(String remark, String status, Long membershipSeqNo, String onDttm) {
		super();
		this.remark = remark;
		this.status = status;
		this.membershipSeqNo = membershipSeqNo;
		this.onDttm = onDttm;
	}

	public PartyMembershipDetailDTO() {
		super();
	}

}