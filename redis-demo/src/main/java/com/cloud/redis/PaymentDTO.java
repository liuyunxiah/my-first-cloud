package com.cloud.redis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO implements Serializable {

    private Long id;
    private String serical;
}
