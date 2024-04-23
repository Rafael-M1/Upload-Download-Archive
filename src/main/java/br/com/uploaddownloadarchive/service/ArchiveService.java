package br.com.uploaddownloadarchive.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.uploaddownloadarchive.exception.ArchiveException;
import br.com.uploaddownloadarchive.model.Archive;
import br.com.uploaddownloadarchive.repository.ArchiveRepository;

@Service
public class ArchiveService {

	@Autowired
	private ArchiveRepository archiveRepository;
	
	public Archive upload(MultipartFile file) {
		try {
			Archive archive = new Archive();
			archive.setBytes(file.getSize());
			archive.setContentType(file.getContentType());
			archive.setName(file.getName());
			archive.setOriginalFileName(file.getOriginalFilename());
			archive.setContent(file.getBytes());
			archive = archiveRepository.save(archive);
			return archive;
		} catch (IOException e) {
			throw new ArchiveException("Error accessing the file");
		}
	}

	public Archive download(Long idArchive) {
		return archiveRepository.findById(idArchive)
			.orElseThrow(() -> new ArchiveException("Archive not Found"));
	}
}
