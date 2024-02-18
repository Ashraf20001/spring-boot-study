package com.example.emailschedular.models.job;

import java.nio.charset.StandardCharsets;

import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.quartz.QuartzJobBean;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

public class EmailJob extends QuartzJobBean{

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private MailProperties mailProperties;
	
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		           JobDataMap jobDataMap = context.getMergedJobDataMap();
//		           JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
		           
		           String sendEmail = jobDataMap.getString("email");
		           String subject = jobDataMap.getString("subject");
		           String body = jobDataMap.getString("body");
		           
		           sendMail(mailProperties.getUsername(),sendEmail,subject,body);
	}

	private void sendMail(String username, String sendEmail, String subject, String body) {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		
		MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, StandardCharsets.UTF_8.toString());
		
		try {
			messageHelper.setSubject(subject);
			messageHelper.setText(body, true);
			messageHelper.setFrom(username);
			messageHelper.setTo(sendEmail);
			
			javaMailSender.send(mimeMessage);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
