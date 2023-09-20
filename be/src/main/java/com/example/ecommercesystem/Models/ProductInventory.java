package com.example.ecommercesystem.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "product_inventory")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductInventory  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int quantity;

    private String color;

    private String details;

    private String description;

    @Column(name = "create_at")
    private Timestamp createAt;

    @Column(name = "modify_at")
    private Timestamp modifyAt;

    @JsonBackReference
    @OneToOne(mappedBy = "inventory")
    private Product product;

    @Override
    public String toString() {
        return "ProductInventory{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", color='" + color + '\'' +
                ", details='" + details + '\'' +
                ", description='" + description + '\'' +
                ", createAt=" + createAt +
                ", modifyAt=" + modifyAt +
                '}';
    }
}
