package ua.od.whcrow.samples.spring.cloud.service.datetime;

import jakarta.annotation.PostConstruct;
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
	
	@GetMapping("/")
	public DatetimeDto hp() {
		var datetime = ZonedDateTime.now();
		return new DatetimeDto(format, datetime, formatter.format(datetime));
	}
	
}
