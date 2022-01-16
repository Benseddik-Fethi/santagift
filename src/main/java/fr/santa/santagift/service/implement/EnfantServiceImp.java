package fr.santa.santagift.service.implement;

import fr.santa.santagift.dto.EnfantDto;
import fr.santa.santagift.model.Enfant;
import fr.santa.santagift.repository.EnfantRepository;
import fr.santa.santagift.service.IEnfantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class EnfantServiceImp implements IEnfantService {
//test
    private final EnfantRepository enfantRepository;
    private final ModelMapper modelMapper;

    @Override
    public Optional<EnfantDto> save(EnfantDto enfantDto) {
        return Optional.of(enfantRepository.save(modelMapper.map(enfantDto, Enfant.class)))
                .map(enfant -> modelMapper.map(enfant, EnfantDto.class));
    }

    @Override
    public Optional<EnfantDto> findById(Long id) {
        Optional<Enfant> optEnfant = enfantRepository.findById(id);
        return optEnfant.map(enfant -> modelMapper.map(enfant, EnfantDto.class));
    }

    @Override
    public List<EnfantDto> findAll() {
        List<Enfant> enfants = enfantRepository.findAll();
        return enfants.stream()
                .map(enfant -> modelMapper.map(enfant, EnfantDto.class))
                .collect(Collectors.toList());

    }

    @Override
    public Optional<EnfantDto> update(EnfantDto enfantDto) {
        return findById(enfantDto.getId())
                .map(enfant -> {
                    enfant.setNom(enfantDto.getNom());
                    enfant.setPrenom(enfantDto.getPrenom());
                    return save(enfant);
                })
                .map(enfant -> modelMapper.map(enfant, EnfantDto.class));
    }

    @Override
    public void delete(Long id) {
        enfantRepository.deleteById(id);
    }
}


