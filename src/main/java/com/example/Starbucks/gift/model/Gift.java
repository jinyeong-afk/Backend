package com.example.Starbucks.gift.model;

import com.example.Starbucks.product.model.Product;
import com.example.Starbucks.users.model.User;
import com.example.Starbucks.utility.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Gift extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Product product;
    private String sendId;
    private int status;
    private String imgUrl;
    private int payType;
    private int productCount;
}
