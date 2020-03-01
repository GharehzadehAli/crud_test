package ir.matyn.service;

import ir.matyn.dto.ContactFormDtoIn;
import ir.matyn.dto.ContactFormDtoOut;

import java.util.List;

public interface IContactFormService {

    List<ContactFormDtoOut> findAll();
    ContactFormDtoOut save(ContactFormDtoIn contactFormDtoIn);
    void deleteById(long id);
    void deleteAll();
    ContactFormDtoOut findById(long id);
    void updateById(Long id, ContactFormDtoIn contactFormDtoIn);


}
