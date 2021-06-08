package kodlamaio.hrms.core.imageUpload;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface CloudinaryUploadService {
	
	Map<String, Object> upload(MultipartFile multipartFile);
}
