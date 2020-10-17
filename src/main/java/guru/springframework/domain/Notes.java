package guru.springframework.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * Created by jt on 6/13/17.
 */
@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Recipe recipe;

    @Lob
    //String can be crazy large...hibernate && JPA only support 255 chars..that is why we use a lob..LargeObject
    //Jpa/hibernate will store it into a clob field in the database.
    private String recipeNotes;

}
