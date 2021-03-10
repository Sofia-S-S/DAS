package com.revature.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity

@Table(name = "patient_doctor", schema="das", uniqueConstraints = { @UniqueConstraint( columnNames = { "patient", "doctor" } ) })
public class PatientDoctor {

	@JoinColumn
	@OneToOne
	private User patient;
	@JoinColumn
	@OneToMany
	private User doctor;
	
	public PatientDoctor() {
		super();
	}

	public PatientDoctor(User patient, User doctor) {
		super();
		this.patient = patient;
		this.doctor = doctor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((doctor == null) ? 0 : doctor.hashCode());
		result = prime * result + ((patient == null) ? 0 : patient.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PatientDoctor other = (PatientDoctor) obj;
		if (doctor == null) {
			if (other.doctor != null)
				return false;
		} else if (!doctor.equals(other.doctor))
			return false;
		if (patient == null) {
			if (other.patient != null)
				return false;
		} else if (!patient.equals(other.patient))
			return false;
		return true;
	}

	public User getPatient() {
		return patient;
	}

	public void setPatient(User patient) {
		this.patient = patient;
	}

	public User getDoctor() {
		return doctor;
	}

	public void setDoctor(User doctor) {
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "PatientDoctor [patient=" + patient + ", doctor=" + doctor + "]";
	}
	
	
	
}
