package kosta.mvc.model.dto;

import org.springframework.web.multipart.MultipartFile;

public class UploadDTO {
	private String name;
	private MultipartFile file; // upLoadForm�� <input name="file" �� ���ƾ��Ѵ�

	private String fileName;
	private long fileSize;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

}
