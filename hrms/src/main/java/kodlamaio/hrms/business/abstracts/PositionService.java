package kodlamaio.hrms.business.abstracts;

import java.util.List;
import kodlamaio.hrms.entities.concretes.Position;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;


public interface PositionService {
	
	DataResult<List<Position>> getAll();

    Result add(Position position);
   
    DataResult<Position> getByPositionName(String productName);
}
