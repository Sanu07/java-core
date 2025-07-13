package com.LLD.kvstore;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class Employee {

    private int id;
    private String name;
    private BigDecimal salary;
}
