package com.codegym.restfull.servicce.impl;

import com.codegym.restfull.dto.AcountDTO;
import com.codegym.restfull.dto.AcountNoIdDTO;
import com.codegym.restfull.dto.AcountNoPassDTO;
import com.codegym.restfull.entity.Acount;
import com.codegym.restfull.repository.AcountRepository;
import com.codegym.restfull.servicce.AcountService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Service
@AllArgsConstructor
public class AcountServiceImpl implements AcountService {
    private AcountRepository acountRepository;
    private ModelMapper modelMapper;
    private Function<Acount,AcountDTO> convertAcountDTO;
    private Function<AcountNoIdDTO,Acount> convertAcountNoIdDTO;
    private Function<Acount,AcountNoPassDTO> convertAcountNoPassDTO;
    @Override
    public List<AcountDTO> getAll() {
        List<Acount> acountList = (List<Acount>) acountRepository.findAll();
        List<AcountDTO> acountDTOList = new ArrayList<>();
        for (Acount element: acountList){
            acountDTOList.add(convertAcountDTO.apply(element));
        }
//        List<AcountDTO> acountDTOList = modelMapper.map(acountList,new TypeToken<List<AcountDTO>>(){}.getType());

        return acountDTOList;
    }

    @Override
    public AcountNoPassDTO create(AcountNoIdDTO acountNoIdDTO) {
//        Acount acount = modelMapper.map(acountNoIdDTO,Acount.class);
        Acount acount = convertAcountNoIdDTO.apply(acountNoIdDTO);
        Acount acountResult = acountRepository.save(acount);
//        return modelMapper.map(acountResult,AcountNoPassDTO.class);
        return convertAcountNoPassDTO.apply(acountResult);
    }


    @Override
    public AcountNoPassDTO edit(long id, AcountNoPassDTO acountNoPassDTO) {
        Acount acount = modelMapper.map(acountNoPassDTO,Acount.class);
        acount.setId(id);
        Acount temp = acountRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("not id"));
        acount.setPassword(temp.getPassword());
        Acount acountResult = acountRepository.save(acount);
//        return modelMapper.map(acountResult,AcountNoPassDTO.class);
        return convertAcountNoPassDTO.apply(acountResult);
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

    @Override
    public AcountNoPassDTO getById(long id) {
        Acount acount = acountRepository.findById(id).orElseThrow( () -> new IllegalArgumentException("not id"));
//        return modelMapper.map(acount, AcountNoPassDTO.class);
        return convertAcountNoPassDTO.apply(acount);

    }
}
