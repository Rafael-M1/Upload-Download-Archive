package br.com.uploaddownloadarchive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.uploaddownloadarchive.model.Archive;

@Repository
public interface ArchiveRepository extends JpaRepository<Archive, Long>{

}
