package com.codinglevel.entities;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Student")
@Table(
        name = "student_table",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "student_email_unique",
                        columnNames = "email"
                )
        }
)

public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
           allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    @Column(
            updatable = false
    )
    private Long id;
    private String firstName;
    private String lastName;

    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String email;
    private Integer age;

    @OneToOne(
            mappedBy = "student",
            orphanRemoval = true,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.REMOVE
            }
    )
    private StudentIdCard studentIdCard;

    @OneToMany(
            mappedBy = "student",
            orphanRemoval = true,
            cascade = {
                    CascadeType.PERSIST, CascadeType.REMOVE
            },
            fetch = FetchType.LAZY
    )
    private List<Book> books = new ArrayList<>();

    @OneToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.REMOVE
            },
            mappedBy = "student"
    )
//    @JoinTable(
//            name = "enrolment",
//            joinColumns = @JoinColumn(
//                    name = "student_id",
//                    foreignKey = @ForeignKey(
//                            name = "enrolment_student_id_fk"
//                    )
//            ),
//            inverseJoinColumns = @JoinColumn(
//                    name = "course_id",
//                    foreignKey = @ForeignKey(
//                            name = "enrolment_course_id_fk"
//                    )
//            )
//    )
   private List<Enrolment> enrolments = new ArrayList<>() {};

    public Student() {

    }

    public Student(String firstName, String lastName, String email, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;

    }

    public void addBook(Book book) {
        if(!this.books.contains(book)) {
            this.books.add(book);
            book.setStudent(this);
        }
    }

    public void removeBook(Book book) {
        if(!this.books.contains(book)) {
            this.books.remove(book);
            book.setStudent(null);
        }
    }

    // add courses
//    public void enrolToCourse(Course course) {
//        courses.add(course);
//        course.getStudents().add(this);
//    }

    //remove courses
//    public void removeCourse(Course course) {
//        courses.remove(course);
//        course.getStudents().remove(this);
//    }


    public List<Enrolment> getEnrolments() {
        return enrolments;
    }

    public void addEnrolment(Enrolment enrolment) {
        if(!this.enrolments.contains(enrolment)) {
            enrolments.add(enrolment);
        }
    }

    public void removeEnrolment(Enrolment enrolment) {
        if(!enrolments.contains(enrolment)) {
            enrolments.remove(enrolment);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public StudentIdCard getStudentIdCard() {
        return studentIdCard;
    }

    public void setStudentIdCard(StudentIdCard studentIdCard) {
        this.studentIdCard = studentIdCard;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", studentIdCard=" + studentIdCard +
                ", books=" + books +
                '}';
    }
}
