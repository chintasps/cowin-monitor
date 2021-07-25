package com.tools.cowinmonitor.chart;

import java.util.List;
import java.util.Map;

public interface ChartService {
	public Map<String, Integer> getVisualizationData(String centerName);
	
	public List<String> getMainCenters();

}
