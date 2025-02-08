package org.mdzahidhasanjamil.citest1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "logos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Logo {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String name;

@Lob
@Column(columnDefinition = "LONGBLOB")
private byte[] image;
}
