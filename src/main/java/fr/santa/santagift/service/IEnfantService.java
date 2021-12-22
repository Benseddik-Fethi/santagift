package fr.santa.santagift.service;

import fr.santa.santagift.dto.EnfantDto;

import java.util.List;
import java.util.Optional;

public interface IEnfantService {

    Optional<EnfantDto>save(EnfantDto enfantDto);
    Optional<EnfantDto>findById(Long id);
    List<EnfantDto>findAll();
    Optional<EnfantDto> update(EnfantDto enfantDto);
    void delete(Long id);
}
