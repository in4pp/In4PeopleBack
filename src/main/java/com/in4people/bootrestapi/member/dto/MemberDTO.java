package com.in4people.bootrestapi.member.dto;


import com.in4people.bootrestapi.deptandteam.dto.DepartmentDTO;
import com.in4people.bootrestapi.deptandteam.dto.TeamDTO;
import com.in4people.bootrestapi.position.dto.PositionDTO;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberDTO implements UserDetails {

    private String memCode; //사원번호 PK
    private String memName;
    private String password;
    private String regiNumber;
    private char gender;
    private String phone;
    private String email;
    private String nationality;
    private String memPic;
    private char isMarried;
    private char isWorking;  // 재직구분
    private String address;


    // FK
    private DepartmentDTO departmentCode; // 부서코드
    private TeamDTO teamCode; // 팀코드
    private PositionDTO positionCode; // 직급코드

    // 다 대 다 -> 일 대 다  + 일 대 다
    private List<MemAuthorityDTO> memAuthorityList; // 권한 목록

    /* 이하 코드들을 UserDetails로부터 물려받는 추상메소드들을 오버라이딩 한 것이다.(필요한 것만 작성하자) */
    /* MemberDTO는 Member와 매핑 될 DTO이자 UserDetails로써 속성을 추가로 가짐 */
    private Collection<GrantedAuthority> authorities;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {return authorities;}

    @Override
    public String getUsername() {return null;}

    @Override
    public boolean isAccountNonExpired() {return false;}

    @Override
    public boolean isAccountNonLocked() {return false;}

    @Override
    public boolean isCredentialsNonExpired() {return false;}

    @Override
    public boolean isEnabled() {return false;}

}
