package commonCode;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Utils {
	
	public static void checkDateTime() {
		
		System.out.println("DATE->");
		
		LocalDate localDate = LocalDate.now();
		System.out.println("Today: " + localDate);
		
		LocalDate birthday = LocalDate.of(1996, 03, 12);
		System.out.println("Birthday: " + birthday);
		
		LocalDate nextWeek = localDate.plusWeeks(1);
		System.out.println("Next week: " + nextWeek);
		
		
		System.out.println("\nTIME->");
		
		LocalTime localTime = LocalTime.now();
		System.out.println("Time Now: " + localTime);
		
		LocalTime bedtime = LocalTime.of(22, 30);
		System.out.println("BedTime: " + bedtime);
		
		System.out.println("\nDATE&TIME->");
		
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println("Local Date & Time: " + localDateTime);
		
		LocalDateTime future = localDateTime.plusDays(5).plusHours(3);
		System.out.println("Future Date & Time: " + future);
		
		System.out.println("\nZONED DATETIME->");
		ZonedDateTime zonedDateTime = ZonedDateTime.now();
		System.out.println("Zoned DateTime: " + zonedDateTime);
		
		Instant timeStamp = Instant.now();
		System.out.println("Timestamp: " + timeStamp);
		
		System.out.println("\nFormat & Parse->");
		
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String formattedDate = LocalDate.now().format(dateFormatter);
		System.out.println("Formatted Date: " + formattedDate);
		
		LocalDate parsed = LocalDate.parse("15-08-2025", dateFormatter);
		System.out.println("parsed Date: " + parsed);
		
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		String formattedTime = LocalTime.now().format(timeFormatter);
		System.out.println("Formatted Time: " + formattedTime);
		
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formattedDateTime = LocalDateTime.now().format(dateTimeFormatter);
		System.out.println("Formatted Date & Time: " + formattedDateTime);
		
		DateTimeFormatter timeConversionFormatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
		String hrs12Time = LocalTime.now().format(timeConversionFormatter);
		System.out.println("12HrsTime: " + hrs12Time);
		
		System.out.println("\nForeign Zone->");
		ZoneId zone = ZoneId.of("America/New_York");
		ZonedDateTime foreignZonedDateTime = ZonedDateTime.now(zone);
		System.out.println("Foreign Zoned Date Time: " + foreignZonedDateTime);
		
		
		System.out.println("\nConvert TimeZone to UTC->");
		ZonedDateTime utcTime = foreignZonedDateTime.withZoneSameInstant(ZoneId.of("UTC"));
		System.out.println("UTC Time: " + utcTime);

		
	}
	
	public static String loadAllZoneIds() {
//		List groupedZoneIds  = ZoneId.getAvailableZoneIds()
//			  .stream()
//			  .sorted()
//			  .collect(Collectors.toList());
		
		Map<String, List<String>> groupedZoneIds = ZoneId.getAvailableZoneIds()
	            .stream()
	            .collect(Collectors.groupingBy(
	                id -> id.split("/")[0],     // Extract continent
	                TreeMap::new,               // Sorted map by region
	                Collectors.collectingAndThen(
	                    Collectors.toList(),
	                    list -> list.stream().sorted().collect(Collectors.toList())
	                )
	            ));
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String groupedZoneIdsJson = gson.toJson(groupedZoneIds);
		System.out.println("GroupedZoneIdsJson: " + groupedZoneIdsJson);
		return groupedZoneIdsJson;
		
	}
	
	
	
	
	
	
	public static void main(String args[]) {
		checkDateTime();
		System.out.println("------------");
		loadAllZoneIds();
		System.out.println("------------");
	}

}
