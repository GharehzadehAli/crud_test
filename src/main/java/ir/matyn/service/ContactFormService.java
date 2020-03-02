package ir.matyn.service;

import ir.matyn.dto.ContactFormDtoIn;
import ir.matyn.dto.ContactFormDtoOut;
import ir.matyn.exception.ContactFormNotFoundException;
import ir.matyn.exception.ContactFormsNotFoundException;
import ir.matyn.model.ContactFormEntity;
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
public class ContactFormService implements IContactFormService {

    private final IContactFormDao contactFormDao;
    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public ContactFormService(IContactFormDao contactFormDao) {
        this.contactFormDao = contactFormDao;

    }

    @Override
    public List<ContactFormDtoOut> findAll() {
        List<ContactFormEntity> contactFormEntityList = contactFormDao.findAll();
        if (!(contactFormEntityList.isEmpty())) {
            return contactFormEntityList.stream()
                    .map(contactFormEntity -> modelMapper
                            .map(contactFormEntity, ContactFormDtoOut.class))
                    .collect(Collectors.toList());
        } else return new ArrayList<>();
    }

    @Override
    public ContactFormDtoOut save(ContactFormDtoIn contactFormDtoIn) {
        ContactFormEntity contactFormEntity = modelMapper.map(contactFormDtoIn, ContactFormEntity.class);
        return modelMapper.map(contactFormDao.save(contactFormEntity), ContactFormDtoOut.class);

    }


    @Override
    public void deleteById(long id) {
        try {
            contactFormDao.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ContactFormNotFoundException(id);
        }

    }

    @Override
    public void deleteAll() {
        try {
            contactFormDao.deleteAll();
        } catch (EmptyResultDataAccessException e) {
            throw new ContactFormsNotFoundException();
        }
    }

    @Override
    public ContactFormDtoOut findById(long id) {
        Optional<ContactFormEntity> contactForm = contactFormDao.findById(id);
        return contactForm.map(contactFormEntity -> modelMapper
                .map(contactFormEntity, ContactFormDtoOut.class))
                .orElseThrow(() -> new ContactFormNotFoundException(id));
    }

    @Override
    public ContactFormDtoOut updateById(Long id, ContactFormDtoIn contactFormDtoIn) {
        Optional<ContactFormEntity> optContactForm = contactFormDao.findById(id);
        if (optContactForm.isPresent()) {
            ContactFormEntity contactFormEntity = optContactForm.get();
            contactFormEntity.setEmail(contactFormDtoIn.getEmail());
            contactFormEntity.setName(contactFormDtoIn.getName());
            contactFormEntity.setMessage(contactFormDtoIn.getMessage());
            contactFormEntity.setSubject(contactFormDtoIn.getSubject());
            return modelMapper.map(contactFormEntity, ContactFormDtoOut.class);

        } else
            throw new ContactFormNotFoundException(id);
    }


}
