package com.codegym.restfull.converter;

import com.codegym.restfull.dto.AcountDTO;
import com.codegym.restfull.entity.Acount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class AcountDTOConvert implements Function<Acount, AcountDTO> {

    @Override
    public AcountDTO apply(Acount acount) {
        AcountDTO acountDTO = new AcountDTO();
        BeanUtils.copyProperties(acount,acountDTO);
        return acountDTO;
    }
}
