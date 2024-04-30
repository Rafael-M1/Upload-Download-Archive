package br.com.uploaddownloadarchive.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.uploaddownloadarchive.dto.ArchiveDTO;
import br.com.uploaddownloadarchive.model.Archive;

@Repository
public interface ArchiveRepository extends JpaRepository<Archive, Long>{

	@Query("SELECT new br.com.uploaddownloadarchive.dto.ArchiveDTO("
			+ "a.idArchive,"
			+ "a.contentType,"
			+ "a.name,"
			+ "a.originalFileName,"
			+ "a.bytes"
			+ ") "
			+ "FROM Archive a ")
	List<ArchiveDTO> getAllFilesWithoutContent();

}
