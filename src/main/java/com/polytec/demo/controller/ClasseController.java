package com.polytec.demo.controller;

import static org.springframework.http.ResponseEntity.ok;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.polytec.demo.Utils.ApiResponse;
import com.polytec.demo.entity.Classe;
import com.polytec.demo.entity.Personne;
import com.polytec.demo.service.ClasseService;



@RestController
@CrossOrigin("*")
@RequestMapping("/api/classe")
public class ClasseController {

	@Autowired
    ClasseService classeService;
	@PutMapping(path="/getall")
    public ResponseEntity<HashMap<Object, Object>> getAllClasse(){
        HashMap<Object, Object> model=new HashMap<>();
        try {
            List<Classe> listClasse = classeService.getAll();
            model.put("success",1);
            model.put("list", listClasse);
        } catch (Exception e) {
            model.put("success",0);
            model.put("message",e.getMessage());
        }
        return ok(model);
    }

    @PostMapping("/add")
    public ApiResponse add(@RequestBody Classe classe) {

        return null;

    }
}
