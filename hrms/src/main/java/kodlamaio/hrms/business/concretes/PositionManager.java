package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.PositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.dataAccess.abstracts.PositionDao;
import kodlamaio.hrms.entities.concretes.Position;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;


@Service
public class PositionManager implements PositionService{

	private PositionDao positionDao;
	
	public PositionManager(PositionDao positionDao) {
		super();
		this.positionDao=positionDao;
	}

	@Override
	public DataResult<List<Position>> getAll() {
		return new SuccessDataResult<List<Position>>
		(this.positionDao.findAll(),"Pozisyonlar listelendi");
		
	}

	@Override
	public Result add(Position position) {
		
		Position check = this.positionDao.getByPositionName(position.getPositionName());
		if(check == null) {
			this.positionDao.save(position);
			return new SuccessResult("Pozisyon eklendi");
		}else {
			return new ErrorResult("Pozisyon zaten var");
		}
		
		
	}

	@Override
	public DataResult<Position> getByPositionName(String positionName) {
		return new SuccessDataResult<Position>(this.positionDao.getByPositionName(positionName));
		
	}

}
