package com.gegette.sechangenc.model;

import io.micrometer.core.lang.NonNull;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", insertable = false, updatable = false)
    private Long id;

    @NonNull
    @Column(nullable = false, name = "TITLE")
    private String title;

    @NonNull
    @Column(nullable = false, name = "DESCRIPTION")
    private String description;

    @NonNull
    @Column(nullable = false, name = "PRICE")
    private int price;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false, updatable = false)
    private User owner;
}