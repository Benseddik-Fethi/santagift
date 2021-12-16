package fr.santa.santagift.dto;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CadeauDto {
    private String nom;
    private String image;
    private String url;
}
