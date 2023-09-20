package com.example.ecommercesystem.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "product_images")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductImage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String link;

    @Column(name = "create_at")
    private Timestamp createAt;

    @Column(name = "modify_at")
    private Timestamp modifyAt;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Override
    public String toString() {
        return "ProductImage{" +
                "id=" + id +
                ", link='" + link + '\'' +
                ", createAt=" + createAt +
                ", modifyAt=" + modifyAt +
                '}';
    }
}
