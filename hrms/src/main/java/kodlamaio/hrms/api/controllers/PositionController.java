package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.PositionService;
import kodlamaio.hrms.entities.concretes.Position;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;


@RestController
@RequestMapping("/api/position")
public class PositionController {
	
	private PositionService positionService;
	
	
	@Autowired
	public PositionController(PositionService positionService) {
		super();
		this.positionService = positionService;
	}
	@GetMapping("/getall")
	public DataResult<List<Position>> getAll(){
		return this.positionService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Position position) {
		return this.positionService.add(position);
	}
	
	@GetMapping("/getByProductName")
	public DataResult<Position> getByProductName(@RequestParam String positionName){
		return this.positionService.getByPositionName(positionName);
	}


}
