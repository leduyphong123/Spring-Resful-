package com.codegym.restfull.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AcountNoPassDTO {
    private long id;
    private String email;
    private String fullName;
    private String address;
}
