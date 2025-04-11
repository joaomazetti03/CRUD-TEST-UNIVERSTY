package com.example.provacrud.Repository;

import com.example.provacrud.Model.MagicIten;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MagicItenRepository extends JpaRepository<MagicIten, Long> {
    List<MagicIten> findByCharacterId(Long characterId);
}
