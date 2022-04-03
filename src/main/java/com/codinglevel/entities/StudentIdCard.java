package com.codinglevel.entities;
import lombok.Builder;


import javax.persistence.*;

@Entity(name = "StudentIdCard")
@Table(
        name = "student_id_card_table",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "student_id_card_unique_number",
                        columnNames = "card_number"
                )
        }
)
public class StudentIdCard {

    @Id
    @SequenceGenerator(
            name = "student_id_car_sequence",
            sequenceName = "student_id_car_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_id_car_sequence"
    )
    @Column(
            updatable = false
    )
    private Long id;
    @Column(
            name = "card_number",
            nullable = false,
            length = 15
    )
    private String cardNumber;

    @OneToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "student_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "student_id_card_student_fk"
            )
    )
    private Student student;

    public StudentIdCard() {
        super();
    }

    public StudentIdCard(
            String cardNumber,
            Student student) {
        this.cardNumber = cardNumber;
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "StudentIdCard{" +
                "id=" + id +
                ", cardNumber='" + cardNumber + '\'' +
                ", student=" + student +
                '}';
    }
}
