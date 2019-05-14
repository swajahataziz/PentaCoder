package com.averros.data.codemapper.controller;

import com.averros.data.codemapper.model.Umls.CodingSystem;
import com.averros.data.codemapper.repository.CodingSystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CodingSystemController {

    @Autowired
    private CodingSystemRepository codingSystemRepository;

    @GetMapping("/codingSystems")
    public List<CodingSystem> getCodingSystems() {
        return codingSystemRepository.getCodingSystems();
    }
}
