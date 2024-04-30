package br.com.uploaddownloadarchive.resource;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import br.com.uploaddownloadarchive.dto.ArchiveDTO;
import br.com.uploaddownloadarchive.model.Archive;
import br.com.uploaddownloadarchive.service.ArchiveService;

@Controller
public class ArchiveResource {
	
	@Autowired
	private ArchiveService archiveService;

	@GetMapping("/helloworld")
	public ResponseEntity<Map<String, String>> helloWorld() {
		Map<String, String> response = Collections.singletonMap("message", "Hello World!");
		return ResponseEntity.ok(response);
	}
	
	@PostMapping(path = "/upload", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE }) 
	public ResponseEntity<ArchiveDTO> upload(@RequestPart(name = "file")  MultipartFile file) {
		ArchiveDTO archiveSaved = new ArchiveDTO(archiveService.upload(file));
		return new ResponseEntity<ArchiveDTO>(archiveSaved, HttpStatus.CREATED);
	}
	
	@GetMapping("/download/{idArchive}")
	public ResponseEntity<Resource> download(@PathVariable Long idArchive) {
		Archive archiveSaved = archiveService.download(idArchive);
		ByteArrayResource resource = new ByteArrayResource(archiveSaved.getContent());
		HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(archiveSaved.getContentType()));
        headers.setContentDispositionFormData("attachment", archiveSaved.getOriginalFileName());
		return ResponseEntity.ok()
				.headers(headers)
				.body(resource);
	}
	
	@GetMapping("/files")
	public ResponseEntity<List<ArchiveDTO>> getAllFiles() {
		return ResponseEntity.ok(archiveService.getAllFiles());
	}
	
	@DeleteMapping("/files/{idArchive}")
	public ResponseEntity<Void> deleteByIdArchive(@PathVariable Long idArchive) {
		archiveService.deleteByIdArchive(idArchive);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
