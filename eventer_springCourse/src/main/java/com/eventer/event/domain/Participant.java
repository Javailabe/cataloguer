package com.eventer.event.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import com.eventer.event.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Participant extends BaseEntity {
	
	private String email;
	
    @ManyToMany(mappedBy = "participants", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnoreProperties("participants")
	private Set<Event> events;

	public Participant(String email) {
		this.email = email;
	}
}