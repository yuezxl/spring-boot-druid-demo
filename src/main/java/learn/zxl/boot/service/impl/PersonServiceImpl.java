package learn.zxl.boot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import learn.zxl.boot.dao.slave.PersonDao;
import learn.zxl.boot.model.PersonModel;
import learn.zxl.boot.service.PersonService;

@Service("personService")
public class PersonServiceImpl implements PersonService {
	@Autowired
	private PersonDao personDao;

	@Override
	public int save(PersonModel saveModel) {
		return personDao.insertRecordInit(saveModel);
	}

	@Override
	public List<PersonModel> getPersons() {
		// TODO Auto-generated method stub
		return personDao.selectAll();
	}

}
