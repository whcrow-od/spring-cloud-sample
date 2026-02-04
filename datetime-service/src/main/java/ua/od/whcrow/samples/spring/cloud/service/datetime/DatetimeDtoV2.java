package ua.od.whcrow.samples.spring.cloud.service.datetime;

import java.time.ZonedDateTime;

record DatetimeDtoV2(
		String format,
		ZonedDateTime dateTime,
		String formattedDateTime
) {};
