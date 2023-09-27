package com.enterprisechallegenge.api.resources;

import com.enterprisechallegenge.api.entities.Office;
import com.enterprisechallegenge.api.services.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/office")
public class OfficeResource {

    @Autowired
    private OfficeService service;


    @GetMapping
    public ResponseEntity<List<Office>> findAll() {
        List<Office> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Office> findById(@PathVariable Long id) {
        Office obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Office> insert(@RequestBody Office obj) {
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
    public ResponseEntity<Office> update(@PathVariable Long id, @RequestBody Office obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
