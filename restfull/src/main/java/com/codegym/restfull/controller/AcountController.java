package com.codegym.restfull.controller;

import com.codegym.restfull.dto.AcountDTO;
import com.codegym.restfull.dto.AcountNoIdDTO;
import com.codegym.restfull.dto.AcountNoPassDTO;
import com.codegym.restfull.entity.Acount;
import com.codegym.restfull.servicce.AcountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/api/")
public class AcountController {
    @Autowired
    private AcountService acountService;


    @GetMapping("acounts/{id}")
    public ResponseEntity<AcountNoPassDTO> getById(@PathVariable long id){
        AcountNoPassDTO acountNoPassDTO = acountService.getById(id);
        return  new ResponseEntity<>(acountNoPassDTO, HttpStatus.OK);
    }

    @GetMapping("acounts")
    public ResponseEntity<List<AcountDTO>> getAll(){
        List<AcountDTO> acountDTOList = acountService.getAll();
        return new  ResponseEntity<>(acountDTOList, HttpStatus.OK);
    }
    @PostMapping("create")
    public ResponseEntity<AcountNoPassDTO> createAcount(@RequestBody AcountNoIdDTO acountNoIdDTO){
        AcountNoPassDTO acountNoPassDTO = acountService.create(acountNoIdDTO);
        if (acountNoPassDTO.getEmail().equals("")){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(acountNoPassDTO,HttpStatus.OK);
    }
    @PutMapping("edit/{id}")
    public ResponseEntity<AcountNoPassDTO> editAcount(@PathVariable long id,@RequestBody AcountNoPassDTO acountNoPassDTO){
        AcountNoPassDTO acountNoPassDTOResult = acountService.edit(id,acountNoPassDTO);
        if (acountNoPassDTOResult.getEmail().equals("")){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(acountNoPassDTOResult,HttpStatus.OK);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity deletAcount(@PathVariable long id){
        boolean result = acountService.delete(id);
        if (result){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
