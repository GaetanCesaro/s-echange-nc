package com.gegette.sechangenc.model;

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

    @Column(nullable = false, name = "TITLE")
    private String title;

    @Column(nullable = false, name = "DESCRIPTION")
    private String description;

    @Column(nullable = false, name = "PRICE")
    private int price;

    @Column(nullable = false, name = "IMAGE_URL")
    private String imageUrl;

    @Column(nullable = false, name = "CATEGORY")
    private String category;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false, updatable = false)
    private User owner;
}