package com.example.emailschedular.models.controller;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.UUID;

import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.emailschedular.models.EmailRequest;
import com.example.emailschedular.models.EmailResponse;
import com.example.emailschedular.models.job.EmailJob;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/email")
public class EmailController {

	
	
	@Autowired
	private Scheduler scheduler;
	
	@PostMapping("/schedule-email")
	public ResponseEntity<EmailResponse> scheduleMail(@Valid @RequestBody EmailRequest emailRequest){
		try {
			
			ZonedDateTime dateTime = ZonedDateTime.of(emailRequest.getTime(),emailRequest.getZoneid());
			if(dateTime.isBefore(ZonedDateTime.now())) {
				EmailResponse emailResponse = new EmailResponse(false,"Schedule Process is Incomplete");
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(emailResponse);
			}
			JobDetail jobDetail = createJobDetail(emailRequest);
			Trigger trigger = getTrigger(jobDetail,dateTime);
			scheduler.scheduleJob(jobDetail, trigger);
			EmailResponse emailResponse = new EmailResponse(true,jobDetail.getKey().getName(),jobDetail.getKey().getGroup(),"Schedule Process is completed");
			return ResponseEntity.ok(emailResponse);
		} catch (SchedulerException e) {
			e.printStackTrace();
			EmailResponse emailResponse = new EmailResponse(false,"Schedule Process is Incomplete");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(emailResponse);
		}
	}
	
	public JobDetail createJobDetail(EmailRequest emailRequest) {
		
		JobDataMap jobDataMap = new JobDataMap();
		jobDataMap.put("email", emailRequest.getEmail());
		jobDataMap.put("subject", emailRequest.getSubject());
		jobDataMap.put("body", emailRequest.getBody());
		
		JobDetail jobDetail = JobBuilder.newJob(EmailJob.class)
					.withIdentity(UUID.randomUUID().toString())
					.withDescription("Job for Email")
					.setJobData(jobDataMap)
					.storeDurably()    // to persist job in database without triggering it
					.build();
		
		return jobDetail;
	}
	
	public Trigger getTrigger(JobDetail jobDetail, ZonedDateTime dateTime) {
		
		Trigger trigger = TriggerBuilder.newTrigger()
		.forJob(jobDetail)
		.withIdentity(jobDetail.getKey().getName(), "email-triggers")
		.withDescription("TriggerForEmail")
		.startAt(Date.from(dateTime.toInstant()))
		.withSchedule(SimpleScheduleBuilder.simpleSchedule())
		.build();
		
		return trigger;
	}
	
	
}
