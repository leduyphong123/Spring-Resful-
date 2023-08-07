package com.codegym.restfull.converter;

import com.codegym.restfull.dto.AcountNoIdDTO;
import com.codegym.restfull.entity.Acount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class AcountNoIdDTOConvert implements Function<AcountNoIdDTO, Acount> {
    @Override
    public Acount apply(AcountNoIdDTO acountNoIdDTO) {
        Acount acount = new Acount();
        BeanUtils.copyProperties(acountNoIdDTO,acount);
        return acount;
    }
}
