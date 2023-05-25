package person.model.master;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.*;

/**
 * The persistent class for the PERSON_MASTER database table.
 * 
 */
@Entity
@Table(name = "PERSON_MASTER")
public class PersonMaster implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1646137144001224681L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_no_sequence")
	@SequenceGenerator(name = "person_no_sequence", allocationSize = 1)
	@Column(name = "PERSON_SEQ_NO")
	private Long personSeqNo;

	@Column(name = "PARTY_SEQ_NO")
	private Long partySeqNo;

	@Column(name = "AGE")
	private Long age;

	@Column(name = "DOB")
	private Timestamp dob;

	@Column(name = "FATHERS_NAME")
	private String fathersName;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "GENDER")
	private String gender;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "MID_NAME")
	private String midName;

	@Column(name = "MOTHERS_NAME")
	private String mothersName;

	@Column(name = "NIK_NAME")
	private String nikName;

	@Column(name = "REMARK")
	private String remark;

	@Column(name = "SPECIFICATION_SEQ_NO")
	private Long specificationSeqNo;

	@Column(name = "STATUS")
	private String status;

	public PersonMaster() {
	}

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

	public Timestamp getDob() {
		return dob;
	}

	public void setDob(Timestamp dob) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((fathersName == null) ? 0 : fathersName.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((midName == null) ? 0 : midName.hashCode());
		result = prime * result + ((mothersName == null) ? 0 : mothersName.hashCode());
		result = prime * result + ((nikName == null) ? 0 : nikName.hashCode());
		result = prime * result + ((partySeqNo == null) ? 0 : partySeqNo.hashCode());
		result = prime * result + ((personSeqNo == null) ? 0 : personSeqNo.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((specificationSeqNo == null) ? 0 : specificationSeqNo.hashCode());
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
		PersonMaster other = (PersonMaster) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (fathersName == null) {
			if (other.fathersName != null)
				return false;
		} else if (!fathersName.equals(other.fathersName))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (midName == null) {
			if (other.midName != null)
				return false;
		} else if (!midName.equals(other.midName))
			return false;
		if (mothersName == null) {
			if (other.mothersName != null)
				return false;
		} else if (!mothersName.equals(other.mothersName))
			return false;
		if (nikName == null) {
			if (other.nikName != null)
				return false;
		} else if (!nikName.equals(other.nikName))
			return false;
		if (partySeqNo == null) {
			if (other.partySeqNo != null)
				return false;
		} else if (!partySeqNo.equals(other.partySeqNo))
			return false;
		if (personSeqNo == null) {
			if (other.personSeqNo != null)
				return false;
		} else if (!personSeqNo.equals(other.personSeqNo))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (specificationSeqNo == null) {
			if (other.specificationSeqNo != null)
				return false;
		} else if (!specificationSeqNo.equals(other.specificationSeqNo))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	public PersonMaster(Long personSeqNo, Long partySeqNo, Long age, Timestamp dob, String fathersName,
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

}