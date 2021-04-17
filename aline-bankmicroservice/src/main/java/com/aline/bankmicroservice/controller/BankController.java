package com.aline.bankmicroservice.controller;

import com.aline.bankmicroservice.service.BankService;
import com.aline.core.dto.branch.BankDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/bank")
public class BankController {
    private HttpHeaders httpHeaders;
    private BankService bankService;

    @GetMapping("")
    public ResponseEntity<List<BankDTO>> getAllBanks(){
        List<BankDTO> allbanks = bankService.getAllBanks();

        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(allbanks, httpHeaders, HttpStatus.OK);
    }
}
