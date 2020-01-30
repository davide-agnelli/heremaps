package com.heromaps.client.restapi;

import com.heromaps.client.dto.RouteDTO;
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
	ResponseEntity<EvaluateTravelPoint> calculates(@RequestBody RouteDTO route) {

		final List<WaypointDTO> waypoints = route.waypoints;

		if (waypoints == null) {
			throw new IllegalArgumentException("Waypoints required");
		}

		if (waypoints.size() < 2) {
			throw new IllegalArgumentException("Required minimum 2 waypoint ");
		}

		//TODO can be add mapper for transform dto to model
		for (WaypointDTO waypoint : waypoints) {
			if (waypoint.lat == null || waypoint.lng == null) {
				throw new IllegalArgumentException("Wrong number format for longitude or latitude");
			}
		}
		final EvaluateTravelPoint evaluateTravelPoint;
		try {
			evaluateTravelPoint = waypointFacade.calculate(route);
		} catch (IOException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>(evaluateTravelPoint, HttpStatus.OK);

	}

}