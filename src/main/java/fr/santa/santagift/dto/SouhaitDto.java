package fr.santa.santagift.dto;

import fr.santa.santagift.model.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SouhaitDto {
    private CadeauDto cadeau;
    private Status status;
}
