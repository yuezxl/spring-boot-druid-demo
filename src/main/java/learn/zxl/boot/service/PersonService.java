package learn.zxl.boot.service;

import java.util.List;

import learn.zxl.boot.model.PersonModel;

public interface PersonService {
	int save(PersonModel saveModel);
	
	List<PersonModel> getPersons();
}
