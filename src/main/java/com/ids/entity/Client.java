package com.ids.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.Embedded.OnEmpty;

import com.ids.support.data.entity.UuidPersistent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor @AllArgsConstructor
public class Client implements UuidPersistent {
	
	@Id
	private String id;
	private String nom;
	private String ice;
	private String tel;
	private String mobile;
	private String email;
	
	@Embedded(onEmpty = OnEmpty.USE_EMPTY)
	private Adresse adresse;
	@Embedded.Nullable(prefix = "facture_")
	private Adresse adresseFacturation;

}
