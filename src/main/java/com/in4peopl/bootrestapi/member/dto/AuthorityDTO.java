package com.in4peopl.bootrestapi.member.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AuthorityDTO {

	private String authName; //PK. ROLE_ADMIN / ROLE_MEMBER
	private int authCode; // 1 / 2  - /읽기/매니징
}
