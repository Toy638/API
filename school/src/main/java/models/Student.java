package models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@Entity
@Table(name = "student")

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "student_address")
    private String studentAddress;

    @Column(name = "student_phone")
    private String studentPhone;

    @Column(name = "student_email")
    private String studentEmail;

    @Column(name = "student_password")
    private String studentPassword;

    @Column(name = "soft_delete")
    private boolean softDelete;

}
