package ir.matyn.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass

public class BaseEntity {
    @Id
    @GeneratedValue
    private long id;

}
