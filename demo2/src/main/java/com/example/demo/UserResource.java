package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/rest/user")
public class UserResource {
	
	@GetMapping
	@ApiOperation(value="유저목록", notes="유저목록을 조회한다")
	public List<User> getUsers() {
		return Arrays.asList(
				new User("Sam", 2000L),
				new User("Peter", 1000L)
		);
	}
	
	@GetMapping("{userName}")
	@ApiOperation(value="유저이름", notes="유저이름을 가져온다")
	public User getUser(@PathVariable("userName") final String userName) {
		return new User(userName, 1000L);
	}
	
	private class User {
		
		@ApiModelProperty(example="유저이름")
		private String userName;
		
		@ApiModelProperty(example="유저월급")
		private Long salary;
		
		public User(String userName, Long salary) {
			this.userName = userName;
			this.salary = salary;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public Long getSalary() {
			return salary;
		}

		public void setSalary(Long salary) {
			this.salary = salary;
		}
		
		
		
		
	}
}
