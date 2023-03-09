package com.example.Starbucks.product.vo;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseProductImageList {
    private Long id;
    private Long productId;
    private String image;
}
