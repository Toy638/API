package models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "subject")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_subject;

    @Column(name = "subject_name")
    private String subjectName;


    @Column(name = "soft_delete")
    private boolean softDelete;

}
