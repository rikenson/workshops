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

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Entity
@Table(name = "Team")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @SuperBuilder
public class Workshop extends BaseEntity {
    private String name;
    private String description;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private WorkshopStatus status = WorkshopStatus.PENDING;
    @OneToMany(cascade = CascadeType.DETACH)
    private List<Participant> participants = new ArrayList<>();
}
