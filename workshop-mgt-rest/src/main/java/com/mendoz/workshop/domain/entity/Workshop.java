package com.mendoz.workshop.domain.entity;

import com.mendoz.workshop.domain.enums.WorkshopStatus;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "Team")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @SuperBuilder
public class Workshop extends BaseEntity {
    private String name;
    private String description;
    private String mascot;
    private WorkshopStatus status = WorkshopStatus.PENDING;
    @OneToMany(cascade = CascadeType.DETACH)
    private Set<Participant> players = new HashSet<>();
}
