package com.tutorialspring.tutorial.api.model;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteIdInput {
	@NotNull
	private int id;
}
