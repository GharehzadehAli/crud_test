package ir.matyn.service;

import ir.matyn.exception.ContactFormNotFoundException;
import ir.matyn.model.dto.ContactFormDtoIn;
import ir.matyn.model.dto.ContactFormDtoOut;
import ir.matyn.model.entity.ContactFormEntity;
import ir.matyn.repository.IContactFormDao;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContactFormService {

    private final IContactFormDao contactFormDao;
    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public ContactFormService(IContactFormDao contactFormDao) {
        this.contactFormDao = contactFormDao;

    }


    public List<ContactFormDtoOut> findAll() {
        List<ContactFormEntity> contactFormEntityList = contactFormDao.findAll();
        if (!(contactFormEntityList.isEmpty())) {
            return contactFormEntityList.stream()
                    .map(contactFormEntity -> modelMapper
                            .map(contactFormEntity, ContactFormDtoOut.class))
                    .collect(Collectors.toList());
        } else return new ArrayList<>();
    }


    public ContactFormDtoOut save(ContactFormDtoIn contactFormDtoIn) {
        ContactFormEntity contactFormEntity = modelMapper.map(contactFormDtoIn, ContactFormEntity.class);
        return modelMapper.map(contactFormDao.save(contactFormEntity), ContactFormDtoOut.class);

    }


    public void deleteById(long id) {
        try {
            contactFormDao.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ContactFormNotFoundException(id);
        }

    }


    public void deleteAll() {

        contactFormDao.deleteAll();
    }


    public ContactFormDtoOut findById(long id) {
        Optional<ContactFormEntity> contactForm = contactFormDao.findById(id);
        return contactForm.map(contactFormEntity -> modelMapper
                .map(contactFormEntity, ContactFormDtoOut.class))
                .orElseThrow(() -> new ContactFormNotFoundException(id));
    }


    public ContactFormDtoOut updateById(Long id, ContactFormDtoIn contactFormDtoIn) {

        Optional<ContactFormEntity> optContactForm = contactFormDao.findById(id);
        if (!(optContactForm.isPresent())) {
            throw new ContactFormNotFoundException(id);

        }

        ContactFormEntity contactFormEntity = optContactForm.get();
        modelMapper.map(contactFormDtoIn, contactFormEntity);
        contactFormDao.save(contactFormEntity);
        return modelMapper.map(contactFormEntity, ContactFormDtoOut.class);
    }


}
