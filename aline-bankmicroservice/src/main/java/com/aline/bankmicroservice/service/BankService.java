package com.aline.bankmicroservice.service;

import com.aline.core.dto.branch.BankDTO;
import com.aline.core.exception.bank.BanksNotFoundException;
import com.aline.core.model.bank.Bank;
import com.aline.core.repository.branch.BankRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class BankService {
    private final ModelMapper modelMapper;
    private final BankRepository bankRepository;

    public List<BankDTO> getAllBanks(){

        try {
            List<Bank> allBanks = bankRepository.findAll();

            return allBanks.stream()
                    .map(bank -> modelMapper.map(bank, BankDTO.class))
                    .collect(Collectors.toList());
        }catch (Exception e){
            log.error(e.getMessage());
            throw new BanksNotFoundException();
        }
    }

}
