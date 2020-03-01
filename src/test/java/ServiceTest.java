import ir.matyn.dto.ContactFormDtoOut;
import ir.matyn.model.ContactFormEntity;
import ir.matyn.repository.ContactFormDao;
import ir.matyn.service.ContactFormService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class ServiceTest {

    List<ContactFormEntity> list;
    ContactFormEntity contactFormEntity1;
    ContactFormEntity contactFormEntity2;
    ContactFormEntity contactFormEntity3;
    ContactFormEntity contactFormEntity4;
    @Mock
    private ContactFormDao repository;
    @InjectMocks
    private ContactFormService service;


    @Before()
    public void init() {

        MockitoAnnotations.initMocks(this);
        contactFormEntity1 = new ContactFormEntity(1L, "name1", "email1", "subject1", "message1");
        contactFormEntity2 = new ContactFormEntity(2L, "name2", "email2", "subject2", "message2");
        contactFormEntity3 = new ContactFormEntity(3L, "name3", "email3", "subject3", "message3");
        contactFormEntity4 = new ContactFormEntity(4L, "name4", "email4", "subject4", "message4");
        list = new ArrayList<>();
        list.add(contactFormEntity1);
        list.add(contactFormEntity2);
        list.add(contactFormEntity3);
        list.add(contactFormEntity4);
    }

    @Test
    public void findAll_Test() {

        when(repository.findAll()).thenReturn(list);
        List<ContactFormDtoOut> contactFormDtoOutList = service.findAll();
        int i = 0;
        for (ContactFormEntity element : repository.findAll()) {
            assertEquals(element.getId(), contactFormDtoOutList.get(i).getId());
            assertEquals(element.getEmail(), contactFormDtoOutList.get(i).getEmail());
            assertEquals(element.getName(), contactFormDtoOutList.get(i).getName());
            assertEquals(element.getMessage(), contactFormDtoOutList.get(i).getMessage());
            assertEquals(element.getSubject(), contactFormDtoOutList.get(i).getSubject());
            i++;
        }
        // Ask if verify is needed here
    }

    @Test
    public void findById_Test() {
        for (long id = 0; id < 4; id++) {
            when(repository.findById(id + 1)).thenReturn(Optional.of(list.get(Math.toIntExact(id))));
            ContactFormDtoOut contactFormDtoOut = service.findById(id + 1);
            assertEquals(list.get(Math.toIntExact(id)).getEmail(), contactFormDtoOut.getEmail());
            assertEquals(list.get(Math.toIntExact(id)).getName(), contactFormDtoOut.getName());
            assertEquals(list.get(Math.toIntExact(id)).getMessage(), contactFormDtoOut.getMessage());
            assertEquals(list.get(Math.toIntExact(id)).getSubject(), contactFormDtoOut.getSubject());
        }
    }
}
//    @Test
//    public void testDelete(){
//        when(repository.deleteAll()).
//    }

