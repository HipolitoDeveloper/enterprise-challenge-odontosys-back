package com.enterprisechallegenge.api.services;

import com.enterprisechallegenge.api.entities.Doctor;
import com.enterprisechallegenge.api.repositories.DoctorRepository;
import com.enterprisechallegenge.api.services.exceptions.DatabaseException;
import com.enterprisechallegenge.api.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;


@Service
public class DoctorService {

    @Autowired
    private DoctorRepository repository;

    public List<Doctor> findAll() {
        return repository.findAll();
    }

    public Doctor findById(Long id) {
        Optional<Doctor> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Doctor insert(Doctor obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }
    public Doctor update(Long id, Doctor obj) {
        try {
            Doctor entity = repository.getById(id);
            updateData(entity, obj);

            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Doctor entity, Doctor obj) {
        entity.setCrm(obj.getCrm());
        entity.setMatricula(obj.getMatricula());
        entity.setNome(obj.getNome());
    }

}
