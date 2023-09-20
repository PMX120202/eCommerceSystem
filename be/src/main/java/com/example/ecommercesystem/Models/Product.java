package com.example.ecommercesystem.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "products")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String description;

    private Long price;

    private String image;

    private boolean hide;

    @Column(name = "create_at")
    private Timestamp createAt;

    @Column(name = "modify_at")
    private Timestamp modifyAt;

    @ManyToOne
    @JoinColumn(name = "product_category_id")
    @JsonBackReference
    private ProductCategory categories;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_inventory_id", referencedColumnName = "id")
    @JsonManagedReference
    private ProductInventory inventory;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "discount_id", referencedColumnName = "id")
    @JsonManagedReference
    private Discount discount;

    @OneToMany(mappedBy = "product")
    @JsonManagedReference
    private Set<ProductImage> productImages;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                ", hide=" + hide +
                ", createAt=" + createAt +
                ", modifyAt=" + modifyAt +
//                ", categories=" + categories.toString() +
//                ", inventory=" + inventory +
//                ", discount=" + discount +
                '}';
    }
}
