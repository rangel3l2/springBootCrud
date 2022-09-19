package br.com.teste.meuprojeto.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.teste.meuprojeto.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    

    

    
}
