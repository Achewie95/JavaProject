package com.humber.project.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hospitalId;
    private String hospitalName;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "patientId")
    private List<Patient> patient;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "departmentId")
    private List<Department> department;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "appointmentId")
    private List<Appointment> appointment;

}
