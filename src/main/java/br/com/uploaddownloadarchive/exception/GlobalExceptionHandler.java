package br.com.uploaddownloadarchive.exception;

import java.util.Collections;
import java.util.Map;

import org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException;
import org.apache.tomcat.util.http.fileupload.impl.SizeLimitExceededException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ArchiveException.class)
	public ResponseEntity<Map<String, String>> handleException(ArchiveException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap("Error", ex.getMessage()));
	}

	@ExceptionHandler(FileSizeLimitExceededException.class)
	public ResponseEntity<Map<String, String>> handleException(FileSizeLimitExceededException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap("Error", ex.getMessage()));
	}

	@ExceptionHandler(SizeLimitExceededException.class)
	public ResponseEntity<Map<String, String>> handleException(SizeLimitExceededException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap("Error", ex.getMessage()));
    }
}
