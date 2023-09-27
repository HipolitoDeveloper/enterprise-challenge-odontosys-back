package com.enterprisechallegenge.api.resources;

import com.enterprisechallegenge.api.entities.Procedure;
import com.enterprisechallegenge.api.services.ProcedureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/procedure")
public class ProcedureResource {

    @Autowired
    private ProcedureService service;


    @GetMapping
    public ResponseEntity<List<Procedure>> findAll() {
        List<Procedure> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Procedure> findById(@PathVariable Long id) {
        Procedure obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Procedure> insert(@RequestBody Procedure obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().body(id);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Procedure> update(@PathVariable Long id, @RequestBody Procedure obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
