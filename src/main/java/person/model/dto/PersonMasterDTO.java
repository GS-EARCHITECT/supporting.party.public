package person.model.dto;

import java.io.Serializable;

public class PersonMasterDTO implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 46066248781274383L;
	private Long personSeqNo;
	private Long partySeqNo;
	private Long age;
	private String dob;
	private String fathersName;
	private String firstName;
	private String gender;
	private String lastName;
	private String midName;
	private String mothersName;
	private String nikName;
	private String remark;
	private Long specificationSeqNo;
	private String status;

	public Long getPersonSeqNo() {
		return personSeqNo;
	}

	public void setPersonSeqNo(Long personSeqNo) {
		this.personSeqNo = personSeqNo;
	}

	public Long getPartySeqNo() {
		return partySeqNo;
	}

	public void setPartySeqNo(Long partySeqNo) {
		this.partySeqNo = partySeqNo;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getFathersName() {
		return fathersName;
	}

	public void setFathersName(String fathersName) {
		this.fathersName = fathersName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMidName() {
		return midName;
	}

	public void setMidName(String midName) {
		this.midName = midName;
	}

	public String getMothersName() {
		return mothersName;
	}

	public void setMothersName(String mothersName) {
		this.mothersName = mothersName;
	}

	public String getNikName() {
		return nikName;
	}

	public void setNikName(String nikName) {
		this.nikName = nikName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getSpecificationSeqNo() {
		return specificationSeqNo;
	}

	public void setSpecificationSeqNo(Long specificationSeqNo) {
		this.specificationSeqNo = specificationSeqNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public PersonMasterDTO(Long personSeqNo, Long partySeqNo, Long age, String dob, String fathersName,
			String firstName, String gender, String lastName, String midName, String mothersName, String nikName,
			String remark, Long specificationSeqNo, String status) {
		super();
		this.personSeqNo = personSeqNo;
		this.partySeqNo = partySeqNo;
		this.age = age;
		this.dob = dob;
		this.fathersName = fathersName;
		this.firstName = firstName;
		this.gender = gender;
		this.lastName = lastName;
		this.midName = midName;
		this.mothersName = mothersName;
		this.nikName = nikName;
		this.remark = remark;
		this.specificationSeqNo = specificationSeqNo;
		this.status = status;
	}

	public PersonMasterDTO() {
		super();
	}

}