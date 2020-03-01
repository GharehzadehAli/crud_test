package ir.matyn.service;

import ir.matyn.dto.ContactFormDto;
import ir.matyn.model.ContactForm;
import ir.matyn.repository.ContactFormDao;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContactFormServiceImpl implements ContactFormService {
    ContactFormDto contactFormDto;

    private ModelMapper modelMapper = new ModelMapper();
    private final ContactFormDao contactFormDao;

    @Autowired
    public ContactFormServiceImpl(ContactFormDao contactFormDao) {
        this.contactFormDao = contactFormDao;

    }

    @Override
    public List<ContactFormDto> findAll() {
        List<ContactForm> contactFormList = contactFormDao.findAll();
        if (contactFormList.size() > 0)
            return contactFormList.stream()
                    .map(contactForm -> modelMapper
                    .map(contactForm,ContactFormDto.class))
                    .collect(Collectors.toList());
        else return new ArrayList<ContactFormDto>();
    }

    @Override
    public ContactFormDto save(ContactFormDto contactFormDto) {
        ContactForm contactForm = modelMapper.map(contactFormDto, ContactForm.class);
        contactFormDao.save(contactForm);
        return contactFormDto;
    }


    @Override
    public void deleteById(long id) {

        contactFormDao.deleteById(id);
    }

    @Override
    public void deleteAll() {
        contactFormDao.deleteAll();
    }

    @Override
    public ContactFormDto findById(long id) {
        Optional<ContactForm> contactForm = contactFormDao.findById(id);
        ContactFormDto contactFormDto = modelMapper.map(contactForm.get(), ContactFormDto.class);
        return contactFormDto;
    }

    @Override
    public void updateById(Long id,ContactFormDto contactFormDto) {
        //ContactForm contactForm = modelMapper.map(contactFormDto, ContactForm.class);
        Optional<ContactForm> optContactForm = contactFormDao.findById(id);
        if (optContactForm.isPresent()) {
            ContactForm newContactForm=optContactForm.get();
            newContactForm.setEmail(contactFormDto.getEmail());
            newContactForm.setName(contactFormDto.getName());
            newContactForm.setMessage(contactFormDto.getMessage());
            newContactForm.setSubject(contactFormDto.getSubject());

        }

        else
         contactFormDao.save(optContactForm.get());
    }


}
