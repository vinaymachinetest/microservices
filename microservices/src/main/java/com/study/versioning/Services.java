package com.study.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Services {

	/*First way doing versioning 
	 * creating different services according to enhancement also called URI versioning
	 */
	@GetMapping("/versioning/v1")
	public EmpDetails_V1 empV1() {		
		return new EmpDetails_V1(new Empdetails("vinay"));
	}
	
	@GetMapping("/versioning/v2")
	public EmpDetails_V2 empV2() {		
		return new EmpDetails_V2("vinay", "bangalore", "80000");
	}
	//**************************************************************
	
	/* 2nd way doing versioning 
	 * passing versions in query parameter in request
	 */
	@GetMapping(path ="/versioning/param/v1", params = "version=1")
	public EmpDetails_V1 empV1_Params() {		
		return new EmpDetails_V1(new Empdetails("vinay"));
	}
	
	@GetMapping(path ="/versioning/param/v1", params = "version=2")
	public EmpDetails_V2 empV2_Params() {		
		return new EmpDetails_V2("vinay", "bangalore", "80000");
	}
	//**************************************************************
	
	/* 3rd way doing versioning 
	 * passing versions in request header
	 */
	@GetMapping(path ="/versioning/header/v1", headers = "API-VERSION=1")
	public EmpDetails_V1 empV1_Header() {		
		return new EmpDetails_V1(new Empdetails("vinay"));
	}
	
	@GetMapping(path ="/versioning/header/v1", headers = "API-VERSION=2")
	public EmpDetails_V2 empV2_Header() {		
		return new EmpDetails_V2("vinay", "bangalore", "80000");
	}
	//**************************************************************
	
	/* 4th way doing versioning 
	 * passing versions in Accept header or called accept header versioning
	 */
	@GetMapping(path ="/versioning/produces/v1", produces = "application/app-v1+json")
	public EmpDetails_V1 empV1_Produces() {		
		return new EmpDetails_V1(new Empdetails("vinay"));
	}
	
	@GetMapping(path ="/versioning/produces/v1", produces = "application/app-v2+json")
	public EmpDetails_V2 empV2_Produces() {		
		return new EmpDetails_V2("vinay", "bangalore", "80000");
	}
}
