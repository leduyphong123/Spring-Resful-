package com.codegym.restfull.converter;

import com.codegym.restfull.dto.AcountNoPassDTO;
import com.codegym.restfull.entity.Acount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class AcountNoPassDTOConvert implements Function<Acount, AcountNoPassDTO> {

    @Override
    public AcountNoPassDTO apply(Acount acount) {
        AcountNoPassDTO acountNoPassDTO = new AcountNoPassDTO();
        BeanUtils.copyProperties(acount,acountNoPassDTO);
        return acountNoPassDTO;
    }
}
