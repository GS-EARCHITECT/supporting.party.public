package person.services;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import person.model.dto.PersonMasterDTO;
import person.model.master.PersonMaster;
import person.model.repo.PersonMasterRepo;

@Service("personMasterServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class PersonMasterService implements I_PersonMasterService 
{
	//private static final Logger logger = LoggerFactory.getLogger(PersonMasterService.class);
	
	@Autowired
    private PersonMasterRepo personRepo;
		
	public PersonMasterDTO newPerson(PersonMasterDTO personDTO) 
	{
		if(!personRepo.existsById(personDTO.getPersonSeqNo()))
		{
		PersonMaster personMaster = personRepo.save(this.setPersonMaster(personDTO));
		personDTO = getPersonMasterDTO(personMaster);
		}
		return personDTO;
	}

	public ArrayList<PersonMasterDTO> getAllPersons() 
	{
		ArrayList<PersonMaster> personList = (ArrayList<PersonMaster>) personRepo.findAll();
		ArrayList<PersonMasterDTO> personDTOs = new ArrayList<PersonMasterDTO>();
		personDTOs = personList != null ? this.getPersonMasterDtos(personList) : null;
		return personDTOs;
	}

	public ArrayList<PersonMasterDTO> getSelectPersons(ArrayList<Long> personSeqNos)
	{
		ArrayList<PersonMaster> personMasters = personRepo.getSelectPersons(personSeqNos);
		ArrayList<PersonMasterDTO> personDTOs = new ArrayList<PersonMasterDTO>();		
		
		if(personMasters!=null) 
		{
			personDTOs = this.getPersonMasterDtos(personMasters);
		}
		return personDTOs;
	}
	
	public ArrayList<PersonMasterDTO> getSelectPersonsByGender(String gender)
	{
		ArrayList<PersonMaster> personMasters = personRepo.getSelectPersonsByGender(gender);
		ArrayList<PersonMasterDTO> personDTOs = new ArrayList<PersonMasterDTO>();		
		
		if(personMasters!=null) 
		{
			personDTOs = this.getPersonMasterDtos(personMasters);
		}
		return personDTOs;
	}

	public ArrayList<PersonMasterDTO> getSelectPersonsBetweenTimes(String frDtTm, String toDtTm) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:s");
		LocalDateTime frDateTime = LocalDateTime.parse(frDtTm, formatter);
		LocalDateTime toDateTime = LocalDateTime.parse(toDtTm, formatter);
		Timestamp frTsTimestamp = Timestamp.valueOf(frDateTime);
		Timestamp toTsTimestamp = Timestamp.valueOf(toDateTime);
		ArrayList<PersonMaster> personMasters = personRepo.getSelectPersonsBetweenTimes(frTsTimestamp, toTsTimestamp);
		ArrayList<PersonMasterDTO> partyMembershipDTOs = personMasters != null ? this.getPersonMasterDtos(personMasters) : null;
		return partyMembershipDTOs;

	}

	
	public void updPerson(PersonMasterDTO personDTO) {

		PersonMaster personMaster = this.setPersonMaster(personDTO);
		if (personRepo.existsById(personDTO.getPersonSeqNo())) {
			personMaster.setPersonSeqNo(personDTO.getPersonSeqNo());
			personRepo.save(personMaster);
		}
	}

	
	public void delAllPersons() {
		personRepo.deleteAll();
	}

	public void delSelectPersons(ArrayList<Long> personSeqNos) 
	{
		personRepo.delSelectPersons(personSeqNos);
	}
	
	public void delSelectPersonsByGender(String gender)
	{
		personRepo.delSelectPersonsByGender(gender);		
		return;
	}

	public void delSelectPersonsBetweenTimes(String frDtTm, String toDtTm) 
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:s");
		LocalDateTime frDateTime = LocalDateTime.parse(frDtTm, formatter);
		LocalDateTime toDateTime = LocalDateTime.parse(toDtTm, formatter);
		Timestamp frTsTimestamp = Timestamp.valueOf(frDateTime);
		Timestamp toTsTimestamp = Timestamp.valueOf(toDateTime);
		personRepo.delSelectPersonsBetweenTimes(frTsTimestamp, toTsTimestamp);
		return ;

	}

	private ArrayList<PersonMasterDTO> getPersonMasterDtos(ArrayList<PersonMaster> persMasters) {
		PersonMasterDTO personDTO = null;
		ArrayList<PersonMasterDTO> personDTOs = new ArrayList<PersonMasterDTO>();
				
		for (int i = 0; i < persMasters.size(); i++) 
		{
			personDTO = this.getPersonMasterDTO(persMasters.get(i)); 
			personDTOs.add(personDTO);
		}
		return personDTOs;
	}

	private PersonMasterDTO getPersonMasterDTO(PersonMaster persMaster) 
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		PersonMasterDTO personDTO = new PersonMasterDTO();
		personDTO.setPersonSeqNo(persMaster.getPersonSeqNo());
		personDTO.setPartySeqNo(persMaster.getPartySeqNo());
		personDTO.setRemark(persMaster.getRemark());
		personDTO.setStatus(persMaster.getStatus());
		personDTO.setDob(formatter.format(persMaster.getDob().toLocalDateTime()));
		personDTO.setAge(persMaster.getAge());
		personDTO.setFirstName(persMaster.getFirstName());
		personDTO.setLastName(persMaster.getLastName());
		personDTO.setMidName(persMaster.getMidName());
		personDTO.setFathersName(persMaster.getFathersName());
		personDTO.setMothersName(persMaster.getMothersName());
		personDTO.setGender(persMaster.getGender());
		personDTO.setNikName(persMaster.getNikName());
		personDTO.setSpecificationSeqNo(persMaster.getSpecificationSeqNo());
		return personDTO;		
	}

	private PersonMaster setPersonMaster(PersonMasterDTO pDTO) 
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		PersonMaster pMaster = new PersonMaster();
		LocalDateTime dob = LocalDateTime.parse(pDTO.getDob(), formatter);
		Timestamp dobTS = Timestamp.valueOf(dob);
		pMaster.setAge(pDTO.getAge());					
		pMaster.setDob(dobTS);
		pMaster.setFirstName(pDTO.getFirstName());
		pMaster.setGender(pDTO.getGender());
		pMaster.setLastName(pDTO.getLastName());
		pMaster.setMidName(pDTO.getMidName());
		pMaster.setNikName(pDTO.getNikName());
		pMaster.setRemark(pDTO.getRemark());				
		pMaster.setStatus(pDTO.getStatus());
		pMaster.setFathersName(pDTO.getFathersName());
		pMaster.setMothersName(pDTO.getMothersName());
		pMaster.setSpecificationSeqNo(pDTO.getSpecificationSeqNo());
		pMaster.setPartySeqNo(pDTO.getPartySeqNo());
		return pMaster;
	}
	
}