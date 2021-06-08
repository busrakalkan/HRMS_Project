package kodlamaio.hrms.business.abstracts;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Resume;
import kodlamaio.hrms.entities.dtos.ResumeDto;


public interface ResumeService {
	
	DataResult<List<Resume>> getAll();
	Result add(Resume resume);
	DataResult<Resume> getByJobSeekerId(int id);
	DataResult<ResumeDto> getResumeDtoByJobSeekerId(int id);
	DataResult<String> uploadPhoto(Integer id,MultipartFile filePath) throws IOException ;
}
