import ir.matyn.dto.ContactFormDto;
import ir.matyn.model.ContactForm;
import ir.matyn.repository.ContactFormDao;
import ir.matyn.service.ContactFormServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
//@RunWith(Parameterized.class)
public class ServiceTest {

    List<ContactForm> list;
    ContactForm contactForm1;
    ContactForm contactForm2;
    ContactForm contactForm3;
    ContactForm contactForm4;
    @Mock
    private ContactFormDao repository;
    @InjectMocks
    private ContactFormServiceImpl service;
    ModelMapper modelMapper = new ModelMapper();

//    public ServiceTest() {
//    }

    @Before()
    public void init() {
//    public ServiceTest() {
        MockitoAnnotations.initMocks(this);
        contactForm1 = new ContactForm("name1", "email1", "subject1", "message1");
        contactForm2 = new ContactForm("name2", "email2", "subject2", "message2");
        contactForm3 = new ContactForm("name3", "email3", "subject3", "message3");
        contactForm4 = new ContactForm("name4", "email4", "subject4", "message4");
        list = new ArrayList<>();
        list.add(contactForm1);
        list.add(contactForm2);
        list.add(contactForm3);
        list.add(contactForm4);
    }

    @Test
    public void findAll_Test() {

        when(repository.findAll()).thenReturn(list);
        List<ContactFormDto> contactFormDtoList = service.findAll();
        int i = 0;
        for (ContactForm element : repository.findAll()) {
            assertEquals(element.getEmail(), contactFormDtoList.get(i).getEmail());
            assertEquals(element.getName(), contactFormDtoList.get(i).getName());
            assertEquals(element.getMessage(), contactFormDtoList.get(i).getMessage());
            assertEquals(element.getSubject(), contactFormDtoList.get(i).getSubject());
            i++;
        }
        // Ask if verify is needed here
    }

    @ParameterizedTest
    @ValueSource(longs = {1, 2, 3, 4})
    public void findById_Test(Long id) {
        init();
        when(repository.findById(id)).thenReturn(Optional.of(list.get(Math.toIntExact(id))));
        ContactFormDto contactFormDto = service.findById(id);
        assertEquals(list.get(Math.toIntExact(id)).getEmail(), contactFormDto.getEmail());
        assertEquals(list.get(Math.toIntExact(id)).getName(), contactFormDto.getName());
        assertEquals(list.get(Math.toIntExact(id)).getMessage(), contactFormDto.getMessage());
        assertEquals(list.get(Math.toIntExact(id)).getSubject(), contactFormDto.getSubject());
    }
}
//    @Test
//    public void testDelete(){
//        when(repository.deleteAll()).
//    }

