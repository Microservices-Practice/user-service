package com.mymicroservices.user.ValueObjects;

import com.mymicroservices.user.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReponseTemplateVo {
	private User user;
	private Department department;

}
