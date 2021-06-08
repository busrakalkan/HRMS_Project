package kodlamaio.hrms.core.imageUpload;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.externalService.CloudinaryManager;

@Service
public class CloudinaryUploadAdapter implements CloudinaryUploadService{

	@Override
	public Map<String, Object> upload(MultipartFile multipartFile) {
		
		CloudinaryManager cloudinaryUpload = new CloudinaryManager();
		
		
			Map<String, Object> uploadResult;
			try {
				uploadResult = cloudinaryUpload.upload(multipartFile);
				return uploadResult;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		
		
	}

}
