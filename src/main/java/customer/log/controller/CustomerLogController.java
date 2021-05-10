package customer.log.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import customer.log.model.CustomerLog;
import customer.log.service.CustomerService;

@RestController
public class CustomerLogController {
	
	@Autowired
	CustomerService service;
	
	@GetMapping("/checkIn")
	public String checkIn(@RequestParam(name="name") String name) {
		String date = String.valueOf(java.time.LocalDate.now());
		String hours = String.valueOf(java.time.LocalTime.now().getHour());
		String min = String.valueOf(java.time.LocalTime.now().getMinute());
		String sec = String.valueOf(java.time.LocalTime.now().getSecond());
		String time = hours+":"+min+":"+sec;
		String id = name+time;
		String log = "IN";
		service.saveInLog(new CustomerLog(id,name,log,date,time));
		
		return "CheckIn Details stored";
	}
	
	
	@GetMapping("/checkOut")
	public String checkOut(@RequestParam(name="name") String name) {
		String date = String.valueOf(java.time.LocalDate.now());
		String hours = String.valueOf(java.time.LocalTime.now().getHour());
		String min = String.valueOf(java.time.LocalTime.now().getMinute());
		String sec = String.valueOf(java.time.LocalTime.now().getSecond());
		String time = hours+":"+min+":"+sec;
		String id = name+time;
		String log = "OUT";
		service.saveInLog(new CustomerLog(id,name,log,date,time));
		
		return "CheckOut Details stored";
	}
	
	@GetMapping("/getLog")
	public ArrayList<CustomerLog> getByDate(@RequestParam(name="date") String date){
		String temp[]=date.split("[/]");
		String check="";
		for(int i=0;i<temp.length;i++) {
			check+=temp[i]+"-";
		}
		String verify=check.substring(0,check.length()-1);
		ArrayList<CustomerLog> arr = service.getLog(verify);
		
		return arr;
	}
	
	@GetMapping("/getAllLog")
	public ArrayList<CustomerLog> AllLog(){
		ArrayList<CustomerLog> arr = service.getAllLog();
		
		return arr;
	}
}
