package com.eventer.event.domain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.eventer.event.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Event extends BaseEntity {
	
	private String name;
	private LocalDate eventDate;
	private LocalDate createdAt;
	private LocalDate updatedAt;
	
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable
    @JsonIgnoreProperties("events")
	private Set<Participant> participants = new HashSet<>();
	
	public Event(String name, LocalDate eventDate, LocalDate createdAt, LocalDate updatedAt) {
		this.name = name;
		this.eventDate = eventDate;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	

}
