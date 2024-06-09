package com.patika.kitapyurdum.service;

import com.patika.kitapyurdum.dto.request.MagazineSaveRequest;
import com.patika.kitapyurdum.model.Magazine;
import com.patika.kitapyurdum.repository.InvoiceRepository;
import com.patika.kitapyurdum.repository.MagazineRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class MagazineService {

    @Autowired
    private MagazineRepository magazineRepository;

//    public Magazine save(MagazineSaveRequest magazine) {
//        Magazine savedMagazine = magazineRepository.save(magazine);
//        return savedMagazine;
//    }

    public List<Magazine> getAllMagazines() {
        return magazineRepository.findAll();
    }


}
