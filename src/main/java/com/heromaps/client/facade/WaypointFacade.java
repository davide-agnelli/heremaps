package com.heromaps.client.facade;

import com.heromaps.client.dto.WaypointDTO;
import com.heromaps.client.result.EvaluateTravelPoint;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class WaypointFacade {
	
	public EvaluateTravelPoint calculate(List<WaypointDTO> waypoints) throws IOException {

		return new EvaluateTravelPoint();
	}

}