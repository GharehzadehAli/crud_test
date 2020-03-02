package ir.matyn.repository;

import ir.matyn.model.entity.ContactFormEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContactFormDao extends JpaRepository<ContactFormEntity, Long> {

}
