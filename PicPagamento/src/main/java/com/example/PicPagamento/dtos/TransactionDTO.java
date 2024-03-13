package com.example.PicPagamento.dtos;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO {

    public BigDecimal value;
    public Long senderId;
    public Long receiverId;

}
