package fr.santa.santagift.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EnfantDto {
    private Long id;
    private String nom;
    private String prenom;
    private Set<SouhaitDto> souhaitList;
    private Set<CadeauDto> cadeauList;
}
