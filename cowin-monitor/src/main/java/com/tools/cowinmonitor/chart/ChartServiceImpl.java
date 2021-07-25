package com.tools.cowinmonitor.chart;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tools.cowinmonitor.db.cosmos.VaccinationSlots;
import com.tools.cowinmonitor.db.cosmos.VaccineSlotRepository;

@Service
public class ChartServiceImpl implements ChartService{
	
	@Autowired
	private VaccineSlotRepository vaccineSlotRepository;

	private final int START_HOUR = 5;
	private final int END_HOUR = 21;
	private final int MINUTE_GAP = 1;

	@Override
	public Map<String, Integer> getVisualizationData(String centerName) {
		//return getTimeRange();
		//return getTimeRange1();
		
		return this.process(vaccineSlotRepository.findDailySlotTrend(centerName));
		

	}
	
	

	
	@Override
	public List<String> getMainCenters() {
		List<String> mainCenters = new ArrayList<String>();
		
		List<VaccinationSlots> fetchedCentersList = vaccineSlotRepository.findMainCenters();
		fetchedCentersList.forEach(slot -> {
			mainCenters.add(slot.getCenter_name());
		//	System.out.println(slot.getCenter_name());
		});
		
		return mainCenters;
	}




	private Map<String, Integer> process(List<VaccinationSlots> vaccineSlots) {
		
		Map<String, Integer> timeSeriesSlotMap = this.getTimeRange();
		
		vaccineSlots.forEach(slot -> {
			System.out.println(slot.getHourValue() + " : " + slot.getVaccineCountAvg() + " : " + slot.getVaccineCountAvg());
		});
		
		vaccineSlots.forEach(slots -> {
			timeSeriesSlotMap.put( 
					convertNumberToStringWithCustomCharacters(2,slots.getHourValue()) + ":" + convertNumberToStringWithCustomCharacters(2, slots.getMinuteValue()) , 
					slots.getVaccineCountAvg());
			
		});
		
		
		return timeSeriesSlotMap;
	}
	
	private String convertNumberToStringWithCustomCharacters(int characterCount, int num) {
		if(num <10) {
			String repeat = "";
			for(int i=0; i<characterCount -1; i ++) {
				repeat += "0";
			}
			return repeat + num;
		}
		return num + "";
		
	}


	private Map<String, Integer> getTimeRange1() {
		Map<String, Integer> timeSeriesSlotMap = new LinkedHashMap<String, Integer>();
		timeSeriesSlotMap.put("8:00", 5);
		timeSeriesSlotMap.put("8:05", 6);
		timeSeriesSlotMap.put("8:10", 10);
		timeSeriesSlotMap.put("8:15", 13);
		timeSeriesSlotMap.put("8:20", 16);
		timeSeriesSlotMap.put("8:25", 3);
		timeSeriesSlotMap.put("8:30", 16);
		timeSeriesSlotMap.put("8:35", 14);
		timeSeriesSlotMap.put("8:40", 0);
		timeSeriesSlotMap.put("8:45", 0);
		timeSeriesSlotMap.put("8:50", 0);
		timeSeriesSlotMap.put("8:55", 0);
		timeSeriesSlotMap.put("9:00", 10);
		timeSeriesSlotMap.put("8:05", 30);
		timeSeriesSlotMap.put("8:10", 3);
		timeSeriesSlotMap.put("8:15", 10);
		timeSeriesSlotMap.put("8:20", 24);
		timeSeriesSlotMap.put("8:25", 49);
		timeSeriesSlotMap.put("8:30", 30);
		
		return timeSeriesSlotMap;
	}


	private Map<String, Integer> getTimeRange() {
		Map<String, Integer> timeSeriesSlotMap = new LinkedHashMap<String, Integer>();


		LocalTime startTime = LocalTime.of(START_HOUR, 00);
		LocalTime endTime = LocalTime.of(END_HOUR, 00);
		LocalTime time = startTime;
		while(time.isBefore(endTime)) {
			if(time.equals(startTime)) {
				timeSeriesSlotMap.put(time.format(DateTimeFormatter.ofPattern("HH:mm")), 0);
				time = time.plusMinutes(MINUTE_GAP);
			} else {
				timeSeriesSlotMap.put(time.plusMinutes(MINUTE_GAP).format(DateTimeFormatter.ofPattern("HH:mm")), 0);
				time = time.plusMinutes(MINUTE_GAP);
			}
		}

		timeSeriesSlotMap.forEach((i,j) -> System.out.println(i));
		return timeSeriesSlotMap;
	}
}
