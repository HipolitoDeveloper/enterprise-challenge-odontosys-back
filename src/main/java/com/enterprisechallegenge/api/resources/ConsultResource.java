package com.enterprisechallegenge.api.resources;

import com.enterprisechallegenge.api.entities.Consult;
import com.enterprisechallegenge.api.services.ConsultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/consult")
public class ConsultResource {

    @Autowired
    private ConsultService service;


    @GetMapping
    public ResponseEntity<List<Consult>> findAll() {
        List<Consult> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Consult> findById(@PathVariable Long id) {
        Consult obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Consult> insert(@RequestBody Consult obj) {
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
    public ResponseEntity<Consult> update(@PathVariable Long id, @RequestBody Consult obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
