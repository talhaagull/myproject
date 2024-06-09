package com.patika.kitapyurdum.controller;

import com.patika.kitapyurdum.dto.request.CustomerSaveRequest;
import com.patika.kitapyurdum.dto.request.MagazineSaveRequest;
import com.patika.kitapyurdum.model.Magazine;
import com.patika.kitapyurdum.service.MagazineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/magazines")
public class MagazineController {

    @Autowired
    private MagazineService magazineService;

//    @PostMapping("/save")
//    public void save(@RequestBody MagazineSaveRequest request){
//        magazineService.save(request);
//    }

    @GetMapping
    public List<Magazine> getAllMagazines() {
        return magazineService.getAllMagazines();
    }
}