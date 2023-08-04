package com.codegym.restfull.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AcountNoIdDTO {
    private String email;
    private String password;
    private String fullName;
    private String address;
}
