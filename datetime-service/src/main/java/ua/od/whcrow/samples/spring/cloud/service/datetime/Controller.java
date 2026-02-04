package ua.od.whcrow.samples.spring.cloud.service.datetime;

import jakarta.annotation.PostConstruct;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@RestController
class Controller {
	
	@Value("${app.datetime.format:yyyy-MM-dd'T'HH:mm:ss.SSSZ}")
	private String format;
	
	private DateTimeFormatter formatter;
	
	@PostConstruct
	protected void postConstruct() {
		formatter = DateTimeFormatter.ofPattern(format);
	}
	
	@NonNull
	@GetMapping(version = "1")
	public DatetimeDtoV1 version1() {
		return new DatetimeDtoV1(formatter.format(ZonedDateTime.now()));
	}
	
	@NonNull
	@GetMapping(version = "2")
	public DatetimeDtoV2 version2() {
		var datetime = ZonedDateTime.now();
		return new DatetimeDtoV2(format, datetime, formatter.format(datetime));
	}
	
}
