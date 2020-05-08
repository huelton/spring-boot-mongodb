package com.project.form;

import java.io.Serializable;

import com.project.domain.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserForm implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;
	private String email;
	
	public UserForm(User obj) {
		nome = obj.getNome();
		email = obj.getEmail();
	}
	
}
