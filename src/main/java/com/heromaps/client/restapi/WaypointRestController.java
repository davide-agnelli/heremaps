package com.heromaps.client.restapi;

import com.heromaps.client.dto.WaypointDTO;
import com.heromaps.client.facade.WaypointFacade;
import com.heromaps.client.result.EvaluateTravelPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/waypoint")
public class WaypointRestController {

	@Autowired
	private WaypointFacade waypointFacade;

	@PostMapping
	ResponseEntity<EvaluateTravelPoint> calculates(@RequestBody List<WaypointDTO> waypoints) {

		if (waypoints == null) {
			throw new IllegalArgumentException("Waypoints required");
		}

		for (WaypointDTO waypoint : waypoints) {
			if (waypoint.lat == null || waypoint.lng == null) {
				throw new IllegalArgumentException("Wrong number format for longitude or latitude");
			}
		}

		//TODO replace EvaluateTravelPoint with dto
		//TODO add mapper for convert EvaluateTravelPoint with EvaluateTravelPointDTO and WaypointDTO to Waypoint
		final EvaluateTravelPoint evaluateTravelPoint;
		try {
			evaluateTravelPoint = waypointFacade.calculate(waypoints);
		} catch (IOException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>(evaluateTravelPoint, HttpStatus.OK);

	}

}