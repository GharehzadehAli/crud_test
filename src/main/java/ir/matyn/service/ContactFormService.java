package ir.matyn.service;

import ir.matyn.dto.ContactFormDto;
import ir.matyn.model.ContactForm;

import java.util.List;

public interface ContactFormService {

    List<ContactFormDto> findAll();
    ContactFormDto save(ContactFormDto contactFormDto);
    void deleteById(long id);
    void deleteAll();
    ContactFormDto findById(long id);
    void updateById(Long id,ContactFormDto contactFormDto);


}
