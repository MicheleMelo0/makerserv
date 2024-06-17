package com.platform.makerserv.dto;

import com.platform.makerserv.enums.UserTypeEnum;

public record RegisterDTO(
		String name,
		String personalID,
		String email,
		UserTypeEnum type,
		String birth,
		String phone,
		String address ) {}
