package com.codegym.restfull.servicce.impl;

import com.codegym.restfull.dto.AcountDTO;
import com.codegym.restfull.dto.AcountNoIdDTO;
import com.codegym.restfull.dto.AcountNoPassDTO;
import com.codegym.restfull.entity.Acount;
import com.codegym.restfull.repository.AcountRepository;
import com.codegym.restfull.servicce.AcountService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AcountServiceImpl implements AcountService {
    @Autowired
    private AcountRepository acountRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<AcountDTO> getAll() {
        List<Acount> acountList = (List<Acount>) acountRepository.findAll();

        List<AcountDTO> acountDTOList = modelMapper.map(acountList,new TypeToken<List<AcountDTO>>(){}.getType());

        return acountDTOList;
    }

    @Override
    public AcountNoPassDTO create(AcountNoIdDTO acountNoIdDTO) {
        Acount acount = modelMapper.map(acountNoIdDTO,Acount.class);
        Acount acountResult = acountRepository.save(acount);
        return modelMapper.map(acountResult,AcountNoPassDTO.class);
    }

    @Override
    public AcountNoPassDTO edit(long id, AcountNoPassDTO acountNoPassDTO) {
        Acount acount = modelMapper.map(acountNoPassDTO,Acount.class);
        acount.setId(id);
        Acount temp = acountRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("not id"));
        acount.setPassword(temp.getPassword());
        Acount acountResult = acountRepository.save(acount);
        return modelMapper.map(acountResult,AcountNoPassDTO.class);
    }

    @Override
    public boolean delete(long id) {
        Acount acount = acountRepository.findById(id).orElseThrow( () -> new IllegalArgumentException("not id"));
        if (acount.getEmail().equals("")){
            return false;
        }
        acountRepository.deleteById(id);
        return true;
    }
}
