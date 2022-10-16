package com.miw.upm.persistance.entitites;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Transient;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UnRelatedEntity {
    public static final String TRANSIENT = "no persistent";

    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique = true, nullable = false)
    private String nick;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private LocalDateTime bornDate;

    @ElementCollection(fetch = FetchType.EAGER)
    @Singular
    private List<String> tags;

    @Transient
    private String noPersistent;
}
