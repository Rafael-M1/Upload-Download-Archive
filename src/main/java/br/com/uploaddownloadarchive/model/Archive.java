package br.com.uploaddownloadarchive.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Archive {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idArchive;
	@Column(name = "CONTENT_TYPE")
	private String contentType;
	private String name;
	@Column(name = "ORIGINAL_FILE_NAME")
	private String originalFileName;
	private Long bytes;
	@Column(columnDefinition = "BLOB")
	private byte[] content;

	public Archive() {
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

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Archive [idArchive=" + idArchive + ", contentType=" + contentType + ", name=" + name
				+ ", originalFileName=" + originalFileName + ", bytes=" + bytes + "]";
	}

}
