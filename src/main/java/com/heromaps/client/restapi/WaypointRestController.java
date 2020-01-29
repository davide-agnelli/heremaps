package com.heremaps.client.restapi;

import com.heremaps.client.dto.WaypointDTO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/waypoint")
public class WaypointRestController {

	@PostMapping
	Long calculates(@RequestBody WaypointDTO waypointDTO){
		return 1L;
	}

}