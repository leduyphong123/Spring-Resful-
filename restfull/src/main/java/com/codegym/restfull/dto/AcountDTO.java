package com.codegym.restfull.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AcountDTO {
    private long id;
    private String email;

    private String fullName;
}
