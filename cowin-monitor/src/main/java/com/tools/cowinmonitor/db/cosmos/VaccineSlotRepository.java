package com.tools.cowinmonitor.db.cosmos;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.azure.spring.data.cosmos.repository.Query;

@Repository
public interface VaccineSlotRepository extends CosmosRepository<VaccinationSlots, String> {
		
		@com.azure.spring.data.cosmos.repository.Query("SELECT DateTimePart('hh', c.time) AS hourValue ,  DateTimePart('mi', c.time) AS minuteValue, AVG(c.vaccine_count) AS vaccineCountAvg " + 
				"FROM c " + 
				"WHERE " + 
				"c.center_name = @center " + 
				"AND " + 
				"c.dose_value = 2 " + 
				"AND " + 
				"DateTimePart('hh', c.time) > 4 " + 
				"AND " + 
				"DateTimePart('mi', c.time) < 21 " + 
				"AND " + 
				"c.time > DateTimeAdd('mm', -1, c.time) " + 
				"GROUP BY DateTimePart('hh', c.time) , DateTimePart('mi', c.time)")
		public List<VaccinationSlots> findDailySlotTrend(@Param("center") String centerName);
		
		
		
		@Query("SELECT distinct c.center_name AS center_name FROM c WHERE c.time > DateTimeAdd('mm', -1, GetCurrentDateTime ())")
		public List<VaccinationSlots> findMainCenters();
}
