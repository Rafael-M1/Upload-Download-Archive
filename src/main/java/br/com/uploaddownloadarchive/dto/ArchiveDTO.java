package br.com.uploaddownloadarchive.dto;

import br.com.uploaddownloadarchive.model.Archive;

public class ArchiveDTO {
	private Long idArchive;
	private String contentType;
	private String name;
	private String originalFileName;
	private Long bytes;

	public ArchiveDTO() {
	}
	
	public ArchiveDTO(Long idArchive, String contentType, String name, String originalFileName, Long bytes) {
		this.idArchive = idArchive;
		this.contentType = contentType;
		this.name = name;
		this.originalFileName = originalFileName;
		this.bytes = bytes;
	}

	public ArchiveDTO(Archive archive) {
		this.idArchive = archive.getIdArchive();
		this.contentType = archive.getContentType();
		this.name = archive.getName();
		this.originalFileName = archive.getOriginalFileName();
		this.bytes = archive.getBytes();
	}
	
	public Long getIdArchive() {
		return idArchive;
	}

	public void setIdArchive(Long idArchive) {
		this.idArchive = idArchive;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOriginalFileName() {
		return originalFileName;
	}

	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}

	public Long getBytes() {
		return bytes;
	}

	public void setBytes(Long bytes) {
		this.bytes = bytes;
	}

	@Override
	public String toString() {
		return "ArchiveDTO [idArchive=" + idArchive + ", contentType=" + contentType + ", name=" + name
				+ ", originalFileName=" + originalFileName + ", bytes=" + bytes + "]";
	}

}
