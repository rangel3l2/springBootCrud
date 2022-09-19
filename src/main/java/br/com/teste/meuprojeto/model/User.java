package br.com.teste.meuprojeto.model;





import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "user", schema="testemiguel")
public class User {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String nome;
   
    public String erro(){
       return "não encontrado usuario";
    }
}
