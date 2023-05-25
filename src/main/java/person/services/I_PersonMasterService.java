package person.services;

import java.util.ArrayList;
import person.model.dto.PersonMasterDTO;

public interface I_PersonMasterService
{
    abstract public PersonMasterDTO newPerson(PersonMasterDTO personDTO);
    abstract public ArrayList<PersonMasterDTO> getAllPersons();
    abstract public ArrayList<PersonMasterDTO> getSelectPersons(ArrayList<Long> personSeqNos);
    abstract public ArrayList<PersonMasterDTO> getSelectPersonsBetweenTimes(String frDtTm, String toDtTm);
    abstract public ArrayList<PersonMasterDTO> getSelectPersonsByGender(String gender);
    abstract public void updPerson(PersonMasterDTO personDTO);
    abstract public void delAllPersons();
    abstract public void delSelectPersons(ArrayList<Long> personSeqNos);
    abstract void delSelectPersonsBetweenTimes(String frDtTm, String toDtTm);
    abstract void delSelectPersonsByGender(String gender);
}