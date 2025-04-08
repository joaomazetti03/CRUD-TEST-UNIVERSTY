package com.example.provacrud.Repository;

import com.example.provacrud.Model.MagicIten;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MagicItenRepository extends JpaRepository<MagicIten, Long> {
}
