package com.kevin.sp04.order.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.kevin.sp01.pojo.User;
import com.kevin.sp01.util.JsonResult;


@FeignClient(name="user-service", fallback = UserFeignServiceFB.class)
public interface UserFeignService {
	@GetMapping("/{userId}")
	JsonResult<User> getUser(@PathVariable Integer userId);

	@GetMapping("/{userId}/score") 
	JsonResult addScore(@PathVariable Integer userId, @RequestParam Integer score);
}
