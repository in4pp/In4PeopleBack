package com.in4people.bootrestapi.member.entity;

import com.in4people.bootrestapi.deptandteam.entity.Department;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "AUTHORITY")
public class Authority {
	/* 다 대 다를 해소하기 위한 매핑 table.
	ManyToMany를 해소하기 위해 ManyToOne, oneToMany로 바꿔줬다.
	*  */

	@Id
	@Column(name = "AUTH_NUMBER")
	private int authNumber;   // 시퀀스 / 경우의 수 14개

	@ManyToOne
	@JoinColumn(name = "DEPARTMENT_CODE")
	private Department departmentCode;

	@Column(name = "AUTH_NAME")
	private String authName; //권한 명

	//ManyToOne
	//에서는
	//One이 필요하면 클래스 변수로,
	//필요없으면 기본 자료형으로 받아줌.
	//
	//oneToMany에서 Many가 필요하면 List로 받고, 아니면 안써줌
}





