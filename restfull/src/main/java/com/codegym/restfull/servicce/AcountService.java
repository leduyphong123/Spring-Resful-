package com.codegym.restfull.servicce;

import com.codegym.restfull.dto.AcountDTO;
import com.codegym.restfull.dto.AcountNoIdDTO;
import com.codegym.restfull.dto.AcountNoPassDTO;
import com.codegym.restfull.entity.Acount;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AcountService {
    List<AcountDTO> getAll();

    AcountNoPassDTO create(AcountNoIdDTO acountNoIdDTO);

    AcountNoPassDTO edit(long id, AcountNoPassDTO acountNoPassDTO);

    boolean delete(long id);
}
