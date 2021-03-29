package com.example.AutoWorkShop.repository;

import com.example.AutoWorkShop.domain.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
//    List<ClientEntity> findAll();

    List<ClientEntity> findAllByFirstName(String firstName);

    List<ClientEntity> findAllByFirstNameContains(String firstName);

    List<ClientEntity> findAllBySecondName(String secondName);

    List<ClientEntity> findAllByTelephone(String telephone);

    Optional<ClientEntity> findByTelephoneContains(String telephone);

    Optional<ClientEntity> findById(Long id);
}
